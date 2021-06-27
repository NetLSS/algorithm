package bfsuserinput

import java.util.*
import kotlin.collections.ArrayDeque

fun bfs(graph: MutableList<MutableList<Int>>, v: Int, visited: MutableList<Boolean>) {
    val q = ArrayDeque<Int>()

    q.addLast(v)

    visited[v] = true

    while (q.isNotEmpty()) {
        val popped = q.removeFirst()

        print("$popped ")

        for (x in graph[popped].sorted()) {
            if (visited[x].not()) {
                visited[x] = true
                q.addLast(x)
            }
        }
    }
}

fun main() {
    val v: Int
    val graph: MutableList<MutableList<Int>>

    with(Scanner(System.`in`)) {
        v = readLine()!!.toInt() // readLine 으로 해야 복붙이 먹힘;

        // 비어있는 2중 리스트 생성
        graph=(0..v).map{
            mutableListOf<Int>()
        }.toMutableList()

        // 각 버텍스(정점)에 연결된 엣지(간선) 받기
        for(i in 1..v){
            readLine()?.split(" ")?.map {
                it.toIntOrNull()?.let { element ->
                    graph[i].add(element)
                }
            }
        }
    }

    // 방문 기록 불 리스트 생성. (모두 방문안함=false 로)
    val visited = (1..9).map { false }.toMutableList() // 타입 보는 방법 shift+control

    // 1번 정점부터 방문.
    bfs(graph, 1, visited)
}

/*
[input]
8
2 3 8
1 7
1 4 5
3 5
3 4
7
2 6 8
1 7
[output]
1 2 3 8 7 4 5 6
 */


/* python
from collections import deque

def bfs(graph, v, visited):
    q = deque()

    q.append(v)

    visited[v] = True

    while q:

        popped_v = q.popleft()

        print(popped_v, end=' ')

        for x in sorted(graph[popped_v]):
            if not visited[x]:
                visited[x] = True
                q.append(x)



# 그래프 인접 리스트 표현 방식 (가중치는 모두 동일 하다는 가정)
# 연결된 노드 번호만 저장
graph = [
    [],
    [2,3,8],
    [1,7],
    [1,4,5],
    [3,5],
    [3,4],
    [7],
    [2,6,8],
    [1,7]
]

visited = [False] * 9

bfs(graph, 1, visited)
 */