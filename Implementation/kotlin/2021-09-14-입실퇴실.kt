class Solution210914T1946 {
    fun solution(enter: IntArray, leave: IntArray): IntArray {
        val answer: IntArray = IntArray(enter.size) { 0 }
        val set = mutableSetOf<Pair<Int, Int>>()
        for (i in 1..enter.size) {
            for (j in 1..enter.size) {
                if (j == i) {
                    continue
                }
                // 먼저 들어가서 나중에 나간 경우
                if (enter.indexOf(i) < enter.indexOf(j) && leave.indexOf(i) > leave.indexOf(j)) {
                    if (!set.contains(Pair(i, j))) {
                        set.add(Pair(i, j))
                        answer[i - 1]++
                        answer[j - 1]++
                    }

                }
                // 순서대로 들어왔다 나갔지만 중간에 더 나중에 들어온 사람이 더 먼저 나간 경우
                else if (enter.indexOf(i) < enter.indexOf(j) && leave.indexOf(i) < leave.indexOf(j) && leave.indexOf(j) - leave.indexOf(
                        i
                    ) > 1
                ) {
                    for (k in (leave.indexOf(i) + 1) until leave.indexOf(j)) {
                        if (enter.indexOf(leave.elementAt(k)) > enter.indexOf(i) && enter.indexOf(leave.elementAt(k)) > enter.indexOf(
                                j
                            )
                        ) {
                            for (l in 0 until leave.indexOf(i)) {
                                if (enter.indexOf(leave.elementAt(l)) > enter.indexOf(j)) {
                                    if (!set.contains(Pair(i, j))) {
                                        set.add(Pair(i, j))
                                        answer[i - 1]++
                                        answer[j - 1]++
                                        break

                                    }
                                }
                            }

                        }
                    }
                } else if (enter.indexOf(i) < enter.indexOf(j) && leave.indexOf(i) < leave.indexOf(j)) {
                    for (k in enter.indexOf(j) + 1 until enter.size) {
                        if (leave.indexOf(enter.elementAt(k)) < leave.indexOf(i)) {
                            if (!set.contains(Pair(i, j))) {
                                set.add(Pair(i, j))
                                answer[i - 1]++
                                answer[j - 1]++
                                break
                            }
                        }
                    }
                }
            }
        }
        return answer
    }
}

fun main() {
    Solution210914T1946().run {
        println(solution(intArrayOf(1, 3, 2), intArrayOf(1, 2, 3)))
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