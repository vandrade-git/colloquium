package org.vandrade.colloquium.repository.impl

import org.jooq.DSLContext
import org.springframework.stereotype.Repository
import org.vandrade.colloquium.generated.Tables
import org.vandrade.colloquium.generated.tables.pojos.LifelineTemplate
import org.vandrade.colloquium.repository.ILifelineRepository

/**
 * Author: Vitor Andrade
 * Date: 12/6/21
 * Time: 11:04 AM
 */

@Repository
class LifelineRepository(val jooq: DSLContext) : ILifelineRepository {
    // IRepository >>
    override fun findOne(id: Int): LifelineTemplate? =
        jooq
            .select(*Tables.LIFELINE_TEMPLATE.fields())
            .from(Tables.LIFELINE_TEMPLATE)
            .where(Tables.LIFELINE_TEMPLATE.ID.eq(id))
            .fetchOne()
            ?.into(LifelineTemplate::class.java)

    override fun findAll(): Collection<LifelineTemplate> {
        TODO("Not yet implemented")
    }

    override fun findAll(ids: Collection<Int>): Collection<LifelineTemplate> {
        TODO("Not yet implemented")
    }

    override fun save(entity: LifelineTemplate): LifelineTemplate {
        TODO("Not yet implemented")
    }

    override fun save(entities: Collection<LifelineTemplate>): Collection<LifelineTemplate> {
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

    override fun delete(entities: Collection<LifelineTemplate>) {
        TODO("Not yet implemented")
    }
    // << IRepository

    // ILifelineRepository >>
    override fun findUnusedByQuiz(quizId: Int): Collection<LifelineTemplate> =
        jooq
            .select(*Tables.LIFELINE_TEMPLATE.fields())
            .from(Tables.LIFELINE_TEMPLATE)
            .join(Tables.QUIZ_LIFELINE)
            .on(Tables.LIFELINE_TEMPLATE.ID.eq(Tables.QUIZ_LIFELINE.LIFELINE_TEMPLATE_ID))
            .and(Tables.QUIZ_LIFELINE.QUIZ_ID.eq(quizId))
            .where(Tables.QUIZ_LIFELINE.USED.eq(false))
            .fetch()
            .into(LifelineTemplate::class.java)

    override fun setToUsed(quizId: Int, lifelineTemplateId: Int): Int =
        jooq
            .update(Tables.QUIZ_LIFELINE)
            .set(Tables.QUIZ_LIFELINE.USED, true)
            .where(Tables.QUIZ_LIFELINE.QUIZ_ID.eq(quizId))
            .and(Tables.QUIZ_LIFELINE.LIFELINE_TEMPLATE_ID.eq(lifelineTemplateId))
            .and(Tables.QUIZ_LIFELINE.USED.eq(false))
            .execute()
    // << ILifelineRepository
}