package org.vandrade.colloquium.service.impl

import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service
import org.vandrade.colloquium.dao.QuizDAO
import org.vandrade.colloquium.generated.tables.pojos.Statistics
import org.vandrade.colloquium.repository.ILifelineRepository
import org.vandrade.colloquium.repository.IQuizRepository
import org.vandrade.colloquium.service.IQuizService
import java.util.*

/**
 * Author: Vitor Andrade
 * Date: 12/6/21
 * Time: 9:41 AM
 */

@Service
class QuizService(
    val quizRepository: IQuizRepository,
    val lifelineRepository: ILifelineRepository
): IQuizService {
    override fun getQuiz(id: Int): QuizDAO? {
        val quiz = quizRepository.findOne(id) ?: return null
        val lifelines = lifelineRepository.findUnusedByQuiz(quiz.id)

        return QuizDAO(quiz.id, quiz.createdAt, quiz.updatedAt, quiz.owner, lifelines.toList())
    }

    override fun generateQuiz(principal: OAuth2User?): QuizDAO {
        val quiz = quizRepository.generate((principal?.getAttribute("login") ?: UUID.randomUUID()).toString())
        val lifelines = lifelineRepository.findUnusedByQuiz(quiz.id)

        return QuizDAO(quiz.id, quiz.createdAt, quiz.updatedAt, quiz.owner, lifelines.toList())
    }

    override fun useQuizLifeline(id: Int, lifelineTemplateId: Int): Int {
        return lifelineRepository.setToUsed(id, lifelineTemplateId)
    }

    override fun generateStatistics(id: Int) {
        quizRepository.generateStatistics(id)
    }

    override fun getStatistics(id: Int): Statistics? = quizRepository.findStatisticsById(id)
}