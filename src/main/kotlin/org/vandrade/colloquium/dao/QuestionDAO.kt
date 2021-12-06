package org.vandrade.colloquium.dao

/**
 * Author: Vitor Andrade
 * Date: 12/6/21
 * Time: 12:26 PM
 */

data class QuestionDAO(
    val quizId: Int,
    val questionTemplateId: Int,
    val contents: String,
    val answer1: String,
    val answer2: String,
    val answer3: String,
    val answer4: String,
    val timeRemaining: Int
)
