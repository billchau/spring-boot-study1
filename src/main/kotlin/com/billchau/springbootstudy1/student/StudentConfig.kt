package com.billchau.springbootstudy1.student

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDate
import java.time.Month

@Configuration
class StudentConfig {

    @Bean
    fun commandLineRunner(repository: StudentRepository) = CommandLineRunner {
        val jason = Student(null, "Jason", LocalDate.of(1999, Month.APRIL, 4), "a@l.com")
        val mary = Student(null, "Mary", LocalDate.of(2002, Month.APRIL, 5), "b@l.com")
        repository.saveAll(
            listOf(mary, jason )
        )
    }
}