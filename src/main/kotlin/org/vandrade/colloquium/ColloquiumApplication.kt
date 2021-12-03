package org.vandrade.colloquium

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration
import org.springframework.boot.runApplication

/**
 * Author: Vitor Andrade
 * Date: 12/3/21
 * Time: 12:25 PM
 */

@SpringBootApplication(exclude = [R2dbcAutoConfiguration::class])
class ColloquiumApplication

fun main(args: Array<String>) {
    runApplication<ColloquiumApplication>(*args)
}
