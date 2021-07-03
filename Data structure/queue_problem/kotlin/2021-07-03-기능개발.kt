package safewff4voioioioi7i7i7

// https://programmers.co.kr/learn/courses/30/lessons/42586

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        val list = progresses.toMutableList()
        var cnt:Int
        list.forEachIndexed { index, i ->

            if (i < 100) {
                cnt = 0
                val mok = (100 - i) / speeds[index]

                if ((100 - i) - speeds[index] * mok <= 0) {
                    for (j in list.indices) {
                        list[j] += speeds[j] * mok
                    }
                } else {
                    for (j in list.indices) {
                        list[j] += speeds[j] * (mok + 1)
                    }
                }
                for (j in index until list.size) {
                    if (list[j] >= 100) {
                        cnt++
                    } else {
                        break
                    }
                }
                answer.add(cnt)
            }

        }
        return answer.filter { it != 0 }.toIntArray()
    }
}

fun main() {

    Solution().run {
        println(solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5)).toList())
    }
}

/*
progresses	speeds	return
[93, 30, 55]	[1, 30, 5]	[2, 1]
[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]
 */