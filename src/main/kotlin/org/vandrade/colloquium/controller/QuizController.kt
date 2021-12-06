package org.vandrade.colloquium.controller

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.web.bind.annotation.*
import org.vandrade.colloquium.dao.AnswerDAO
import org.vandrade.colloquium.dao.QuestionDAO
import org.vandrade.colloquium.dao.QuizDAO
import org.vandrade.colloquium.dao.ResultDAO
import org.vandrade.colloquium.generated.tables.pojos.Statistics
import org.vandrade.colloquium.service.IQuestionService
import org.vandrade.colloquium.service.IQuizService

/**
 * Author: Vitor Andrade
 * Date: 12/6/21
 * Time: 9:36 AM
 */

@RestController
@RequestMapping("/quiz")
class QuizController(
    val quizService: IQuizService,
    val questionService: IQuestionService
) {
    companion object {
        val LOGGER = LoggerFactory.getLogger(QuizController::class.java)
    }

    /**
     * Get a quiz by its id
     */
    @GetMapping("/{id}")
    fun getQuiz(@PathVariable id: Int): ResponseEntity<QuizDAO> {
        return when (val ret = quizService.getQuiz(id)) {
            null -> ResponseEntity.notFound().build()
            else -> ResponseEntity.ok(ret)
        }
    }

    /**
     * Generate a new quiz
     */
    @PostMapping("/start")
    fun startQuiz(@AuthenticationPrincipal principal: OAuth2User?): ResponseEntity<QuizDAO> {
        return try {
            val ret = quizService.generateQuiz(principal)
            ResponseEntity.ok(ret)
        } catch (error: Exception) {
            LOGGER.error(error.toString())
            ResponseEntity.internalServerError().build()
        }
    }

    /**
     * Use a lifeline
     */
    @PostMapping("/{id}/use-lifeline/{lifelineTemplateId}")
    fun useLifeline(@PathVariable id: Int, @PathVariable lifelineTemplateId: Int): ResponseEntity<QuizDAO> {
        return when (quizService.useQuizLifeline(id, lifelineTemplateId)) {
            0 -> ResponseEntity.badRequest().build() // no rows affected
            1 -> ResponseEntity.noContent().build() // 1 row affected
            else -> ResponseEntity.internalServerError().build() // multiple rows affected so that is a problem
        }
    }

    /**
     * Fetch the next question for the provided quiz
     */
    @GetMapping("/{id}/next-question")
    fun getNextQuestion(@PathVariable id: Int): ResponseEntity<QuestionDAO> {
        return when (val ret = questionService.getNextUnansweredQuestionByQuiz(id)) {
            null -> {
                quizService.generateStatistics(id) // when there are no more question generate the statistics for the quiz
                ResponseEntity.notFound().build()
            }
            else -> ResponseEntity.ok(ret)
        }
    }

    /**
     * Answer a question
     */
    @PostMapping("/{id}/answer-question/{questionTemplateId}")
    fun answerQuestion(@PathVariable id: Int, @PathVariable questionTemplateId: Int, @RequestBody answer: AnswerDAO): ResponseEntity<ResultDAO> {
        return try {
            return when (val ret = questionService.answerQuestion(id, questionTemplateId, answer)) {
                null -> ResponseEntity.badRequest().build() // the question has already been answered
                else -> ResponseEntity.ok(ret)
            }
        } catch (error: Exception) {
            LOGGER.error(error.toString())
            ResponseEntity.internalServerError().build()
        }
    }

    /**
     * This endpoint only exists for testing purposes
     */
    @GetMapping("/{id}/statistics")
    fun getQuizStatistics(@PathVariable id: Int): ResponseEntity<Statistics> {
        return when (val ret = quizService.getStatistics(id)) {
            null -> {
                ResponseEntity.notFound().build()
            }
            else -> ResponseEntity.ok(ret)
        }
    }
}