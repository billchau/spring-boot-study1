package com.billchau.springbootstudy1.student

import java.time.LocalDate
import java.time.Period
import javax.persistence.*

@Entity
@Table
data class Student(
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence",
    )
    var id: Long?,
    var name: String,
    var dob: LocalDate,
    var email: String
) {
    val age: Int
        get() = Period.between(this.dob, LocalDate.now()).years
}
