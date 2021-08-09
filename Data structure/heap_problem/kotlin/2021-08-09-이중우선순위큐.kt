import java.util.*

class Solution21080902 {
    fun solution(operations: Array<String>): IntArray {
        var answer = intArrayOf()
        val priorityQueueMin = PriorityQueue<Int> { o1, o2 ->
            when {
                o1 < o2 -> -1
                o1 > o2 -> 1
                else -> 0
            }
        }
        val priorityQueueMax = PriorityQueue<Int> { o1, o2 ->
            when {
                o1 < o2 -> 1
                o1 > o2 -> -1
                else -> 0
            }
        }

        operations.map {
            it.split(" ").let { strList ->
                when (strList[0]) {
                    "I" -> {
                        priorityQueueMin.add(strList[1].toInt())
                        priorityQueueMax.add(strList[1].toInt())
                    }
                    "D" -> when (strList[1]) {
                        "1" -> {
                            val max = priorityQueueMax.poll()
                            priorityQueueMin.remove(max)
                        }
                        "-1" -> {
                            val min = priorityQueueMin.poll()
                            priorityQueueMax.remove(min)
                        }
                        else -> {
                        }
                    }
                    else -> {
                    }
                }
            }
        }

        return if (priorityQueueMax.isNotEmpty()) {
            intArrayOf(priorityQueueMax.poll(), priorityQueueMin.poll())
        } else {
            intArrayOf(0, 0)
        }
    }
}