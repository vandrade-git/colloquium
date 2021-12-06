package org.vandrade.colloquium.repository.impl

import org.jooq.DSLContext
import org.springframework.stereotype.Repository
import org.vandrade.colloquium.generated.Tables
import org.vandrade.colloquium.generated.tables.pojos.QuestionTemplate
import org.vandrade.colloquium.repository.IQuestionRepository

/**
 * Author: Vitor Andrade
 * Date: 12/6/21
 * Time: 12:22 PM
 */

@Repository
class QuestionRepository(val jooq: DSLContext) : IQuestionRepository {
    // IRepository >>
    override fun findOne(id: Int): QuestionTemplate? =
        jooq
            .select(*Tables.QUESTION_TEMPLATE.fields())
            .from(Tables.QUESTION_TEMPLATE)
            .where(Tables.QUESTION_TEMPLATE.ID.eq(id))
            .fetchOne()
            ?.into(QuestionTemplate::class.java)

    override fun findAll(): Collection<QuestionTemplate> {
        TODO("Not yet implemented")
    }

    override fun findAll(ids: Collection<Int>): Collection<QuestionTemplate> {
        TODO("Not yet implemented")
    }

    override fun save(entity: QuestionTemplate): QuestionTemplate {
        TODO("Not yet implemented")
    }

    override fun save(entities: Collection<QuestionTemplate>): Collection<QuestionTemplate> {
        TODO("Not yet implemented")
    }

    override fun exists(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun count(): Long {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int): Int {
        TODO("Not yet implemented")
    }

    override fun delete(entities: Collection<QuestionTemplate>) {
        TODO("Not yet implemented")
    }
    // << IRepository

    // IQuestionRepository >>
    override fun findUnansweredByQuiz(quizId: Int): Collection<QuestionTemplate> =
        jooq
            .select(*Tables.QUESTION_TEMPLATE.fields())
            .from(Tables.QUESTION_TEMPLATE)
            .join(Tables.QUIZ_QUESTION)
            .on(Tables.QUESTION_TEMPLATE.ID.eq(Tables.QUIZ_QUESTION.QUESTION_TEMPLATE_ID))
            .and(Tables.QUIZ_QUESTION.QUIZ_ID.eq(quizId))
            .where(Tables.QUIZ_QUESTION.ANSWERED.eq(false))
            .fetch()
            .into(QuestionTemplate::class.java)

    override fun findNextUnansweredByQuiz(quizId: Int): QuestionTemplate? =
        jooq
            .select(*Tables.QUESTION_TEMPLATE.fields())
            .from(Tables.QUESTION_TEMPLATE)
            .join(Tables.QUIZ_QUESTION)
            .on(Tables.QUESTION_TEMPLATE.ID.eq(Tables.QUIZ_QUESTION.QUESTION_TEMPLATE_ID))
            .and(Tables.QUIZ_QUESTION.QUIZ_ID.eq(quizId))
            .where(Tables.QUIZ_QUESTION.ANSWERED.eq(false))
            .fetchAny()
            ?.into(QuestionTemplate::class.java)

    override fun saveAnswer(quizId: Int, questionTemplateId: Int, answer: Int?, timeRemaining: Int): Int =
        jooq
            .update(Tables.QUIZ_QUESTION)
            .set(Tables.QUIZ_QUESTION.ANSWER, answer)
            .set(Tables.QUIZ_QUESTION.TIME_REMAINING, timeRemaining)
            .set(Tables.QUIZ_QUESTION.ANSWERED, true)
            .where(Tables.QUIZ_QUESTION.QUIZ_ID.eq(quizId))
            .and(Tables.QUIZ_QUESTION.QUESTION_TEMPLATE_ID.eq(questionTemplateId))
            .and(Tables.QUIZ_QUESTION.ANSWERED.eq(false))
            .execute()
    // << IQuestionRepository
}