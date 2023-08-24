package com.example.a22bytetest.data.repos

import com.example.a22bytetest.R

class QuizScreenRepo : QuizScreenRepository {

    private val correctAnswers: MutableMap<Int, Int> = mutableMapOf(
        R.drawable.a_street_cat_named_bob_cover to R.string.a_street_cat_bob,
        R.drawable.alisa_in_wonderland_cover to R.string.alisa,
        R.drawable.bim_cover to R.string.bim,
        R.drawable.capital_cover to R.string.capital,
        R.drawable.fighting_club_cover to R.string.fighting_club,
        R.drawable.first_teacher_cover to R.string.first_teacher,
        R.drawable.harry_potter_cover to R.string.harry_potter,
        R.drawable.it_cover to R.string.it,
        R.drawable.snaff_coverjpg to R.string.snaff,
        R.drawable.suffocation_cover to R.string.suffocation,
        R.drawable.war_and_peace_cover to R.string.war_and_peace,
        R.drawable.empire_v_cover to R.string.empire_v,
        R.drawable.doctor_zhivago_cover to R.string.doctor_zhivago,
    )

    private val availableImageIds: MutableList<Int> = correctAnswers.keys.toMutableList()

    override suspend fun getRandomImages(): List<Int> {
        return availableImageIds.shuffled().take(3)
    }

    override suspend fun removeImage(imageId: Int) {
        availableImageIds.remove(imageId)
    }

    override suspend fun getCorrectAnswerForImage(imageId: Int): Int? {
        return correctAnswers[imageId]
    }
}
