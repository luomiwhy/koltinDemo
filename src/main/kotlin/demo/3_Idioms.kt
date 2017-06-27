package demo

//创建 DTOs（POJOs/POCOs）
data class Customer(val name: String, val email: String)

fun foo(a: Int = 0, b: String = "") {

}

fun String.spaceToCamelCase(){ println("test 扩展函数") }

object Resource {
    val name = "NAME"
}

fun transform(color: String): Int {
    return when (color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> throw IllegalArgumentException("Invalid color param value")
    }
}

fun test() {
    val result = try {
        count()
    } catch (e: ArithmeticException) {
        throw IllegalStateException(e)
    }
    // 使用 result
}

fun foo(param: Int) {
    val result = if (param == 1) {
        "one"
    } else if (param == 2) {
        "two"
    } else {
        "three"
    }
}

fun arrayOfMinusOnes(size: Int): IntArray {
    return IntArray(size).apply { fill(-1) }
}

fun theAnswer() = 42

//对于需要泛型信息的泛型函数的适宜形式
inline fun <reified T: Any> Gson.fromJson(json): T = this.fromJson(json, T::class.java)

fun main(args: Array<String>) {
    //过滤 list
    val list = listOf(1, -4, 0)
    val positives = list.filter { x -> x>0 }
    val positives2 = list.filter { it>0 }
    println(" Name $list")

    val map = mapOf("a" to 1, "b" to 2)
    //遍历 map/pair型list
    for ((k,v) in map){ println("$k -> $v") }

    //使用区间
    for (i in 1..10) { print(i) } //闭区间：包含 10
    println()
    for (i in 1..10 step 1) { print(i) } //闭区间：包含 10
    println()
    for (i in 10 downTo 1) { print(i) } //闭区间：包含 10
    println()
    if (10 in 1..10) { print(true) } //闭区间：包含 10
    println()
    for (i in 1 until 10) { print(i) } //半开区间：不包含 10
    println()

    println(map["a"])
    println(map["key"])
    //map["key"] = 123 //编译不过

    val p: String by lazy { "qwe" }
    println(p)

    "sdf".spaceToCamelCase()

    println(map?.size)
    println(map?.size ?: "空")

    val email = map["email"] ?: throw IllegalStateException("email is missing")

    map?.let {
        println("map not empty")
    }

    val mapped = map?.let { transformData(it) } ?: defaultValueIfDataIsNull

    class Turtle {
        fun penDown(){}
        fun penUp(){}
        fun turn(degrees: Double){}
        fun forward(pixels: Double){}
    }

    val myTurtle = Turtle()
    with(myTurtle) { // 画一个 100 像素的正方形
        penDown()
        for(i in 1..4) {
            forward(100.0)
            turn(90.0)
        }
        penUp()
    }
}