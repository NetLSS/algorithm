package t210712_1

// 여행을 떠날 수 있는 그룹 수의 최대 값 구하기

class Solution {
    fun solution(n: Int, fearLevelList: List<Int>): Int {
        val sortedFearLevelList = fearLevelList.sorted()

        var current = 0
        var groupCnt = 0
        while (current < n) {

            val fearLevel = sortedFearLevelList[current]

            if (current + fearLevel - 1 < n && sortedFearLevelList[current + fearLevel - 1] <= fearLevel) {
                groupCnt++
            }

            current += fearLevel
        }

        return groupCnt
    }
}

fun main() {
    val n: Int = readLine()!!.trim().toInt()
    val fearLevelList: List<Int> = readLine()!!.trim().split(" ").map { it.toInt() }

    println(Solution().solution(n, fearLevelList))
}

/*
5
2 3 1 2 2
2

 */