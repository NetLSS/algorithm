package rr3r3r3refw

data class Gil(val a: Int, val b: Int, val cost: Int)

fun main() {
    fun findParent(parent: MutableList<Int>, a: Int): Int {
        if (parent[a] != a) {
            parent[a] = findParent(parent, parent[a])
        }
        return parent[a]
    }

    fun unionParent(parent: MutableList<Int>, a: Int, b: Int) {
        val (a, b) = Pair(findParent(parent, a), findParent(parent, b))

        if (a < b) {
            parent[b] = a
        } else {
            parent[a] = b
        }
    }

    val (n, m) = readLine()!!.trim().split(" ").map { it.toInt() }

    val parent = MutableList(n + 1) { it }

    val gils = mutableListOf<Gil>()

    for (i in 1..m) {
        val (a, b, c) = readLine()!!.trim().split(" ").map { it.toInt() }
        gils.add(Gil(a, b, c))
    }

    gils.sortBy { it.cost }

    var maxCost = Int.MIN_VALUE
    var sumCost = 0

    for (gil in gils) {
        if (findParent(parent, gil.a) != findParent(parent, gil.b)) {
            unionParent(parent, gil.a, gil.b)
            sumCost += gil.cost
            maxCost = maxOf(maxCost, gil.cost)
        }
    }
    sumCost -= maxCost

    print(sumCost)
}

/*

7 12
1 2 3
1 3 2
3 2 1
2 5 2
3 4 4
7 3 6
5 1 5
1 6 2
6 4 1
6 5 3
4 5 3
6 7 4
8
Process finished with exit code 0

 */