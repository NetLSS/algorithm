package gf23g32g322f23g32g23g3223g

// https://programmers.co.kr/learn/courses/30/lessons/43165?language=kotlin

class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0

        fun dfs(sum: Int, depth: Int) {
            if (depth == numbers.size) {
                if (sum == target)
                    answer++
                return
            }
            dfs(sum + numbers[depth], depth + 1)
            dfs(sum - numbers[depth], depth + 1)
        }

        dfs(0, 0)

        return answer
    }
}

fun main() {
    println(Solution().solution(intArrayOf(1, 1, 1, 1, 1), 3))
}