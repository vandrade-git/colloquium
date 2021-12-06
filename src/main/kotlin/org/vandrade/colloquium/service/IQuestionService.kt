package org.vandrade.colloquium.service

import org.vandrade.colloquium.dao.AnswerDAO
import org.vandrade.colloquium.dao.QuestionDAO
import org.vandrade.colloquium.dao.ResultDAO

/**
 * Author: Vitor Andrade
 * Date: 12/6/21
 * Time: 12:43 PM
 */

interface IQuestionService {
    fun getNextUnansweredQuestionByQuiz(quizId: Int): QuestionDAO?

    fun answerQuestion(quizId: Int, questionTemplateId: Int, answer: AnswerDAO): ResultDAO?
}