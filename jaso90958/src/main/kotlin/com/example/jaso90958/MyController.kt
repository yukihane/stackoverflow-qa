package com.example.jaso90958

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MyController(
    private val myMapper: MyMapper,
) {

    @GetMapping
    fun index(): String{
        val res = myMapper.findByOrderIds(listOf("1"))
        return res.toString()
    }
}