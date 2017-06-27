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


