class Solution210914T1946 {
    fun solution(enter: IntArray, leave: IntArray): IntArray {
        var answer: IntArray = IntArray(enter.size) { 0 }
        for (i in 1..enter.size) {
            for (j in 1..enter.size) {
                if (j == i) {
                    continue
                }
                if (enter.indexOf(i) < enter.indexOf(j) && leave.indexOf(i) > leave.indexOf(j)) {
                    answer[i-1]++
                    answer[j-1]++
                    println("$i : $j")
                } else if (enter.indexOf(i) < enter.indexOf(j) && leave.indexOf(i) < leave.indexOf(j) && leave.indexOf(j) - leave.indexOf(i) > 1 ) {
                    for (k in (leave.indexOf(i) + 1) until leave.indexOf(j)) {
                        if (enter.indexOf(leave.elementAt(k)) > enter.indexOf(i) && enter.indexOf(leave.elementAt(k)) > enter.indexOf(j)) {
                            for (l in 0 until leave.indexOf(i)) {
                                if (enter.indexOf(leave.elementAt(l)) > enter.indexOf(j)) {
                                    answer[i-1]++
                                    answer[j-1]++
                                    println("$i : $j")
                                    break
                                }
                            }

                        }
                    }
                } else if (enter.indexOf(i) < enter.indexOf(j) && leave.indexOf(i) < leave.indexOf(j)) {
                    for (k in enter.indexOf(j) + 1 until enter.size) {
                        if (leave.indexOf(enter.elementAt(k)) < leave.indexOf(i)) {
                            answer[i-1]++
                            answer[j-1]++
                            println("$i : $j")
                            break
                        }
                    }
                }
            }
        }
        return answer
    }
    /*
	[3, 2, 1], [1, 3, 2]
	2:3
 */
}

fun main() {
    Solution210914T1946().run {
        println(solution(intArrayOf(1,3,2), intArrayOf(1,2,3)))
    }
}

/*
또 다른 예로 입실 순서가 [1, 4, 2, 3], 퇴실 순서가 [2, 1, 3, 4]인 경우,
[1, 4, 2, 3], [2, 1, 3, 4]
1번과 4번은 반드시 만났습니다.
 */

/*
	[3, 2, 1], [1, 3, 2]
	2:3
 */