package com.stefanjiroveanu.controller

import com.stefanjiroveanu.persistence.model.Student
import com.stefanjiroveanu.service.StudentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/students")
class StudentController(private val studentService: StudentService) {

    @PostMapping
    fun save(@RequestBody student: Student): ResponseEntity<Student> {
        return ResponseEntity(studentService.save(student), HttpStatus.OK)
    }

    @GetMapping("/{uuid}")
    fun find(@PathVariable(value = "uuid") uuid: String): ResponseEntity<Student> {
        return ResponseEntity(studentService.find(uuid), HttpStatus.OK)
    }

    @DeleteMapping("/{uuid}")
    fun delete(@PathVariable(value = "uuid") uuid: String) {
        ResponseEntity(studentService.delete(uuid), HttpStatus.NO_CONTENT)
    }

    @PutMapping("/{uuid}")
    fun update(@PathVariable(value = "uuid") uuid: String, @RequestBody student: Student) {
        ResponseEntity(studentService.update(uuid, student), HttpStatus.OK)
    }
}