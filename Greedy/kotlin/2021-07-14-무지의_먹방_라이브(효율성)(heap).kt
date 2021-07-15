package 무지의벅방라이브_효율성_2

import java.util.*

class Solution {
    fun solution(food_times: IntArray, k: Long): Int {
        data class Food(val index: Int, var time: Long)

        val q: PriorityQueue<Food> = PriorityQueue { a, b ->
            when {
                a.time < b.time -> -1
                a.time > b.time -> 1
                else -> 0
            }
        }
        var sum: Long = 0L
        food_times.mapIndexed { index, i -> sum += i; q.add(Food(index + 1, i.toLong())) }
        if (sum <= k) {
            return -1
        }
        var prev: Long = 0L
        var totalPassed: Long = 0L
        while (q.isNotEmpty()) {
            if (k > totalPassed + ((q.size + 1).toLong()) * (q.first().time - prev)) {
                val curFood = q.poll()
                totalPassed += ((q.size + 1).toLong()) * (curFood.time - prev)
                prev = curFood.time // 1
            } else {
                break
            }
        }
        q.toMutableList().sortedBy { it.index }.filterNotNull().let {

            return it[((k - totalPassed) % (it.size.toLong())).toInt()].index
        }
    }
}

fun main() {
    Solution().run {
        println(solution(intArrayOf(4, 5, 6), 10))
        println(solution(intArrayOf(3, 1, 2), 5))
    }
}


/*
같은 코드로 채점한 결과가 있습니다.
정확성  테스트
테스트 1 〉	통과 (21.51ms, 58.6MB)
테스트 2 〉	통과 (21.21ms, 58.1MB)
테스트 3 〉	통과 (21.46ms, 59.9MB)
테스트 4 〉	통과 (22.13ms, 58.9MB)
테스트 5 〉	통과 (21.68ms, 58.3MB)
테스트 6 〉	통과 (23.11ms, 58.3MB)
테스트 7 〉	통과 (17.07ms, 58.1MB)
테스트 8 〉	통과 (16.30ms, 59.1MB)
테스트 9 〉	통과 (23.64ms, 59.9MB)
테스트 10 〉	통과 (21.34ms, 59MB)
테스트 11 〉	통과 (22.35ms, 58.2MB)
테스트 12 〉	통과 (21.99ms, 58.8MB)
테스트 13 〉	통과 (16.02ms, 58.3MB)
테스트 14 〉	통과 (21.73ms, 58.7MB)
테스트 15 〉	통과 (9.01ms, 56.2MB)
테스트 16 〉	통과 (1.57ms, 54.7MB)
테스트 17 〉	통과 (27.57ms, 58.8MB)
테스트 18 〉	통과 (26.38ms, 58.7MB)
테스트 19 〉	통과 (1.41ms, 55.2MB)
테스트 20 〉	통과 (1.14ms, 54.7MB)
테스트 21 〉	통과 (22.55ms, 58.5MB)
테스트 22 〉	통과 (30.46ms, 58.1MB)
테스트 23 〉	통과 (2.19ms, 54.9MB)
테스트 24 〉	통과 (28.12ms, 58.9MB)
테스트 25 〉	통과 (30.40ms, 58.5MB)
테스트 26 〉	통과 (40.39ms, 58.8MB)
테스트 27 〉	통과 (39.74ms, 58.7MB)
테스트 28 〉	통과 (21.28ms, 59.3MB)
테스트 29 〉	통과 (25.16ms, 58.9MB)
테스트 30 〉	통과 (15.08ms, 55.7MB)
테스트 31 〉	통과 (23.10ms, 59.1MB)
테스트 32 〉	통과 (22.55ms, 58.1MB)
효율성  테스트
테스트 1 〉	통과 (292.96ms, 98.8MB)
테스트 2 〉	통과 (129.89ms, 94.1MB)
테스트 3 〉	통과 (288.83ms, 92.8MB)
테스트 4 〉	통과 (305.89ms, 96.4MB)
테스트 5 〉	통과 (301.44ms, 99.9MB)
테스트 6 〉	통과 (292.74ms, 98.7MB)
테스트 7 〉	통과 (274.80ms, 97.7MB)
테스트 8 〉	통과 (303.80ms, 100MB)
채점 결과
정확성: 42.9
효율성: 57.1
합계: 100.0 / 100.0
 */