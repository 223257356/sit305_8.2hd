package com.jessica.buddy.core.data.remote

import com.jessica.buddy.core.data.model.ErrorModel

class ApiException(val errorModel: ErrorModel) : Exception(errorModel.error)
