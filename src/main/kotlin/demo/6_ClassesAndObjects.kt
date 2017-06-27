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

