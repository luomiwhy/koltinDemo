package demo

import java.util.concurrent.locks.Lock


fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) result.add(t)
    return result
}

tailrec fun findFixPoint(x: Double = 1.0): Double
        = if (x == Math.cos(x)) x else findFixPoint(Math.cos(x))

inline fun <T> lock(lock: Lock, body: () -> T) {}




fun main(args: Array<String>) {
    val list = asList(1, 2, 3, 4)
    val tmpA = arrayOf(1, 2, 3)
    val listA = asList(-1, 0, *tmpA, 6, 7)
    println(findFixPoint())
    val sum: (Int, Int) -> Int = { x, y -> x + y }
    val sumAdd = fun Int.(other: Int): Int = this + other
    println(1.sumAdd(3))
}
