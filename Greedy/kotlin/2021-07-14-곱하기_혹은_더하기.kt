package t210712_2

class Solution {
    fun solution(str: String): Int {
        if(str.length == 1){
            return str.toInt()
        }
        // 주의 char 를 toInt 하면 아스키 코드값을 리턴하므로 문자열로 변경뒤 toInt() 해주어야함
        var total = greedyPlusMulti(str[0].toString().toInt(),str[1].toString().toInt())

        for (i in 2 until str.length){
            total = greedyPlusMulti(total,str[i].toString().toInt())
        }

        return total
    }

    fun greedyPlusMulti(a:Int,b:Int): Int{
        return maxOf(a*b,a+b)
        // 사실 0,1 일 때를 제외하고는 모두 곱해주는 것이 더 크다.
    }
}

fun main() {
    val s = readLine()!!.trim()

    println(Solution().solution(s))
}

/*
02984
576

Process finished with exit code 0


567
210

Process finished with exit code 0

 */