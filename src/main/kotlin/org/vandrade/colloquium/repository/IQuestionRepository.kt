package org.vandrade.colloquium.repository

import org.jooq.lambda.tuple.Tuple0
import org.vandrade.colloquium.generated.tables.pojos.QuestionTemplate

/**
 * Author: Vitor Andrade
 * Date: 12/6/21
 * Time: 11:10 AM
 */

interface IQuestionRepository: IRepository<QuestionTemplate, Int, Tuple0> {
    fun findUnansweredByQuiz(quizId: Int): Collection<QuestionTemplate>

    fun findNextUnansweredByQuiz(quizId: Int): QuestionTemplate?

    fun saveAnswer(quizId: Int, questionTemplateId: Int, answer: Int?, timeRemaining: Int): Int
}