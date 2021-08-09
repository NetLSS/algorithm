package efefw3f3fd

import java.util.*

fun main() {
    val priorityQueue: PriorityQueue<Pair<Int, Int>> = PriorityQueue{ o1, o2 ->
        when {
            o1.first < o2.first -> -1

            o1.first > o2.first -> 1

            else -> 0

        }
    }
    priorityQueue.add(Pair(3, 9000)) // 삽입
    priorityQueue.offer(Pair(1, 3000))
    priorityQueue.add(Pair(0, 4999))

    while (priorityQueue.isNotEmpty()) {
        println("${priorityQueue.poll()}")
    }
}

/*
(0, 4999)
(1, 3000)
(3, 9000)
 */