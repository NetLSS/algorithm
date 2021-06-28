package ef23r23f3f23f

import java.util.*

const val INF = Int.MAX_VALUE

data class Edge(val cost: Int, val target: Int)

fun main() {
    // 노드, 간선 개수
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    // 시작 노드
    val start = readLine()!!.toInt()

    val graph = (0..n).map { mutableListOf<Edge>() }.toMutableList()

    val distance = (0..n).map { INF }.toMutableList()

    for (i in 1..m) {
        val (a, b, cost) = readLine()!!.split(" ").map { it.toInt() }
        graph[a].add(Edge(cost = cost, target = b))
    }

    fun dijkstra(start: Int) {
        val q: PriorityQueue<Edge> = PriorityQueue { a, b ->
            when {
                a.cost < b.cost -> -1
                a.cost > b.cost -> 1
                else -> 0
            }
        }
        q.offer(Edge(0, start))
        distance[start] = 0

        while (q.isNotEmpty()) {
            val e = q.poll()

            // 이미 처리된 노드라면 스킵. // 이미 처리되는 경우는 큐를 돌면서 이후에 추가된 경우 더 짧은 경로로 갱신하기 때문에 이전에 큐에 넣은 경우 스킵.
            if (distance[e.target] < e.cost)
                continue

            for (data in graph[e.target]) {
                // target 노드를 거쳐서 연결된 노드로 이동 하는 거리 계산
                val cost = e.cost + data.cost

                // 더 짧은 경우 갱신 해준다.
                if (distance[data.target] > cost) {
                    distance[data.target] = cost
                    q.add(Edge(cost, data.target))
                }
            }
        }
    }

    dijkstra(start)

    for (i in 1..n) {
        when (distance[i]) {
            INF -> println("INFINITY")
            else -> println(distance[i])
        }
    }
}


/*
"""
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2


[output]
0
2
3
1
2
4
"""
 */

/*
debug
1 방문
2 추가
3 추가
4 추가
4 방문
3 추가
5 추가
2 방문
5 방문
3 추가
6 추가
3 방문
6 방문
3 이미 처리됨.
3 이미 처리됨.
 */