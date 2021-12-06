package org.vandrade.colloquium.repository

import org.jooq.lambda.tuple.Tuple0
import org.vandrade.colloquium.generated.tables.pojos.LifelineTemplate

/**
 * Author: Vitor Andrade
 * Date: 12/6/21
 * Time: 11:03 AM
 */

interface ILifelineRepository: IRepository<LifelineTemplate, Int, Tuple0> {
    /**
     * Retrieves the unused lifelines for the provided quiz.
     *
     * @param quizId must not be null.
     * @return the unused lifelines or an empty collection if there are none
     */
    fun findUnusedByQuiz(quizId: Int): Collection<LifelineTemplate>


    fun setToUsed(quizId: Int, lifelineTemplateId: Int): Int
}