package com.billchau.springbootstudy1.student

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.IllegalStateException

@Service
class StudentService(val studentRepository: StudentRepository) {
    fun getStudents(): List<Student> {
//        return listOf(
//            Student(1L, "Jason", 18, LocalDate.now(), "a@l.com"),
//            Student(2L, "Mary", 18, LocalDate.now(), "b@l.com")
//        )
        return studentRepository.findAll()
    }

    fun addNewStudent(student: Student) {
        val s = studentRepository.findByEmail(student.email)

        s?.let {
            throw IllegalStateException("Email exists")
        }
        studentRepository.save(student)
    }

    fun deleteStudent(id: Long) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id)
        } else {
            throw IllegalStateException("Student with id $id does not exists")
        }
    }

    @Transactional
    fun updateStudent(studentId: Long, name: String?, email: String?) {
        val student = studentRepository.findById(studentId).orElseThrow {
            IllegalStateException("Student with id $studentId does not exist")
        }

        name?.let {
            if (it.isNotEmpty() && it != student.name) {
                student.name = it
            }
        }

        email?.let {
            println("$it vs $student.email")
            if (it.isNotEmpty() && it != student.email) {
                val anotherStudent = studentRepository.findByEmail(email)
                anotherStudent?.let {
                    throw IllegalStateException("Email exists")
                }
                student.email = it
            }
        }
    }
}