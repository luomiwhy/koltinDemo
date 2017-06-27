package demo

fun main(args: Array<String>) {
    loop@ for (i in 1..10){
        print(" -$i")
        for (j in 11..20) {
            print(" #$j")
            if (j ==11) break@loop
        }
    }
    print(" break@loop done\n")

    loop@ for (i in 1..10){
        print(" -$i")
        for (j in 11..20) {
            print(" #$j")
            if (j ==11) continue@loop
        }
    }
    print(" continue@loop done\n")

    val ints = IntArray(10, { i -> i })
    ints.forEach {
        if (it % 2 == 0) return@forEach
        print(" $it")
    }
    println()
    ints.forEach (
        fun (x: Int) {
            if (x % 2 == 0) return
            print(" $x")
        })
    println()
    ints.forEach {
        if (it % 2 == 0) return@forEach Unit
//        if (it % 2 == 0) return@forEach 1 //提示错误，这个返回值相当于替换函数原本的return值
        print(" $it")
    }
}