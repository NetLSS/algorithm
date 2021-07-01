package g4bt454r

// https://programmers.co.kr/learn/courses/30/lessons/42747?language=kotlin

class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0

        citations.sortDescending()
        citations.forEachIndexed { index, i ->
            if (i > index && index != 0)
                answer = index + 1
        }

        return answer
    }
}

fun main() {
    println(Solution().solution(intArrayOf(2, 2, 2, 2)))
}

/*

citations	return
[3, 0, 6, 1, 5]	3
 */