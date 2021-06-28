package ef23r23f3f

import java.util.*

const val INF = Int.MAX_VALUE

lateinit var graph: MutableList<MutableList<Pair<Int, Int>>>
lateinit var isVisited: MutableList<Boolean>
lateinit var distances: MutableList<Int>

fun main() {
    // 노드 개수, 가선 개수
    val (n, m) = readLine()!!.trim().split(" ").map { it.toInt() }

    // 시작 노드 번호
    val start = readLine()!!.trim().toInt()

    // 각 노드에 연결돼있는 노드 정보 리스트
    graph = (0..n).map { mutableListOf<Pair<Int, Int>>() }.toMutableList()

    // 방문한 적이 있는지 체크하는 리스트
    isVisited = (0..n).map { false }.toMutableList()

    // 최단 거리 테이블 무한으로 초기화
    distances = (0..n).map { INF }.toMutableList()

    // 간선 정보 입력 받기 m개
    for (i in 1..m) {
        val (a, b, c) = readLine()!!.trim().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, c))
    }

    dijkstra(start)

    for (i in 1..n) {
        when (distances[i]) {
            INF -> println("INFINITY")
            else -> println(distances[i])
        }
    }

}

// 방문 하지 않은 노드 중에서, 가장 최단 거리가 짧은노드의 번호를 반환
fun getSmallestNode(): Int {
    var minValue = INF
    var index = 0

    for (i in 1 until graph.size) {
        if (isVisited[i].not() && minValue > distances[i]) {
            minValue = distances[i]
            index = i
        }
    }
    return index
}

fun dijkstra(start: Int) {
    // 시작 노드에 대해서 초기화
    distances[start] = 0
    isVisited[start] = true

    // 시작 노드와 연결된 노드의 거리 초기화.
    for (i in graph[start]) {
        distances[i.first] = i.second
    }

    // 시작 노드를 제외한 전체 n - 1 개의 노드에 대한 반복.
    for (i in 0 until graph.size) {
        val now = getSmallestNode()
        isVisited[now] = true
        for (data in graph[now]) {
            val cost = distances[now] + data.second
            if (cost < distances[data.first]) {
                distances[data.first] = cost
            }
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