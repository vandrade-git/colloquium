package org.vandrade.colloquium.dao

/**
 * Author: Vitor Andrade
 * Date: 12/6/21
 * Time: 12:40 PM
 */

data class AnswerDAO(
    val answer: Int?,
    val timeRemaining: Int,
    val lifelinesUsed: Array<Int>?
)
