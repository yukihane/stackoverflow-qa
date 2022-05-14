package com.github.yukihane.examples

import java.util.function.Function

fun main() {
    val p1 = Person("タケシ", 5)
    val p2 = Person("ケンタ", 5)
    val p3 = Person("ユミ", 8)
    val list = listOf(p1, p2, p3)

    val isAge5 = fun(p: Person): Boolean =
        p.age == 5

    val list_filtered = list.filter(isAge5)
    list_filtered.forEach { println("${it}は5歳です") }
}

fun isAge5(p: Person): Boolean {
    return p.age == 5
}

data class Person(val name: String, val age: Int)

