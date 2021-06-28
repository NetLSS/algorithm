package hr3478f34f78

fun main() {
    val v = readLine()!!.toInt()

    val graph = (0..v).map { mutableListOf<Int>() }.toMutableList()
    val isVisited = (0..v).map { false }.toMutableList()

    for (i in 1..v) {
        readLine()!!.split(" ").map { graph[i].add(it.toInt()) }
    }

    dfs(graph, 1, isVisited)
}

fun dfs(graph: MutableList<MutableList<Int>>, v: Int, isVisited: MutableList<Boolean>) {
    if (isVisited[v].not()) {
        isVisited[v] = true
        print("$v ")

        for (i in graph[v]) {
            if (isVisited[i].not())
                dfs(graph, i, isVisited)
        }
    }
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