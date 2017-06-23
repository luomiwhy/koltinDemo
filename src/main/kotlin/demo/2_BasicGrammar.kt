package demo

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int) = a + b

fun printSum(a: Int, b: Int): Unit {
    println("printSum of $a and $b is ${a+b}")
}

fun printSum2(a: Int, b: Int) {
    println("printSum2 of $a and $b is ${a+b}")
}

fun printProduct(arg1: String){
    val x = arg1.toIntOrNull()
    if (x != null) {
        println(x*x)
    } else {
        println("$arg1 is not a number")
    }
}

fun getStringLength(obj: Any): Int? = if (obj !is String) null else obj.length

fun printForLoop() {
    for (i in listOf("1", "a")) print(i)
}

fun describe(obj: Any): String = when(obj) {
    1 -> "one"
    "hi" -> "Greeting"
    is Long -> "Long"
    !is String -> "not a string"
    else -> "unknown"
}

fun main(args: Array<String>) {
    println("sum of -3 and 7 is ${sum(-3, 7)}")
    println("sum2 of -3 and 7 is ${sum2(-3, 7)}")
    printSum(-3, 7)
    printSum2(-3, 7)
    printProduct("234534")
    printProduct("234534dfg")
    println("${getStringLength("asdf")}")
    println("${getStringLength("")}")
    println("${getStringLength(34)}")
    printForLoop()
    println(describe(3))
    println(describe(33L))
    println(describe("23"))
    println(describe("hi"))
    val fruits = listOf("sadf", "34234", "adfs", "aati")
    fruits
            .filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
}

