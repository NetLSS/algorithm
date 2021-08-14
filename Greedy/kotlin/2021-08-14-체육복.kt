class Solution210814T1823 {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = 0

        val realLost = (lost.toSet() - reserve.toSet()).sorted()
        val realReserve = (reserve.toSet() - lost.toSet()).sorted().toMutableList()

        answer += n - realLost.size

        realLost.forEach {
            if (it - 1 in realReserve) {
                answer++
                realReserve.remove(it - 1)
            } else if (it + 1 in realReserve) {
                answer++
                realReserve.remove(it + 1)
            }
        }

        return answer
    }
}
/*
입출력 예
n	lost	reserve	return
5	[2, 4]	[1, 3, 5]	5
5	[2, 4]	[3]	4
3	[3]	[1]	2

 */