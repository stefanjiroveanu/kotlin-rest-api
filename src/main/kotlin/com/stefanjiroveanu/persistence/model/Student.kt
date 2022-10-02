package com.stefanjiroveanu.persistence.model

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.PrePersist

@Entity
class Student(
    var data: String?,
    var uuid: String?,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long
) {
    constructor() : this("", "", 0)
    @PrePersist
    fun prePersistUuid() {
        if (uuid.isNullOrBlank()) {
            uuid = UUID.randomUUID().toString()
        }
    }
}