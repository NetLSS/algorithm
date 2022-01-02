// 210704 naver webtoon ps test 기출
import java.util.*
import kotlin.math.max


class Solution210929T1839 {
    fun solution2(sizes: Array<IntArray>): Int {
        var left = 0
        var right = 0

        sizes.map { arr ->
            if (arr[0] < arr[1]) {
                arr[0] = arr[1].also { arr[1] = arr[0] }
            }
        }

        sizes.map { arr ->
            left = max(left, arr[0])
            right = max(right, arr[1])
        }

        return left * right
    }

    // 잘못된 풀이 (이유: test case 만 통과)
    fun solution1(sizes: Array<IntArray>): Int {
        val answers: MutableList<Array<IntArray>> = mutableListOf()


        data class Wallet(val depth: Int, val list: Array<IntArray>, val isVisited: Array<Boolean>)

        val q: Queue<Wallet> = LinkedList()
        val isVisited = Array<Boolean>(sizes.size) { false }
        q.add(Wallet(0, arrayOf(), isVisited))

        while (q.isNotEmpty()) {
            val curWallet = q.poll()

            if (curWallet.depth == sizes.size) {
                answers.add(curWallet.list)

            }

            curWallet.isVisited.forEachIndexed { index, b ->
                if (!b) {

                    q.add(
                        Wallet(
                            curWallet.depth + 1,
                            curWallet.list + sizes[index],
                            curWallet.isVisited.clone().apply { set(index, true) })
                    )
                    q.add(
                        Wallet(
                            curWallet.depth + 1,
                            curWallet.list + intArrayOf(sizes[index][1], sizes[index][0]),
                            curWallet.isVisited.clone().apply { set(index, true) })
                    )
                }
            }
        }

        var answer = Int.MAX_VALUE


        for (item in answers) {
            var maxX = Int.MIN_VALUE
            var maxY = Int.MIN_VALUE

            for (w in item) {
                maxX = maxOf(maxX, w[0])
                maxY = maxOf(maxY, w[1])
            }
            answer = minOf(answer, maxX * maxY)
        }


        return answer
    }
}


fun main() {

}

/*
명함 번호	가로 길이	세로 길이
1	60	50
2	30	70
3	60	30
4	80	40

-> 80 x 50
 */

/*
sizes	result
[[60, 50], [30, 70], [60, 30], [80, 40]]	4000
[[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]	120
[[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]	133
 */

/*
저는 i끼리 곱한거 최대값이 i+1 곱한거 최소값이 최대보다 크면 테케맞길래 그렇게 냈네요
 */
