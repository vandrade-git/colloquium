package org.vandrade.colloquium.dao

import org.vandrade.colloquium.generated.tables.pojos.LifelineTemplate
import java.time.LocalDateTime

/**
 * Author: Vitor Andrade
 * Date: 12/6/21
 * Time: 11:00 AM
 */

data class QuizDAO(
    val id: Int,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val owner: String,
    val lifelines: List<LifelineTemplate>
)
