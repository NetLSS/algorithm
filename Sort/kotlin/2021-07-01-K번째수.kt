package voi3g3g3

class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = intArrayOf().toMutableList()


        for(cmd in commands){
            val (i,j,k) = cmd
            val sliced = array.slice(i-1 until j).sorted()

            answer.add(sliced[k-1])
        }
        return answer.toIntArray()
    }
}

fun main() {
    println(Solution().solution(intArrayOf(1,5,2,6,3,7,4), arrayOf(intArrayOf(2,5,3), intArrayOf(4,4,1), intArrayOf(1,7,3))).toList())
}

/*
입출력 예
array	commands	return
[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]


 */