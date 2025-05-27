package com.jessica.buddy.home.presentation.screen.checkin

import androidx.lifecycle.ViewModel
import com.jessica.buddy.core.data.local.user.UserLocalDataSource
import com.jessica.buddy.home.data.checkin.local.CheckInLocalDataSource
import com.jessica.buddy.home.data.checkin.model.CheckInData
import org.koin.android.annotation.KoinViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

data class CheckInState(
    val userName: String? = null,
    val moodPoint: Int? = null,
    val sleepHours: Int? = null
) {
    val submitEnabled get() = moodPoint != null && sleepHours != null
}

sealed interface CheckInEvent {
    data class OnMoodPointChange(val moodPoint: Int) : CheckInEvent
    data class OnSleepHoursChange(val sleepHours: Int) : CheckInEvent
    data object SubmitCheckIn : CheckInEvent
    data object OnSubmitCheckIn : CheckInEvent
}

@KoinViewModel
class CheckInViewModel(
    userLocalDataSource: UserLocalDataSource,
    private val checkInLocalDataSource: CheckInLocalDataSource
) : ViewModel(), ContainerHost<CheckInState, CheckInEvent> {
    override val container: Container<CheckInState, CheckInEvent> = container(
        initialState = CheckInState(
            userName = userLocalDataSource.getUserData().getOrNull()?.userName
        )
    )

    fun onEvent(event: CheckInEvent) = intent {
        when (event) {
            is CheckInEvent.OnMoodPointChange -> {
                reduce { state.copy(moodPoint = event.moodPoint) }
            }

            is CheckInEvent.OnSleepHoursChange -> {
                reduce { state.copy(sleepHours = event.sleepHours) }
            }

            CheckInEvent.SubmitCheckIn -> {
                checkInLocalDataSource.checkIn(
                    CheckInData(
                        mood = state.moodPoint ?: 0,
                        sleepHours = state.sleepHours ?: 0,
                        submittedDate = System.currentTimeMillis()
                    )
                )
                reduce { state.copy(moodPoint = null, sleepHours = null) }
                postSideEffect(CheckInEvent.OnSubmitCheckIn)
            }

            CheckInEvent.OnSubmitCheckIn -> Unit
        }
    }
}
