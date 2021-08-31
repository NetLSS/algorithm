import jdk.nashorn.internal.objects.NativeMath
import java.math.BigInteger
import kotlin.math.ceil
import kotlin.math.max
import kotlin.math.min

class Solution210831T1030 {
    fun solution(n: Int, times: IntArray): Long {

        val MAX_TIME = times.max()!! * n.toLong() // 최악의 수는 가장 오래걸리는 심사원으로 부터 모든 사람이 검사 받는 수
        var answer: Long = MAX_TIME

        // 시간 기준으로 처리할 수 있는 최대 사람 수를 구하는 함수
        fun calcMaxPeople(time: Long): Long {
            var maxPeople = 0L
            times.map {
                maxPeople += time / it
            }
            return maxPeople
        }

        var start = 1L
        var end = MAX_TIME

        // 이진 탐색
        while (start <= end) {
            val mid = (start + end) / 2L

            if (calcMaxPeople(mid) < n) {
                start = mid + 1
            } else { // calcMaxPeople(mid) >= n
                answer = mid
                end = mid - 1 // 처리 인원 보다 많이 처리하는 경우 가장 최적의 중앙 값으로 -1씩 이동하게 됨.
            }
        }

        return answer
    }
}

fun main() {
    Solution210831T1030().run {
        println(solution(8, intArrayOf(2, 9)))
    }
}

/*
문제 설명
n명이 입국심사를 위해 줄을 서서 기다리고 있습니다. 각 입국심사대에 있는 심사관마다 심사하는데 걸리는 시간은 다릅니다.

처음에 모든 심사대는 비어있습니다. 한 심사대에서는 동시에 한 명만 심사를 할 수 있습니다. 가장 앞에 서 있는 사람은 비어 있는 심사대로 가서 심사를 받을 수 있습니다. 하지만 더 빨리 끝나는 심사대가 있으면 기다렸다가 그곳으로 가서 심사를 받을 수도 있습니다.

모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고 싶습니다.

입국심사를 기다리는 사람 수 n, 각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 times가 매개변수로 주어질 때, 모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return 하도록 solution 함수를 작성해주세요.

제한사항
입국심사를 기다리는 사람은 1명 이상 1,000,000,000명 이하입니다.
각 심사관이 한 명을 심사하는데 걸리는 시간은 1분 이상 1,000,000,000분 이하입니다.
심사관은 1명 이상 100,000명 이하입니다.
입출력 예
n	times	return
6	[7, 10]	28
입출력 예 설명
가장 첫 두 사람은 바로 심사를 받으러 갑니다.

7분이 되었을 때, 첫 번째 심사대가 비고 3번째 사람이 심사를 받습니다.

10분이 되었을 때, 두 번째 심사대가 비고 4번째 사람이 심사를 받습니다.

14분이 되었을 때, 첫 번째 심사대가 비고 5번째 사람이 심사를 받습니다.

20분이 되었을 때, 두 번째 심사대가 비지만 6번째 사람이 그곳에서 심사를 받지 않고 1분을 더 기다린 후에 첫 번째 심사대에서 심사를 받으면 28분에 모든 사람의 심사가 끝납니다.
 */

/*
정확성  테스트
테스트 1 〉	통과 (11.01ms, 59.8MB)
테스트 2 〉	통과 (17.55ms, 59.1MB)
테스트 3 〉	통과 (22.68ms, 59.3MB)
테스트 4 〉	통과 (82.27ms, 77.9MB)
테스트 5 〉	통과 (84.57ms, 77.8MB)
테스트 6 〉	통과 (86.13ms, 76.5MB)
테스트 7 〉	통과 (98.30ms, 78.3MB)
테스트 8 〉	통과 (100.55ms, 79.1MB)
테스트 9 〉	통과 (11.71ms, 59.9MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
 */