package com.stefanjiroveanu.service.impl

import com.stefanjiroveanu.persistence.model.Student
import com.stefanjiroveanu.persistence.repository.StudentRepository
import com.stefanjiroveanu.service.StudentService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class StudentServiceImpl(private val studentRepository: StudentRepository) : StudentService {

    override fun find(uuid: String): Student {
        return studentRepository.findByUuid(uuid).orElseThrow { RuntimeException("No Student found with that uuid!") }
    }

    override fun save(student: Student): Student {
        return studentRepository.save(student)
    }

    override fun delete(uuid: String) {
        find(uuid)
        studentRepository.delete(find(uuid))
    }

    @Transactional
    override fun update(uuid: String, student: Student) {
        val toBeUpdated = find(uuid)
        toBeUpdated.data = student.data
        save(toBeUpdated)
    }
}