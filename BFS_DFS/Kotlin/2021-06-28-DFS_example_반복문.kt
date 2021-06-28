package e1e32d32

import java.util.*

fun dfs(graph: MutableList<MutableList<Int>>, start: Int, isVisited: MutableList<Boolean>) {
    val stack = Stack<Int>()

    // 시작 노드 스택에 넣고 방문처리.
    stack.push(start)
    isVisited[start] = true
    print("$start ")

    while (stack.isNotEmpty()) {
        var isConnected = false

        for (i in graph[stack.peek()]) {
            if (isVisited[i].not()) {
                isConnected = true
                isVisited[i] = true
                stack.push(i)
                print("$i ")
                break
            }
        }

        if (isConnected.not()) {
            stack.pop()
        }
    }

}

fun main() {
    val v = readLine()!!.toInt()

    val graph = (0..v).map { mutableListOf<Int>() }.toMutableList()
    val isVisited = (0..v).map { false }.toMutableList()

    for (i in 1..v) {
        readLine()!!.split(" ").map {
            graph[i].add(it.toInt())
        }
    }

    dfs(graph, 1, isVisited)

}

/*
8
2 3 8
1 7
1 4 5
3 5
3 4
7
2 6 8
1 7

1 2 7 6 8 3 4 5
 */