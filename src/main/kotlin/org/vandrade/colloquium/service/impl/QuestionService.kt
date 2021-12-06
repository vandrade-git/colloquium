package org.vandrade.colloquium.service.impl

import org.springframework.stereotype.Service
import org.vandrade.colloquium.dao.AnswerDAO
import org.vandrade.colloquium.dao.QuestionDAO
import org.vandrade.colloquium.dao.ResultDAO
import org.vandrade.colloquium.repository.IQuestionRepository
import org.vandrade.colloquium.service.IQuestionService

/**
 * Author: Vitor Andrade
 * Date: 12/6/21
 * Time: 12:45 PM
 */

@Service
class QuestionService(
    val questionRepository: IQuestionRepository
) : IQuestionService {
    override fun getNextUnansweredQuestionByQuiz(quizId: Int): QuestionDAO? {
        val question = questionRepository.findNextUnansweredByQuiz(quizId) ?: return null

        return QuestionDAO(quizId, question.id, question.contents, question.answer_1, question.answer_2, question.answer_3, question.answer_4, 15)
    }

    override fun answerQuestion(quizId: Int, questionTemplateId: Int, answer: AnswerDAO): ResultDAO? {
        val question = questionRepository.findOne(questionTemplateId) ?: return null

        return when (questionRepository.saveAnswer(quizId, questionTemplateId, answer.answer, answer.timeRemaining)) {
            0 -> null
            1 -> ResultDAO(answer.answer, question.correctAnswer, answer.timeRemaining, null)
            else -> throw RuntimeException("Something went wrong")
        }
    }
}