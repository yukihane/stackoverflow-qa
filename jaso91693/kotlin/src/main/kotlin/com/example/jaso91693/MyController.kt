package com.example.jaso91693

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MyController {

    @GetMapping
    fun get(): ResponseEntity<Any> {
        val resp = listOf(Member("a", true))
        return ResponseEntity(resp, HttpStatus.OK)
    }

}

class Member(
    val id: String,
    val isTestUser: Boolean,
)
