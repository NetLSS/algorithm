package 무지의벅방라이브_효율성

import java.math.BigInteger

class Solution {
    fun solution(food_times: IntArray, k: Long): Int {
        var answer = 0

        data class Food(val index: Int, var time: Long)

        var currentTime: Long = k
        var sum = 0
        var currentFoodTimes = food_times.mapIndexed { index, i -> sum+=i; Food(index + 1, i.toLong()) }.toMutableList()
        if(sum <= k){
            return -1
        }
        while (true) {
            if (currentFoodTimes.isEmpty())
                return -1
            if (currentTime / currentFoodTimes.size > 0) {
                val mok: Long = (currentTime / currentFoodTimes.size)//.toInt()
                currentTime -= mok * currentFoodTimes.size
                for(i in currentFoodTimes.indices){
                    currentFoodTimes[i].time -= mok
                }
                currentFoodTimes = currentFoodTimes.filter{if(it.time<0) currentTime+=-it.time;  it.time>0}.toMutableList()
            }else{
                break
            }
        }

        return currentFoodTimes[currentTime.toInt()].index
    }
}

fun main() {
    var a = 10
    val b = -10
    a += -b
    println(a)

    Solution().run {
        println(solution(intArrayOf(4, 5, 6), 10))
        println(solution(intArrayOf(3, 1, 2), 5))

    }
}

// TODO 그냥 빼버리고 마이너스값을 남은값에 더해서 해보기?

/*
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (8.47ms, 55.5MB)
테스트 2 〉	통과 (7.69ms, 55.9MB)
테스트 3 〉	통과 (7.24ms, 55.9MB)
테스트 4 〉	통과 (7.85ms, 56.3MB)
테스트 5 〉	통과 (7.45ms, 56.2MB)
테스트 6 〉	통과 (7.77ms, 55.4MB)
테스트 7 〉	통과 (7.90ms, 55.6MB)
테스트 8 〉	통과 (8.07ms, 55.1MB)
테스트 9 〉	통과 (7.62ms, 55.6MB)
테스트 10 〉	통과 (7.84ms, 55.3MB)
테스트 11 〉	통과 (7.74ms, 55.8MB)
테스트 12 〉	통과 (7.77ms, 56.4MB)
테스트 13 〉	통과 (7.98ms, 55.1MB)
테스트 14 〉	통과 (7.72ms, 56.1MB)
테스트 15 〉	통과 (8.18ms, 55.5MB)
테스트 16 〉	통과 (7.74ms, 56.5MB)
테스트 17 〉	통과 (8.86ms, 56MB)
테스트 18 〉	통과 (7.53ms, 55.7MB)
테스트 19 〉	통과 (7.39ms, 55.4MB)
테스트 20 〉	통과 (7.36ms, 56.2MB)
테스트 21 〉	통과 (7.75ms, 56.3MB)
테스트 22 〉	통과 (7.98ms, 55.5MB)
테스트 23 〉	통과 (7.13ms, 55.5MB)
테스트 24 〉	통과 (9.23ms, 56.1MB)
테스트 25 〉	통과 (9.02ms, 56MB)
테스트 26 〉	통과 (10.14ms, 55.9MB)
테스트 27 〉	통과 (10.26ms, 55.7MB)
테스트 28 〉	통과 (6.15ms, 56.4MB)
테스트 29 〉	통과 (7.45ms, 56.2MB)
테스트 30 〉	통과 (7.86ms, 55.6MB)
테스트 31 〉	통과 (7.24ms, 55.2MB)
테스트 32 〉	통과 (10.77ms, 55.4MB)
효율성  테스트
테스트 1 〉	실패 (24.00ms, 72MB)
테스트 2 〉	실패 (30.47ms, 71.5MB)
테스트 3 〉	실패 (25.04ms, 72MB)
테스트 4 〉	실패 (27.73ms, 71.8MB)
테스트 5 〉	실패 (26.79ms, 71.5MB)
테스트 6 〉	실패 (28.78ms, 71.9MB)
테스트 7 〉	실패 (22.21ms, 71.6MB)
테스트 8 〉	실패 (27.34ms, 72.4MB)
채점 결과
정확성: 42.9
효율성: 0.0
합계: 42.9 / 100.0
 */