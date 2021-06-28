package fewf43h8934h9

import java.util.Collections.min
import kotlin.math.min

const val INF = Int.MAX_VALUE / 2 - 1

fun main() {
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()

    val graph = (0..n).map { MutableList(n + 1) { INF } }.toMutableList()

    for (i in 1..n) {
        graph[i][i] = 0
    }

    for (i in 1..m) {
        val (a, b, c) = readLine()!!.trim().split(" ").map { it.toInt() }

        graph[a][b] = c
    }

    // 플로이드 워셜.
    for (k in 1..n) {
        for (a in 1..n) {
            for (b in 1..n) {
                graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])
            }
        }
    }

    for (a in 1..n) {
        for (b in 1..n) {
            if (graph[a][b] == INF)
                println("INFINITY")
            else
                print("${graph[a][b]} ")
        }
        println()
    }
}

/*
4
7
1 2 4
1 4 6
2 1 3
2 3 7
3 1 5
3 4 4
4 3 2



0 4 8 6
3 0 7 9
5 9 0 4
7 11 2 0
*/