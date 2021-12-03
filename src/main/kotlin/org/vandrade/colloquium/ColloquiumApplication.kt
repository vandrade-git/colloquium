package org.vandrade.colloquium

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ColloquiumApplication

fun main(args: Array<String>) {
    runApplication<ColloquiumApplication>(*args)
}
