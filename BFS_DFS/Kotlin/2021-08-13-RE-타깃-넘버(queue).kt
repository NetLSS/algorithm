import java.util.*

class Solution210813T1709 {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0

        data class Number(var depth: Int = 1, var acc: Int = 0, val isVisited: Array<Boolean>)

        val isVisited = Array<Boolean>(numbers.size) { false }

        val q: Queue<Number> = LinkedList()
        q.add(Number(1, numbers[0], isVisited.clone().apply { set(0, true) }))
        q.add(Number(1, -numbers[0], isVisited.clone().apply { set(0, true) }))

        while (q.isNotEmpty()) {
            val currentNumber = q.poll()

            if (currentNumber.depth == numbers.size) {
                if (currentNumber.acc == target)
                    answer++
                continue
            }

            // 순서 안중요
            q.add(
                Number(
                    currentNumber.depth + 1,
                    currentNumber.acc + numbers[currentNumber.depth],
                    currentNumber.isVisited.clone().apply { set(currentNumber.depth, true) })
            )
            q.add(
                Number(
                    currentNumber.depth + 1,
                    currentNumber.acc - numbers[currentNumber.depth],
                    currentNumber.isVisited.clone().apply { set(currentNumber.depth, true) })
            )

            // 순서까지 포함 (ex 1+2 , 2+1)
//            currentNumber.isVisited.forEachIndexed { index, b ->
//                if (!b) {
//                    q.add(Number(currentNumber.depth+1,currentNumber.acc + numbers[index],currentNumber.isVisited.clone().apply { set(index,true) }))
//                    q.add(Number(currentNumber.depth+1,currentNumber.acc - numbers[index],currentNumber.isVisited.clone().apply { set(index,true) }))
//                }
//            }
        }


        return answer
    }
}

fun main() {
    Solution210813T1709().solution(intArrayOf(1, 1, 1, 1, 1), 3).run {
        println(this)
    }
}

/*
numbers	            target	    return
[1, 1, 1, 1, 1] 	3	        5
 */