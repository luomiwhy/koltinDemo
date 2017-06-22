package main.kotlin.demo

/**
 * Created by lzp on 2017/6/12.
 */
//sampleStart
fun describe(obj: Any): String =
        when (obj) {
            1          -> "One"
            "Hello"    -> "Greeting"
            is Long    -> "Long"
            !is String -> "Not a string"
            else       -> "Unknown"
        }
//sampleEnd

fun main(args: Array<String>) {
    println(describe(1))
    println(describe("Hello"))
    println(describe(1000L))
    println(describe(2))
    println(describe("other"))
    val x = 10
    val y = 9
    if (x in 1..y+1) {
        println("fits in range")
    }
    for (x in 1..5) {
        print(x)
    }
    println()
    for (x in 1..10 step 2) {
        print(x)
    }
    println()
    for (x in 9 downTo 0 step  3) {
        print(x)
    }
    println()
    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    fruits.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
    var cc = Customer("lzp", "sdf")
    cc.email

    val files = listOf("a", 'b', 'c')
//    val files = null
    println(files?.size)

    val oneMillion = 1_000_000
    println(oneMillion)
}
data class Customer(val name: String, val email: String)


