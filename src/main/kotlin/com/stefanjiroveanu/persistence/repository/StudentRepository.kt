package com.stefanjiroveanu.persistence.repository

import com.stefanjiroveanu.persistence.model.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface StudentRepository : JpaRepository<Student, Long> {
    fun findByUuid(uuid : String) : Optional<Student>
}