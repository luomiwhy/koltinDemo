package demo

/**
 * Created by lzp on 2017/6/12.
 */


fun main(args: Array<String>) {
    println(sum(5, 9))
    val a: Int = 2
//    a += 1
    val b = 2
//    b += 1
    val c: Int
    c = 3
//    c += 1
    println("a = $a, b = $b, c = $c, sum = ${a + b + c}")
}

//fun sum(a: Int, b: Int): Int {
//    return a+b
//}

fun sum(a: Int, b: Int) = a + b

fun maxOf(a: Int, b: Int): Int? {
    if (a > b) {
        return a
    } else {
        return b
    }
}
