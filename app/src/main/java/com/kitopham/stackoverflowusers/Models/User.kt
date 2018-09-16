package com.kitopham.stackoverflowusers.Models



data class User(

    var location: String? = null,

    var profile_image: String? = null,

    var profileLink: String? = null,

    var answerCount: String? = null,

    var badge_counts: Badge_counts? = null,

    var display_name: String? = null,

    var about_me: String? = null,

    var reputation: String? = null,

    var websiteUrl: String? = null,

    var question_count: String? = null

)
