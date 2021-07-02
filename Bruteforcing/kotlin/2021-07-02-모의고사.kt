package ll55tttteeed

import kotlin.math.max

// https://programmers.co.kr/learn/courses/30/lessons/42840

data class Student(
    val id: Int,
    var score: Int
)

class Solution {
    fun solution(answers: IntArray): IntArray {
        val s1 = intArrayOf(1, 2, 3, 4, 5)
        val s2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val s3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

        val scores = listOf<Student>(Student(1, 0), Student(2, 0), Student(3, 0))
        answers.forEachIndexed { index, i ->
            if (s1[index % s1.size] == i)
                scores[0].score++
            if (s2[index % s2.size] == i)
                scores[1].score++
            if (s3[index % s3.size] == i)
                scores[2].score++
        }
        var maxScore = -1
        scores.forEach {if(it.score>maxScore) maxScore =  it.score  }
        return scores.filter { it.score == maxScore }.sortedBy { it.id }.map { it.id }.toIntArray()

        // kotlin 1.4<=
        //return scores.filter { it.score == scores.maxOf { it.score } }.sortedBy { it.id }.map { it.id }.toIntArray()
    }
}

fun main() {
    Solution().run {
        println(solution(intArrayOf(1,2,3,4,5)).toList())
    }
}

/*
1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 */
/*
answers	return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]
 */