package org.vandrade.colloquium.service

import org.springframework.security.oauth2.core.user.OAuth2User
import org.vandrade.colloquium.dao.QuizDAO
import org.vandrade.colloquium.generated.tables.pojos.Statistics

/**
 * Author: Vitor Andrade
 * Date: 12/6/21
 * Time: 11:02 AM
 */

interface IQuizService {
    fun getQuiz(id: Int): QuizDAO?

    fun generateQuiz(principal: OAuth2User?): QuizDAO

    fun useQuizLifeline(id: Int, lifelineTemplateId: Int): Int

    fun generateStatistics(id: Int)

    fun getStatistics(id: Int): Statistics?
}