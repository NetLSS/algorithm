package qwe23ewrfv

//https://programmers.co.kr/learn/courses/30/lessons/43162?language=kotlin

import java.util.*

class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0

        val isVisited = MutableList(n) { false }
        val stack = Stack<Int>()

        for (i in 0 until n) {
            if (isVisited[i])
                continue

            stack.push(i)
            isVisited[i] = true

            while (stack.isNotEmpty()) {
                var isConnected = false
                val current = stack.peek()
                computers[current].forEachIndexed { index, activate ->
                    if (activate == 1) {
                        if (isVisited[index].not()) {
                            isConnected = true
                            isVisited[index] = true
                            stack.push(index)
                        }
                    }
                }
                if (isConnected.not())
                    stack.pop()
            }
            answer++
        }
        return answer
    }
}

fun main() {
    Solution().run {
        solution(3, arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 1), intArrayOf(0, 1, 1)))
    }
}

/*
	3, [[1, 1, 0], [1, 1, 1], [0, 1, 1]]
기댓값 〉	1
 */