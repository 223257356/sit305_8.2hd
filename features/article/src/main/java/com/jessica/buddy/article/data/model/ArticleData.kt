package com.jessica.buddy.article.data.model

data class ArticleData(
    val id: String,
    val imageUrl: String,
    val title: String,
    val author: String,
    val date: String,
    val content: String,
    val isFavorite: Boolean
) {
    companion object {
        fun mocked() = listOf(
            ArticleData(
                id = "1",
                imageUrl = "https://img.freepik.com/premium-photo/tree-life_780593-3706.jpg",
                title = "Start Your Day Right: The Power of a Morning Routine",
                author = "Sarah Bennett",
                date = "1 day ago",
                content = "A consistent morning routine helps boost " +
                    "productivity and mental clarity. Learn how to " +
                    "design one that suits your lifestyle.",
                isFavorite = false
            ),
            ArticleData(
                id = "2",
                imageUrl = "https://img.freepik.com/premium-photo/tree-life_780593-3706.jpg",
                title = "The Habit of Gratitude: Small Change, Big Impact",
                author = "Daniel Reed",
                date = "2 days ago",
                content = "Practicing daily gratitude can increase " +
                    "happiness and improve relationships. " +
                    "Discover easy ways to make it a habit.",
                isFavorite = false
            ),
            ArticleData(
                id = "3",
                imageUrl = "https://img.freepik.com/premium-photo/tree-life_780593-3706.jpg",
                title = "Why Reading Daily Improves Your Brain",
                author = "Amanda Cole",
                date = "3 days ago",
                content = "Reading just 20 minutes a day stimulates " +
                    "the mind, reduces stress, and builds knowledge. " +
                    "Here's how to make it stick.",
                isFavorite = false
            ),
            ArticleData(
                id = "4",
                imageUrl = "https://img.freepik.com/premium-photo/tree-life_780593-3706.jpg",
                title = "Drink More Water: A Simple Health Habit",
                author = "Mark Taylor",
                date = "4 days ago",
                content = "Staying hydrated is essential for health " +
                    "and energy. Learn how to build a water-drinking " +
                    "habit without effort.",
                isFavorite = false
            ),
            ArticleData(
                id = "5",
                imageUrl = "https://img.freepik.com/premium-photo/tree-life_780593-3706.jpg",
                title = "Digital Detox: Reclaim Your Time and Focus",
                author = "Jessica Moore",
                date = "5 days ago",
                content = "Too much screen time? A digital detox " +
                    "habit can help you regain clarity and " +
                    "mental space. Start small and grow.",
                isFavorite = false
            ),
            ArticleData(
                id = "6",
                imageUrl = "https://img.freepik.com/premium-photo/tree-life_780593-3706.jpg",
                title = "The 10-Minute Tidy: Keep Your Space Clean Daily",
                author = "Chris Nolan",
                date = "6 days ago",
                content = "A cleaner space equals a clearer mind. " +
                    "The 10-minute tidy habit helps you stay " +
                    "organized without feeling overwhelmed.",
                isFavorite = false
            ),
            ArticleData(
                id = "7",
                imageUrl = "https://img.freepik.com/premium-photo/tree-life_780593-3706.jpg",
                title = "Daily Journaling: Reflect, Learn, Grow",
                author = "Emily Watson",
                date = "7 days ago",
                content = "Journaling is a powerful tool for " +
                    "self-reflection and growth. " +
                    "Here’s how to build it into your daily life.",
                isFavorite = false
            ),
            ArticleData(
                id = "8",
                imageUrl = "https://img.freepik.com/premium-photo/tree-life_780593-3706.jpg",
                title = "Get Moving: The Habit of Daily Walking",
                author = "Oliver Grant",
                date = "8 days ago",
                content = "Walking daily improves physical " +
                    "and mental health. Learn how to " +
                    "incorporate walks into even the busiest schedule.",
                isFavorite = false
            ),
            ArticleData(
                id = "9",
                imageUrl = "https://img.freepik.com/premium-photo/tree-life_780593-3706.jpg",
                title = "The Power of Saying No: Boundaries as a Habit",
                author = "Rachel Adams",
                date = "9 days ago",
                content = "Saying no is a powerful habit that " +
                    "protects your energy and priorities. " +
                    "Learn how to set boundaries with confidence.",
                isFavorite = false
            ),
            ArticleData(
                id = "10",
                imageUrl = "https://img.freepik.com/premium-photo/tree-life_780593-3706.jpg",
                title = "Evening Reflection: How to End Your Day with Intention",
                author = "Liam Cooper",
                date = "10 days ago",
                content = "A nightly reflection habit brings " +
                    "closure, gratitude, and awareness." +
                    " Discover simple steps to begin tonight.",
                isFavorite = false
            )
        )
    }
}
