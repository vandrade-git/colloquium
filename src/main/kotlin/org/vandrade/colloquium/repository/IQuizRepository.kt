package org.vandrade.colloquium.repository

import org.jooq.lambda.tuple.Tuple0
import org.springframework.transaction.annotation.Transactional
import org.vandrade.colloquium.generated.tables.pojos.Quiz
import org.vandrade.colloquium.generated.tables.pojos.Statistics

/**
 * Author: Vitor Andrade
 * Date: 12/6/21
 * Time: 9:57 AM
 */

interface IQuizRepository : IRepository<Quiz, Int, Tuple0> {
    @Transactional
    fun generate(owner: String): Quiz

    @Transactional
    fun generateStatistics(id: Int)

    @Transactional(readOnly = true)
    fun findStatisticsById(id: Int): Statistics?
}