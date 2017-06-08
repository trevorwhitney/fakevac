package com.trevorwhitney.fakevac

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import java.util.*

@SpringBootApplication
class FakeVacApplication {
}

fun main(args: Array<String>) {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
    SpringApplication.run(FakeVacApplication::class.java, *args)
}
