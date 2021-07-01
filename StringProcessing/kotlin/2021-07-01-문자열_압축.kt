package fe3r3f

import java.lang.StringBuilder
import kotlin.math.min

class Solution {
    fun solution(s: String): Int {
        var answer = Int.MAX_VALUE
        for (unit in 1..s.length / 2 + 1) {
            val sb = StringBuilder("")
            var current = 0
            while (current < s.length){
                if(current+unit > s.length){
                    sb.append(s.slice(current until s.length))
                    break
                }
                val template = s.slice(current until current+unit)
                var cnt = 1
                for (i in current+unit until s.length step unit){
                    if(i+unit-1 < s.length &&template == s.slice(i until i+unit)) {
                        cnt++
                    }
                    else{
                        break
                    }
                }
                current+=cnt*unit
                sb.append("${if(cnt>1) cnt else ""}${template}")
            }
            answer = min(answer,sb.length)
        }
        return answer
    }
}

fun main() {
    println(Solution().solution("aabbaccc"))
    println(Solution().solution("ababcdcdababcdcd"))
    println(Solution().solution("abcabcdede"))
    println(Solution().solution("abcabcabcabcdededededede"))
    println(Solution().solution("xababcdcdababcdcd"))
}

/*
7
9
8
14
17

Process finished with exit code 0
 */



/*
s	result
"aabbaccc"	7
"ababcdcdababcdcd"	9
"abcabcdede"	8
"abcabcabcabcdededededede"	14
"xababcdcdababcdcd"	17
 */

