package qnwhrgksrmador

//https://programmers.co.kr/learn/courses/30/lessons/83201?language=kotlin

class Solution21080903 {
    fun solution(scores: Array<IntArray>): String {
        val answer = StringBuilder()

        scores.indices.map { stdNum ->
            val currentStdScores = scores.map { it[stdNum] }
            val min = currentStdScores.minOrNull()!!
            val max = currentStdScores.maxOrNull()!!
            var ignoreMyScore = false

            if (currentStdScores[stdNum] == min && currentStdScores.count { it == min } == 1) {
                ignoreMyScore = true
            } else if (currentStdScores[stdNum] == max && currentStdScores.count { it == max } == 1) {
                ignoreMyScore = true
            }

            currentStdScores.toMutableList().apply {
                if (ignoreMyScore)
                    removeAt(stdNum)
                when (sum().toFloat() / size.toFloat()) {
                    in 90.0..100.0 -> answer.append("A")
                    in 80.0..90.0 -> answer.append("B")
                    in 70.0..80.0 -> answer.append("C")
                    in 50.0..70.0 -> answer.append("D")
                    else -> answer.append("F")
                }
            }
        }

        return answer.toString()
    }
}

fun main() {
    Solution21080903().solution(arrayOf(intArrayOf(50, 90), intArrayOf(50, 87))).run {
        println(this)
    }
}

/*
[[50,90],[50,87]]
 */

/*
평균	학점
90점 이상	A
80점 이상 90점 미만	B
70점 이상 80점 미만	C
50점 이상 70점 미만	D
50점 미만	F
 */