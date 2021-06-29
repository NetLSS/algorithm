package ofi34iofj34o

fun main() {
    fun findParent(parent: MutableList<Int>, a: Int): Int {
        if (parent[a] != a) {
            parent[a] = findParent(parent, parent[a])
        }
        return parent[a]
    }

    fun unionParent(parent: MutableList<Int>, a: Int, b: Int) {
        val (a, b) = Pair(findParent(parent, a), findParent(parent, b))

        if (a > b) {
            parent[a] = b
        } else {
            parent[b] = a
        }
    }

    val (n, m) = readLine()!!.trim().split(" ").map { it.toInt() }

    val parent = MutableList(n + 1) { it }

    for (i in 0 until m) {
        val (calc, a, b) = readLine()!!.trim().split(" ").map { it.toInt() }

        when (calc) {
            0 -> unionParent(parent, a, b)
            1 -> {
                when (findParent(parent, a) == findParent(parent, b)) {
                    true -> println("YES")
                    false -> println("NO")
                }
            }
        }
    }
}

/*
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1

NO
NO
YES


Process finished with exit code 0

 */