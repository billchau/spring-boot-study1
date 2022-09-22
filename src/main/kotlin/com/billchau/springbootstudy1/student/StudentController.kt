package com.billchau.springbootstudy1.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("api/v1/student")
class StudentController(val studentService: StudentService) {

    @GetMapping
    fun getStudents(): List<Student> {
        return studentService.getStudents()
    }

    @PostMapping
    fun registerNewStudent(@RequestBody student: Student) {
        studentService.addNewStudent(student)
    }

    @DeleteMapping("{studentId}")
    fun deleteStudent(@PathVariable("studentId") id: Long) {
        studentService.deleteStudent(id)
    }

    @PutMapping("{studentId}")
    fun updateStudent(
        @PathVariable("studentId") studentId: Long,
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) email: String?
    ) {
        studentService.updateStudent(studentId, name, email)
    }
}