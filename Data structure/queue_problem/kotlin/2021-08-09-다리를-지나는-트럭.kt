// https://programmers.co.kr/learn/courses/30/lessons/42583

import java.util.*

class Solution210809_1 {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0

        data class qItem(val weight: Int, var pos: Int = 1)

        val q: Queue<qItem> = LinkedList()
        var qWeight = 0

        val iter = truck_weights.toList().listIterator()

        while (true) {
            answer++
            // 빼기
            if (q.isNotEmpty()) {
                q.toMutableList().map {
                    it.pos++
                }
                if (q.element().pos > bridge_length) {
                    qWeight -= q.poll()?.weight ?: 0
                }
            }

            // 넣기
            if (iter.hasNext()) {
                val current = iter.next()
                if (q.size < bridge_length && qWeight < weight && qWeight + current <= weight) {
                    q.add(qItem(current))
                    qWeight += current
                } else {
                    iter.previous()
                }
            } else if (q.isEmpty()) { // iter 순회 완료 && 큐 빈 상태
                break
            }
        }

        return answer
    }
}

fun main() {
    Solution210809_1().solution(2, 10, intArrayOf(7, 4, 5, 6))
    Solution210809_1().solution(100, 100, intArrayOf(10))
    Solution210809_1().solution(100, 100, intArrayOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10))
}

/*
bridge_length	weight	truck_weights	return
2	10	[7,4,5,6]	8
100	100	[10]	101
100	100	[10,10,10,10,10,10,10,10,10,10]	110
 */

// 다른 사람의 풀이
/*
import java.util.*

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0
        val bridgeQueue: Queue<Int> = LinkedList(List(bridge_length){0}) // 다리 길이 만큼 0을 채워서 초기화
        val waitingQueue: Queue<Int> = LinkedList(truck_weights.toList())

        while (bridgeQueue.isNotEmpty()) {
            answer++
            bridgeQueue.poll()
            if (waitingQueue.isNotEmpty()) {
                if (bridgeQueue.sum() + waitingQueue.peek() <= weight) {
                    bridgeQueue.add(waitingQueue.poll())
                } else {
                    bridgeQueue.add(0) // 넣지 못하는 경우 0을 넣어줌 다리 길이 유지
                }
            }
        }
        return answer
    }
}
 */