package wef23fwevwe

// https://programmers.co.kr/learn/courses/30/lessons/42746

class Solution {
    fun solution(numbers: IntArray): String {
        val sorted = numbers.sortedWith(Comparator<Int>{ a,b->
            val ab = "$a$b".toInt()
            val ba = "$b$a".toInt()

            if(ab< ba)
                1
            else if(ab>ba)
                -1
            else
                0
        })
        var answer =  ""
        sorted.forEach{
            answer+=it.toString()
        }

        answer = answer.trimStart('0')
        if(answer=="")
            return "0"
        return answer
    }
}

fun main() {
    println(Solution().solution(intArrayOf(6,10,2)))
    println(Solution().solution(intArrayOf(3, 30, 34, 5, 9)))
    println(Solution().solution(intArrayOf(9,92,999,993,111,222,333)))
    println(Solution().solution(intArrayOf(1,1,9,1,1,91,92)))
    println(Solution().solution(intArrayOf(12,23,34,45,56,67)))
    println(Solution().solution(intArrayOf(11,1111,9,2222)))
}

/*
numbers	return
[6, 10, 2]	"6210"
[3, 30, 34, 5, 9]	"9534330"
 */