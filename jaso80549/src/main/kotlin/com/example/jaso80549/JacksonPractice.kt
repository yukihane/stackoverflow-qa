package com.example.jaso80549

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("json")
class JacksonPractice {

    @PostMapping(
        value=[""],
        consumes = ["application/json"]
    )
    fun postJsonData(@RequestBody json: String) {
        println("called getJsonData")
        println("----- json data -----")
        println(json)
        println("")
        val mapper = ObjectMapper().registerModules(KotlinModule(), JavaTimeModule())
        val jsonData = mapper.readValue<JsonData>(json)
        println("----- json serialize -----")
        println(jsonData)
    }
}
