package nf3495nvto

import java.util.*

fun main() {

    val n = readLine()!!.toInt()

    val cost = (0..n).map { 0 }.toMutableList()
    val inDegree = (0..n).map { 0 }.toMutableList()
    val graph = (0..n).map { mutableListOf<Int>() }.toMutableList()
    val result = (0..n).map { Int.MIN_VALUE }.toMutableList()

    for (i in 1..n) {
        readLine()!!.trim().split(" ").mapIndexed { index, s ->
            when {
                index == 0 -> {
                    cost[i] = s.toInt()
                }
                s.toInt() == -1 -> {
                    return@mapIndexed
                }
                else -> {
                    graph[s.toInt()].add(i)
                    inDegree[i]++
                }
            }
        }
    }

    // 위상 정렬.
    val q = ArrayDeque<Int>()

    for (i in 1..n) {
        val d = inDegree[i]
        if (d == 0) {
            q.add(i)
            result[i] = cost[i]
        }
    }

    while (q.isNotEmpty()) {
        val now = q.pop()

        for (d in graph[now]) {
            inDegree[d]--
            if (inDegree[d] == 0) {
                q.add(d)
                result[d] = maxOf(result[d], result[now] + cost[d])
            }
        }
    }

    // 결과 출력.
    for (i in (1..n)) {
        println(result[i])
    }
}

/*
5
10 -1
10 1 -1
4 1 -1
4 3 1 -1
3 3 -1
 */