import java.util.*
import kotlin.math.max
import kotlin.math.min

class Solution210914T1946 {

    data class InOut(val cnt: Int, val set: MutableSet<Int>,val isIn: MutableList<Boolean>, val isOut: MutableList<Boolean>, val answer: MutableList<Int>)

    fun solution(enter: IntArray, leave: IntArray): IntArray {
        var answer: IntArray = IntArray(enter.size){Int.MAX_VALUE}

        val q: Queue<InOut> = LinkedList()

        q.add(InOut(0, mutableSetOf(), MutableList(enter.size){false}, MutableList(enter.size){false}, MutableList(enter.size){Int.MAX_VALUE}))

        while (q.isNotEmpty()) {
            val cur = q.poll()

            if (cur.cnt == enter.size) {
                cur.answer.mapIndexed { index, i ->
                    answer[index] = min(answer[index], i)
                }
                println("empty ${cur.set}")
                continue
            }

            cur.set.map {
                cur.answer[it-1] = min(cur.set.size-1, cur.answer[it-1])
            }



            println(cur.set)


            val isInIndex = cur.isIn.indexOf(false)
            if (isInIndex != -1) {
                q.add(InOut(cur.cnt, cur.set.toMutableSet().apply { add(enter.elementAt(isInIndex)) }, cur.isIn.toMutableList().apply { set(isInIndex, true) }, cur.isOut.toMutableList(), cur.answer))
            }

            val isOutIndex = cur.isOut.indexOf(false)
            if (isOutIndex != -1) {
                if (cur.set.contains(leave.elementAt(isOutIndex))) {
                    q.add(InOut(cur.cnt+1, cur.set.toMutableSet().apply { remove(leave.elementAt(isOutIndex)) }, cur.isIn.toMutableList(), cur.isOut.toMutableList().apply { set(isOutIndex, true) }, cur.answer))
                }
            }
        }
        return answer
    }
}

fun main() {
    Solution210914T1946().run {
        println(solution(intArrayOf(3,2,1), intArrayOf(1, 3, 2)))
    }
}

/*
또 다른 예로 입실 순서가 [1, 4, 2, 3], 퇴실 순서가 [2, 1, 3, 4]인 경우,
[1, 4, 2, 3], [2, 1, 3, 4]
1번과 4번은 반드시 만났습니다.
 */

/*
	[3, 2, 1], [1, 3, 2]
	2:3
 */