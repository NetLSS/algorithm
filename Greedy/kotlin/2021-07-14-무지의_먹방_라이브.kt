package wefwef3f23dcc

class Solution {
    fun solution(food_times: IntArray, k: Long): Int {
        var answer = 0

        data class Food(val index: Int, var time: Long)

        var currentTime: Long = k
        var sum:Long = 0L
        var currentFoodTimes = food_times.mapIndexed { index, i -> sum+=i; Food(index + 1, i.toLong()) }.toMutableList()
        currentFoodTimes.sortBy { it.time }
        while (true) {
            if (currentFoodTimes.isEmpty() || k >= sum)
                return -1
            if (currentTime / currentFoodTimes.size.toLong() > 0) {
                val mok: Long = (currentTime / currentFoodTimes.size.toLong())//.toInt()
                val minFood: Food = currentFoodTimes.first()//currentFoodTimes.minBy { it.time }!!//currentFoodTimes.minOf { it.time } // 프로그래머스 컴파일러 버전 미지원 (1.3ver)
                val min: Long = minFood.time
                if (mok >= min) {
                    currentTime -= min * currentFoodTimes.size.toLong()
                    for (i in currentFoodTimes.indices) {
                        currentFoodTimes[i].time -= min // TODO 일일이 빼줄 필요가 없.

                    }
                    if(currentFoodTimes[0].time == 0L){
                        var end = 0
                        for(i in currentFoodTimes.indices){
                            if(currentFoodTimes[i].time != 0L){
                                end = i
                                break
                            }
                        }
                        currentFoodTimes = currentFoodTimes.subList(end,currentFoodTimes.size).toMutableList()
                    }
                } else {
                    currentTime -= mok * currentFoodTimes.size.toLong()
                    for (i in currentFoodTimes.indices) {
                        currentFoodTimes[i].time -= mok
                    }
                    if(currentFoodTimes[0].time == 0L){
                        var end = 0
                        for(i in currentFoodTimes.indices){
                            if(currentFoodTimes[i].time != 0L){
                                end = i
                                break
                            }
                        }
                        currentFoodTimes = currentFoodTimes.subList(end,currentFoodTimes.size).toMutableList()
                    }
                }
            } else {
                break
            }
        }
        currentFoodTimes.sortBy { it.index }

        return currentFoodTimes[currentTime.toInt()].index
    }
}

fun main() {
    Solution().run {
        println(solution(intArrayOf(4, 5, 6), 10)) // 2
        println(solution(intArrayOf(3,1,2), 20)) // -1
    //    println(solution(intArrayOf(3, 1, 2), 5))

    }
}

// TODO 그냥 빼버리고 마이너스값을 남은값에 더해서 해보기?

/*
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (7.56ms, 55.8MB)
테스트 2 〉	통과 (8.10ms, 55.7MB)
테스트 3 〉	통과 (12.07ms, 55.3MB)
테스트 4 〉	통과 (7.94ms, 55.4MB)
테스트 5 〉	통과 (7.74ms, 55.3MB)
테스트 6 〉	통과 (11.41ms, 56.1MB)
테스트 7 〉	통과 (10.81ms, 55.5MB)
테스트 8 〉	통과 (7.69ms, 56.1MB)
테스트 9 〉	통과 (7.90ms, 55.2MB)
테스트 10 〉	통과 (7.54ms, 55.4MB)
테스트 11 〉	통과 (7.99ms, 56.7MB)
테스트 12 〉	통과 (7.48ms, 55.9MB)
테스트 13 〉	통과 (7.85ms, 55.3MB)
테스트 14 〉	통과 (9.44ms, 55.5MB)
테스트 15 〉	통과 (7.62ms, 56.9MB)
테스트 16 〉	통과 (7.77ms, 55.4MB)
테스트 17 〉	통과 (7.91ms, 55.4MB)
테스트 18 〉	통과 (7.56ms, 56MB)
테스트 19 〉	통과 (9.04ms, 55.7MB)
테스트 20 〉	통과 (7.49ms, 55.4MB)
테스트 21 〉	통과 (9.76ms, 55MB)
테스트 22 〉	통과 (10.77ms, 55.6MB)
테스트 23 〉	통과 (10.18ms, 55.7MB)
테스트 24 〉	통과 (20.32ms, 56MB)
테스트 25 〉	통과 (12.41ms, 56MB)
테스트 26 〉	통과 (31.86ms, 59.7MB)
테스트 27 〉	통과 (59.16ms, 62.3MB)
테스트 28 〉	통과 (8.54ms, 56.3MB)
테스트 29 〉	통과 (7.66ms, 56MB)
테스트 30 〉	통과 (7.72ms, 56.4MB)
테스트 31 〉	통과 (7.71ms, 56.2MB)
테스트 32 〉	통과 (7.57ms, 55.8MB)
효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	통과 (58.38ms, 75.8MB)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)
테스트 5 〉	실패 (시간 초과)
테스트 6 〉	실패 (시간 초과)
테스트 7 〉	실패 (시간 초과)
테스트 8 〉	실패 (시간 초과)
채점 결과
정확성: 42.9
효율성: 7.1
합계: 50.0 / 100.0

 */
