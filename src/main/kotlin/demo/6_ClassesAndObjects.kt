package demo



class Person constructor(firstName: String) {}

class Person2(firstName: String){}

class Custom(name: String) {
    val customerKey = name.toUpperCase()
    init {
        println("Custom init with value $name")
    }
}

class Person3(val firstName: String, val lastName: String, var age: Int) {}

annotation class Inject

class Customer2 public @Inject constructor(name: String) {}


class Person4 {
    constructor(parent: Person4) {
//        parent.children.add(this)
    }
}

class Person5(val name: String) {
    constructor(name: String, parent: Person4) : this(name) { //好像必须这么写
//        parent.children.add(this)
    }
}

class DontCreateMe private constructor() {}

class Customer3(val customerName: String = "")



open class Base(p: Int)

class Derived(p: Int) : Base(p)

class Test(){
    val size: Int = 1
    val isEmpty: Boolean
        get() = this.size == 0
    var stringRepresentation: String
        get() = this.toString()
        set(v) {
//            setDataFromString(v) // 解析字符串并赋值给其他属性
        }
}


interface MyInterface {
    val prop: Int // 抽象的
    val propertyWithImplementation:String get() = "sadf"
    fun bar()
    fun foo(){}
}
class Child : MyInterface {
    override val prop: Int = 345
    override fun bar() {}
}

interface A {
    fun foo() { print("A") }
    fun bar()
}
interface B {
    fun foo() { print("B") }
    fun bar() { print("bar") }
}
class C : A {
    override fun bar() { print("bar") }
}
class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }
    override fun bar() {
        super<B>.bar()
    }
}

open class Outer {
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4  // 默认 public

    protected class Nested {
        public val e: Int = 5
    }
}
class Subclass : Outer() {
    // a 不可见
    // b、c、d 可见
    // Nested 和 e 可见
    override val b = 5   // “b”为 protected
}
class Unrelated(o: Outer) {
    // o.a、o.b 不可见
    // o.c 和 o.d 可见（相同模块）
    // Outer.Nested 不可见，Nested::e 也不可见
}

class Ccc private constructor(a: Int) {}


fun <T> MutableList<T>.swap(a: Int, b: Int) {
    val tmp = this[a]
    this[a] = this[b]
    this[b] = tmp
}

class MyClass {
    companion object {    }
}
fun MyClass.Companion.foo() {}


//数据类
data class User(val name: String, val age: Int)
data class User2(val name: String="", val age: Int=0)

//密封类
sealed class Expr
data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NotANumber: Expr()

//泛型
class Box<T>(t: T){
    val value = t
}
abstract class Source<out T> {
    abstract fun nextT(): T //返回
}
fun demos(strs: Source<String>) {
    val objects : Source<Any> = strs
}
abstract class Comparable<in T> {
    abstract fun compareTo(other: T): Int //作为参数传入
}
fun demos2(x: Comparable<Number>) {
    x.compareTo(1.0)
    val y: Comparable<Double> = x
}
fun copy(from: Array<out Any>, to: Array<Any>) {}
fun fill(dest: Array<in String>, value: String) {}

fun <T> singletonList(item: T): List<T> {
    return listOf(item)
}
fun <T> T.basicToString() : String {  // 扩展函数
    return ""
}

fun <T : Comparable<T>> sort(list: List<T>) {}

//嵌套类
class Outer2 {
    private val bar: Int = 1
    class Nested {
        fun foo() = 2
    }
}
class Outer3 {
    private val bar: Int = 1
    inner class Nested {
        fun foo() = bar
    }
}

//枚举类
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}
enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },
    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}
inline fun <reified T: Enum<T>> printAllValues() {
    print(enumValues<T>().joinToString { it.name })
}

//对象表达式
open class A2(x: Int) {
    public open val y: Int = x
}
interface B2 {}

class C2 {
    // 私有函数，所以其返回类型是匿名对象类型
    private fun foo() = object {
        val x: String = "x"
    }
    // 公有函数，所以其返回类型是 Any
    fun publicFoo() = object {
        val x: String = "x"
    }
    fun bar() {
        val x1 = foo().x        // 没问题
//        val x2 = publicFoo().x  // 错误：未能解析的引用“x”
    }
}



fun main(args: Array<String>) {
    val jack = User(name = "Jack", age = 1)
    val olderJack = jack.copy(age = 2)
    val box: Box<Int> = Box<Int>(1)
    val box2 = Box("sd") // 可推断出
    val l = singletonList<Int>(1)
    println(l)
//    sort(listOf(1, 2, 3))错误
//    sort(listOf(hashMapOf<Int, String>()))错误
    println(Color.valueOf("RED").toString())
    println(Color.values().toString())
    printAllValues<Color>()
    val ab: A2 = object : A2(1), B2 {
        override val y = 15
    }
}