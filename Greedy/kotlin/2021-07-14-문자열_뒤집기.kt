package answkdufenlwlqrl123123

//https://www.acmicpc.net/problem/1439

class Solution{
    fun solution(str: String): Int{
        var prev = -1
        var zeroCnt = 0
        var oneCnt = 0

        for (i in str){
            when(i){
                '0'->{
                    if(prev!=0)
                      zeroCnt++
                    prev = 0
                }
                '1'->{
                    if(prev!=1)
                        oneCnt++

                    prev = 1
                }
            }
        }

        return minOf(zeroCnt,oneCnt)
    }
}

fun main() {
    println(Solution().solution(readLine()!!))
}