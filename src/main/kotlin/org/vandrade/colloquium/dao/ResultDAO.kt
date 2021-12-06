package org.vandrade.colloquium.dao

/**
 * Author: Vitor Andrade
 * Date: 12/6/21
 * Time: 1:04 PM
 */

data class ResultDAO(
    val submittedAnswer: Int?,
    val correctAnswer: Int,
    val timeRemaining: Int,
    val lifelinesUsed: Array<Int>?
)
