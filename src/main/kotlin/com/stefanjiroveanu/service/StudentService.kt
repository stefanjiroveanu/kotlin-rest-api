package com.stefanjiroveanu.service

import com.stefanjiroveanu.persistence.model.Student

interface StudentService {
    fun find(uuid : String) : Student
    fun save(student: Student) : Student
    fun delete(uuid: String)
    fun update(uuid: String, student: Student)
}