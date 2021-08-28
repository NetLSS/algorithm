import java.util.*
import kotlin.math.max

class Solution210828T1251 {
    data class Stock(val prices: IntArray, var sum: Int = 0)
    fun solution(prices: IntArray): Int {
        val q: Queue<Stock> = LinkedList()
        var answer = Int.MIN_VALUE

        q.add(Stock(prices, 0))

        while (q.isNotEmpty()) {
            val curStock = q.poll()
            var isAdded = false
            for (i in 0..(curStock.prices.size-2)) {
                val leftNum = curStock.prices[i]
                for (j in (i + 1) until (curStock.prices.size)) {
                    val rightNum = curStock.prices[j]
                    if (leftNum < rightNum) {
                        val sum = curStock.sum + (rightNum - leftNum)
                        //println("$rightNum - $leftNum , total sum : $sum")

                        q.add(Stock(curStock.prices.toMutableList().apply { removeAt(i); removeAt(j-1); }.toIntArray(), sum))
                        isAdded = true
                    }
                }
            }

            if (isAdded.not()) {
                answer = max(answer, curStock.sum)
            }
        }

        return answer
    }
}

fun main() {
    Solution210828T1251().run {
        println(solution(intArrayOf(1, 2, 3, 4))) // 4
        println(solution(intArrayOf(1, 2, 4, 1, 2, 3))) // 5
        println(solution(intArrayOf(4, 3, 2, 1, 4))) // 3
        println(solution(intArrayOf(4, 3, 2, 1))) // 0
        println(solution(intArrayOf(1, 10, 5, 11, 7))) //15
    }
}



/*

def solution(prices: list):
    answer = 0


문제 설명
특정종목에 대한 주식가격이 매일 매일 주어집니다. N일 동안의 주식 가격이 주어질 때, 주식을 사고팔아 얻을 수 있는 최대 이익은 얼마인지 구하려 합니다. 단, 주식은 다음 규칙에 따라 사고팔아야 합니다.

주식은 하루에 한 주(주식을 세는 단위)만 구매하거나 팔 수 있으며, 주어진 기간 동안 두 번까지 사거나 팔 수 있습니다.
주식은 최대 두 주까지 동시에 가질 수 있습니다.
단, 주식을 두 주 구매하려면 서로 다른 날에 한 주씩 구매해야 합니다.
주식은 하루에 한 주만 팔 수 있습니다.
따라서, 주식 두 주를 팔려면 서로 다른 날에 한 주씩 팔아야 합니다.
매일 매일의 주식 가격 변화가 담긴 배열 prices가 매개변수로 주어질 때, 규칙에 맞게 주식을 사고팔아 얻을 수 있는 최대 이익을 return 하도록 solution 함수를 완성해주세요.

제한사항
prices의 길이(N)는 4 이상 50 이하입니다.
prices의 원소는 1 이상 100,000 이하인 자연수입니다.
이익이 나지 않는 경우에는 주식을 한 번만 사고 팔거나, 혹은 주식을 사지 않아도 됩니다.
항상 손해만 보는 경우(이득이 생기지 않는 경우)에는 0을 return 해주세요.
입출력 예
prices	result
[1, 2, 3, 4]	4
[1, 2, 4, 1, 2, 3]	5
[4, 3, 2, 1, 4]	3
[4, 3, 2, 1]	0
[1, 10, 5, 11, 7]	15
입출력 예 설명
입출력 예 #1

첫날 주식을 사서 넷째 날 판매하고, 둘째날 주식을 사서 셋째 날 판매하면 최대 4의 이익을 얻습니다.

입출력 예 #2

첫날 주식을 사서 셋째 날 판매하고, 넷째 날 주식을 사서 여섯째 날 판매하면 최대 5의 이익을 얻습니다.

입출력 예 #3

넷째 날 주식을 사서 다섯째 날 판매하면 최대 3의 이익을 얻습니다.

입출력 예 #4

어떻게 주식을 사더라도 항상 손해이므로 주식을 사지 않습니다.

입출력 예 #5

첫날 주식을 사서 둘째 날 판매하고, 셋째 날 주식을 사서 넷째 날 판매하면 최대 9 + 6 = 15의 이익을 얻습니다.
만약 첫날 주식을 사서 넷째 날 판매하고, 셋째 날 주식을 사서 다섯째 날 판매하면 10 + 2 = 12로 더 적은 이익을 얻습니다.
 */