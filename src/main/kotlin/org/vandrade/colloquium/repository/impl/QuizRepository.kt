package org.vandrade.colloquium.repository.impl

import net.minidev.json.JSONObject
import org.jooq.DSLContext
import org.jooq.impl.DSL
import org.springframework.stereotype.Repository
import org.vandrade.colloquium.generated.Tables
import org.vandrade.colloquium.generated.tables.pojos.*
import org.vandrade.colloquium.repository.IQuizRepository
import java.util.*

/**
 * Author: Vitor Andrade
 * Date: 12/6/21
 * Time: 9:58 AM
 */

@Repository
class QuizRepository(val jooq: DSLContext) : IQuizRepository {
    // IRepository >>
    override fun findOne(id: Int): Quiz? =
        jooq
            .select(*Tables.QUIZ.fields())
            .from(Tables.QUIZ)
            .where(Tables.QUIZ.ID.eq(id))
            .fetchOne()
            ?.into(Quiz::class.java)

    override fun findAll(): Collection<Quiz> {
        TODO("Not yet implemented")
    }

    override fun findAll(ids: Collection<Int>): Collection<Quiz> {
        TODO("Not yet implemented")
    }

    override fun save(entity: Quiz): Quiz {
        TODO("Not yet implemented")
    }

    override fun save(entities: Collection<Quiz>): Collection<Quiz> {
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

    override fun delete(entities: Collection<Quiz>) {
        TODO("Not yet implemented")
    }
    // << IRepository

    // IQuizRepository >>
    override fun generate(owner: String): Quiz {
        val ret =
            jooq
                .insertInto(Tables.QUIZ, Tables.QUIZ.OWNER)
                .values(owner)
                .returning(*Tables.QUIZ.fields())
                .fetchOne()
                ?.into(Quiz::class.java) ?: throw RuntimeException("Something went wrong")

        // generate quiz lifelines
        val lifelineTemplates =
            jooq
                .select(Tables.LIFELINE_TEMPLATE.ID, DSL.inline(ret.id))
                .from(Tables.LIFELINE_TEMPLATE)
                .fetch()

        jooq
            .insertInto(Tables.QUIZ_LIFELINE, Tables.QUIZ_LIFELINE.LIFELINE_TEMPLATE_ID, Tables.QUIZ_LIFELINE.QUIZ_ID)
            .valuesOfRecords(lifelineTemplates)
            .execute()

        // generate quiz questions
        val questionTemplates =
            jooq
                .select(Tables.QUESTION_TEMPLATE.ID, DSL.inline(ret.id))
                .from(Tables.QUESTION_TEMPLATE)
                .fetch()

        jooq
            .insertInto(Tables.QUIZ_QUESTION, Tables.QUIZ_QUESTION.QUESTION_TEMPLATE_ID, Tables.QUIZ_LIFELINE.QUIZ_ID)
            .valuesOfRecords(questionTemplates)
            .execute()

        return ret
    }

    override fun generateStatistics(id: Int) {
        val statistics = hashMapOf<String, Any>()

        val quiz = findOne(id) ?: return
        statistics["quizId"] = quiz.id

        val lifelinesUsed =
            jooq
                .select(*Tables.LIFELINE_TEMPLATE.fields())
                .from(Tables.QUIZ_LIFELINE)
                .join(Tables.LIFELINE_TEMPLATE)
                .on(Tables.QUIZ_LIFELINE.LIFELINE_TEMPLATE_ID.eq(Tables.LIFELINE_TEMPLATE.ID))
                .where(Tables.QUIZ_LIFELINE.QUIZ_ID.eq(id))
                .and(Tables.QUIZ_LIFELINE.USED.eq(true))
                .fetch()
                .into(LifelineTemplate::class.java)
        statistics["lifelinesUsed"] = lifelinesUsed

        val correctAnswers =
            jooq
                .select(DSL.count(Tables.QUIZ_QUESTION.ID))
                .from(Tables.QUIZ_QUESTION)
                .join(Tables.QUESTION_TEMPLATE)
                .on(Tables.QUIZ_QUESTION.QUESTION_TEMPLATE_ID.eq(Tables.QUESTION_TEMPLATE.ID))
                .where(Tables.QUIZ_QUESTION.QUIZ_ID.eq(id))
                .and(Tables.QUIZ_QUESTION.ANSWERED.eq(true))
                .and(Tables.QUIZ_QUESTION.ANSWER.eq(Tables.QUESTION_TEMPLATE.CORRECT_ANSWER))
                .fetch()
                .into(Int::class.java)

        statistics["correctAnswers"] = correctAnswers

        val averageTimeRemaining =
            jooq
                .select(DSL.avg(Tables.QUIZ_QUESTION.TIME_REMAINING))
                .from(Tables.QUIZ_QUESTION)
                .join(Tables.QUESTION_TEMPLATE)
                .on(Tables.QUIZ_QUESTION.QUESTION_TEMPLATE_ID.eq(Tables.QUESTION_TEMPLATE.ID))
                .where(Tables.QUIZ_QUESTION.QUIZ_ID.eq(id))
                .and(Tables.QUIZ_QUESTION.ANSWERED.eq(true))
                .fetchOne()
                ?.into(Float::class.java) ?: 0
        statistics["averageTimeRemaining"] = averageTimeRemaining

        jooq
            .insertInto(Tables.STATISTICS, Tables.STATISTICS.QUIZ_ID, Tables.STATISTICS.DATA)
            .values(quiz.id, JSONObject(statistics).toJSONString())
            .execute()
    }

    override fun findStatisticsById(id: Int): Statistics? =
        jooq
            .select(*Tables.STATISTICS.fields())
            .from(Tables.STATISTICS)
            .where(Tables.STATISTICS.QUIZ_ID.eq(id))
            .fetchOne()
            ?.into(Statistics::class.java)
    // << IQuizRepository
}