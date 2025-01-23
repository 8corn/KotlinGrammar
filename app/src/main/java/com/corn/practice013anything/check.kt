package com.corn.practice013anything

fun main() {
    println(add(1, 2))
    println(add2(3, 4, 5))
    println(add(1, 'a'))
    println(add('a', 1))

}

private fun add(a: Int, b: Int) = a + b

private fun add(a: Int, b: Char) {
    println("$a 와 $b 1번")
}

private fun add(a: Char, b: Int) {
    println("$a 화 $b 2번")
}
