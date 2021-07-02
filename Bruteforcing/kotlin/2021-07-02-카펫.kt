package weogvjewgoj3g
// https://programmers.co.kr/learn/courses/30/lessons/42842
class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        for (i in 3..Int.MAX_VALUE){
            for (j in 3..i){
                // ⭐️ 조건 2개를 다 걸어줘야 오답이 나오지 않음!!
                if (i*j-(i*2+j*2-4) == yellow && i*2+j*2-4 == brown)
                    return intArrayOf(i,j)
            }
        }
        return intArrayOf()
    }
}


fun main() {

    Solution().run {
        solution(50, 22)
    }
}

/*
입출력 예
brown	yellow	return
10	2	[4, 3]
8	1	[3, 3]
24	24	[8, 6]

 */