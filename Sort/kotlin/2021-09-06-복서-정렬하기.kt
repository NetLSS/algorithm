// https://programmers.co.kr/learn/courses/30/lessons/85002

class Solution210906T1257 {
    data class Boxer(val id: Int, val kg: Int, var rating: Float, var bigWinCount: Int)

    fun solution(weights: IntArray, head2head: Array<String>): IntArray {

        val boxerList = List(weights.size){Boxer(it, weights[it], 0.0F, 0)}

        head2head.mapIndexed { boxerId, s ->
            var bigWinCount = 0
            var win = 0
            var vs = 0

            s.mapIndexed { vsId, c ->
                when (c) {
                    'W' -> {
                        if (weights[boxerId] < weights[vsId])
                            bigWinCount++
                        vs++
                        win++
                    }
                    'L' -> {
                        vs++
                    }
                    'N' -> {
                    }
                    else -> {}
                }
            }

            boxerList[boxerId].apply {
                this.bigWinCount = bigWinCount
                this.rating = if(vs.toFloat() > 0) win.toFloat() / vs.toFloat() * 100.0F else 0.0F

            }
        }

        return boxerList.sortedWith(Comparator { o1, o2 ->
            val ret = if (o1.rating != o2.rating) {
                if(o2.rating - o1.rating < 0) -1 else 1
            } else {
                if (o1.bigWinCount != o2.bigWinCount) {
                    o2.bigWinCount - o1.bigWinCount
                } else {
                    if (o1.kg != o2.kg) {
                        o2.kg - o1.kg
                    } else {
                        o1.id - o2.id
                    }
                }
            }
            return@Comparator if(ret > 0) 1 else if(ret < 0) -1 else 0
        }).map { it.id + 1 }.toIntArray()
    }
}