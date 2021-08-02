package qnwhrgksrmador

class Solution {
    fun solution(price: Int, money: Int, count: Int): Long {
        var sum = 0L

        for (i in 1..count) {
            sum += price * i
        }

        return if (money - sum < 0) {
            sum - money
        } else {
            0
        }
    }
}

fun main() {
    println(Solution().solution(3, 20, 4))
}

/*
price	money	count	result
3	20	4	10
 */

/*
입출력 예 #1
이용금액이 3인 놀이기구를 4번 타고 싶은 고객이 현재 가진 금액이 20이라면, 총 필요한 놀이기구의 이용 금액은 30 (= 3+6+9+12) 이 되어 10만큼 부족하므로 10을 return 합니다.
 */