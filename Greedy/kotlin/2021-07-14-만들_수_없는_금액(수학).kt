package feowo3ofow2

import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val coinList = readLine()!!.trim().split(" ").map { it.toInt() }.sorted()

    var target = 1

    for (x in coinList) {
        if(target < x)
            break
        target += x
    }

    println(target)
}

/*
5
3 2 1 1 9
8

Process finished with exit code 0



4
1 2 4 8
16

Process finished with exit code 0

 */