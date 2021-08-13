import java.util.*

class Solution210813T1835 {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0

        val isVisited = MutableList(n) { false }

        val q: Queue<Int> = LinkedList()
        computers.indices.map {
            if (!isVisited[it]) {
                q.add(it)
                answer++
            }

            // 연결된 노드 모두 방문처리
            while (q.isNotEmpty()) {
                val cur = q.poll()
                if (!isVisited[cur]) {
                    isVisited[cur] = true
                    computers[cur].forEachIndexed { index, i ->
                        if (i == 1 && !isVisited[index]) {
                            q.add(index)
                        }
                    }
                }
            }
        }

        return answer
    }
}

/*
입출력 예
n	computers	return
3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
 */