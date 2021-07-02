package ll55tttteeedd

import kotlin.math.sqrt


class Solution {

    var total = 0
    var resultSet = mutableSetOf<Int>()

    private fun isPrime(num: Int): Boolean {
        if (num < 2)
            return false
        for (i in 2..sqrt(num.toFloat()).toInt()) {
            if (num % i == 0) return false
        }
        return true
    }

    private fun dfs(numbers: String, useList: MutableList<Boolean>, depth: Int, str: String) {

        if (depth == numbers.length)
            return

        numbers.forEachIndexed { index, c ->
            if (useList[index].not()) {
                useList[index] = true
                resultSet.add((str + c).toInt())
                dfs(numbers, useList, depth + 1, str + c)
                useList[index] = false
            }
        }

    }

    fun solution(numbers: String): Int {
        total = 0
        resultSet.clear()
        resultSet.sumBy { if (isPrime(it)) 1 else 0 }
        dfs(numbers, MutableList<Boolean>(numbers.length) { false }, 0, "")

        return resultSet.sumBy { if (isPrime(it)) 1 else 0 }
        // kotlin 1.4>
        //return resultSet.sumOf { if (isPrime(it)) 1L else 0L }.toInt()
    }
}

fun main() {
    Solution().run {
        println(solution("17"))
        println(solution("011"))
    }
}