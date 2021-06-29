package ery843f43

fun main() {
    fun findParent(parent: MutableList<Int>, a: Int): Int {
        if (parent[a] == a)
            return a
        return findParent(parent, parent[a])
    }

    fun unionParent(parent: MutableList<Int>, a: Int, b: Int) {
        val (a, b) = Pair(findParent(parent, a), findParent(parent, b))

        if (a > b) {
            parent[a] = b
        } else {
            parent[b] = a
        }
    }

    val (v, e) = readLine()!!.trim().split(" ").map { it.toInt() }
    val parent = MutableList(v + 1) { it }

    for (i in 0 until e) {
        val (a, b) = readLine()!!.trim().split(" ").map { it.toInt() }
        unionParent(parent, a, b)
    }

    for (i in 1..v) {
        print("${findParent(parent, i)} ")
    }
    println()

    for (i in 1..v) {
        print("${parent[i]} ")
    }
}

/*
6 4
1 4
2 3
2 4
5 6

1 1 1 1 5 5
1 1 2 1 5 5
Process finished with exit code 0

 */