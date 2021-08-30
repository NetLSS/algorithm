/*
최소한의 비용이 소모되는 길을 먼저 연결
이후 연결된 길로부터 연결 될 수 있는 최소한의 비용의 길 선택
🛑 이때 건너 뛰었던 연결안된 최소 비용의 길도 고려할 수 있어야함.
🛑 이미 방문한 길은 다시 연결하지 않도록 함.
 */

import java.util.*
import kotlin.Comparator

class Solution210830T1735 {
    fun solution(n: Int, costs: Array<IntArray>): Int {
        var answer = 0

        val isVisited = MutableList(n) { false }
        val sortedCosts = costs.sortedArrayWith(object : Comparator<IntArray> {
            override fun compare(o1: IntArray, o2: IntArray): Int {
                return o1[2] - o2[2]
            }
        })

        val heap: PriorityQueue<IntArray> = PriorityQueue { o1, o2 ->
            return@PriorityQueue o1[2] - o2[2]
        }
        heap.addAll(sortedCosts)

        for (i in 1..n) {
            val polled = mutableListOf<IntArray>()
            while (heap.isNotEmpty()) {
                val curArr = heap.poll()
                if (i == 1 || (isVisited[curArr[0]] && isVisited[curArr[1]].not()) || (isVisited[curArr[0]].not() && isVisited[curArr[1]])) {
                    isVisited[curArr[0]] = true
                    isVisited[curArr[1]] = true
                    answer += curArr[2]
                    break
                } else {
                    polled.add(curArr)
                }
            }
            heap.addAll(polled)
        }

        return answer
    }


    fun solution2(n: Int, costs: Array<IntArray>): Int {
        val sortedCosts = costs.sortedBy { it[2] }
        val visited = mutableSetOf(0)

        var answer = 0
        while (visited.size < n) {
            for ((s, e, c) in sortedCosts) {
                if (visited.contains(s) or visited.contains(e)) {
                    if (visited.contains(s) and visited.contains(e)) {
                        continue
                    }
                    visited.add(s)
                    visited.add(e)
                    answer += c
                    break
                }
            }
        }
        return answer
    }
}

fun main() {
    Solution210830T1735().run {
        println(
            solution(
                6,
                arrayOf(
                    intArrayOf(0, 1, 5),
                    intArrayOf(0, 3, 2),
                    intArrayOf(0, 4, 3),
                    intArrayOf(1, 4, 1),
                    intArrayOf(3, 4, 10),
                    intArrayOf(1, 2, 2),
                    intArrayOf(2, 5, 3),
                    intArrayOf(4, 5, 4),
                )
            )
        )
    }
}
/*
문제 설명
n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때, 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 return 하도록 solution을 완성하세요.

다리를 여러 번 건너더라도, 도달할 수만 있으면 통행 가능하다고 봅니다. 예를 들어 A 섬과 B 섬 사이에 다리가 있고, B 섬과 C 섬 사이에 다리가 있으면 A 섬과 C 섬은 서로 통행 가능합니다.

제한사항

섬의 개수 n은 1 이상 100 이하입니다.
costs의 길이는 ((n-1) * n) / 2이하입니다.
임의의 i에 대해, costs[i][0] 와 costs[i] [1]에는 다리가 연결되는 두 섬의 번호가 들어있고, costs[i] [2]에는 이 두 섬을 연결하는 다리를 건설할 때 드는 비용입니다.
같은 연결은 두 번 주어지지 않습니다. 또한 순서가 바뀌더라도 같은 연결로 봅니다. 즉 0과 1 사이를 연결하는 비용이 주어졌을 때, 1과 0의 비용이 주어지지 않습니다.
모든 섬 사이의 다리 건설 비용이 주어지지 않습니다. 이 경우, 두 섬 사이의 건설이 불가능한 것으로 봅니다.
연결할 수 없는 섬은 주어지지 않습니다.
입출력 예

n	costs	return
4	[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]	4
입출력 예 설명

costs를 그림으로 표현하면 다음과 같으며, 이때 초록색 경로로 연결하는 것이 가장 적은 비용으로 모두를 통행할 수 있도록 만드는 방법입니다.
 */

/*
5 [[0, 1, 5], [1, 2, 3], [2, 3, 3], [3, 1, 2], [3, 0, 4], [2, 4, 6], [4, 0, 7]] 15
5 [[0, 1, 1], [3, 4, 1], [1, 2, 2], [2, 3, 4]] 8
4 [[0, 1, 5], [1, 2, 3], [2, 3, 3], [1, 3, 2], [0, 3, 4]] 9
5 [[0, 1, 1], [3, 1, 1], [0, 2, 2], [0, 3, 2], [0, 4, 100]] 104
6 [[0, 1, 5], [0, 3, 2], [0, 4, 3], [1, 4, 1], [3, 4, 10], [1, 2, 2], [2, 5, 3], [4, 5, 4]] 11
5 [[0, 1, 1], [2, 3, 1], [3, 4, 2], [1, 2, 2], [0, 4, 100]] 6
5 [[0, 1, 1], [0, 4, 5], [2, 4, 1], [2, 3, 1], [3, 4, 1]] 8
5 [[0, 1, 1], [0, 2, 2], [0, 3, 3], [0, 4, 4], [1, 3, 1]] 8


 */