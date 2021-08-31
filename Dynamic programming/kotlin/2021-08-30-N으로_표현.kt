class Solution210830T1911 {
    fun solution(N: Int, number: Int): Int {
        if (N == number)
            return 1

        val sets = List<MutableSet<Int>>(8){ mutableSetOf("$N".repeat(it+1).toInt()) }

        for (i in 0 until 8) {
            val addedSet = mutableSetOf<Int>()
            for (j in 0 until i) {
                for (op1 in sets[j]) {
                    for (op2 in sets[i - j - 1]) {
                        addedSet.run {
                            add(op1 + op2)
                            add(op1 - op2)
                            add(op1 * op2)
                            if (op2 != 0)
                                add(op1/op2)
                        }
                    }
                }
            }
            sets[i].addAll(addedSet)
            if (sets[i].contains(number)) {
                return  i + 1
            }
        }

        return -1
    }
}

class Solution210830copy1 {
    var answer = -1
    fun solution(N: Int, number: Int): Int {
        dfs(N, 0, 0, number, "")
        return answer
    }

    fun dfs(n: Int, pos: Int, num: Int, number: Int, s: String) {
        if (pos > 8) return
        if (num == number) {
            if (pos < answer || answer == -1) {
                println(s)
                answer = pos
            }
            return
        }
        var nn = 0
        for (i in 0..7) {
            nn = nn * 10 + n
            dfs(n, pos + 1 + i, num + nn, number, "$s+")
            dfs(n, pos + 1 + i, num - nn, number, "$s-")
            dfs(n, pos + 1 + i, num * nn, number, "$s*")
            dfs(n, pos + 1 + i, num / nn, number, "$s/")
        }
    }
}


fun main() {
    for (i in 1..10 - 2) {
        println(i)
    }

    Solution210830T1911().run {
        println(solution(5,12))
    }
}

/**python

def solution(N, number):
    # 허뎝님의 수정 피드백 -> 테스트 케이스가 바뀌면서 예외 사항을 추가해야 함.
    if N == number:
        return 1

    # 1. [ SET x 8 ] 초기화
    s = [ set() for x in range(8) ]

    # 2. 각 set마다 기본 수 "N" * i 수 초기화 (5, 55, 555, 5555, 55555...)
    for i,x in enumerate(s, start=1):
        x.add( int( str(N) * i ) )

    # 3. n 일반화
    #   {
    #       "n" * i U
    #       1번 set 사칙연산 n-1번 set U
    #       2번 set 사칙연산 n-2번 set U
    #       ...
    #       n-1번 set 사칙연산 1번 set,
    #    }
    # number를 가장 최소로 만드는 수 구함.
    for i in range(1, 8): // 1,2,3,4,5,6,7,
        for j in range(i): // 0, 01, 012, 0123
            for op1 in s[j]:
                for op2 in s[i-j-1]: // 0, 10, 210
                    s[i].add(op1 + op2)
                    s[i].add(op1 - op2)
                    s[i].add(op1 * op2)
                    if op2 != 0:
                        s[i].add(op1 // op2)

        if  number in s[i]: // 정답 발견 시 리턴
            answer = i + 1
            break

    else:
        answer = -1

    return answer
 */

/***********************************************************************************************************************
문제 설명
아래와 같이 5와 사칙연산만으로 12를 표현할 수 있습니다.

12 = 5 + 5 + (5 / 5) + (5 / 5)
12 = 55 / 5 + 5 / 5
12 = (55 + 5) / 5

5를 사용한 횟수는 각각 6,5,4 입니다. 그리고 이중 가장 작은 경우는 4입니다.
이처럼 숫자 N과 number가 주어질 때, N과 사칙연산만 사용해서 표현 할 수 있는 방법 중 N 사용횟수의 최솟값을 return 하도록 solution 함수를 작성하세요.

제한사항
N은 1 이상 9 이하입니다.
number는 1 이상 32,000 이하입니다.
수식에는 괄호와 사칙연산만 가능하며 나누기 연산에서 나머지는 무시합니다.
최솟값이 8보다 크면 -1을 return 합니다.
입출력 예
N	number	return
5	12	4
2	11	3
입출력 예 설명
예제 #1
문제에 나온 예와 같습니다.

예제 #2
11 = 22 / 2와 같이 2를 3번만 사용하여 표현할 수 있습니다.

출처

※ 공지 - 2020년 9월 3일 테스트케이스가 추가되었습니다.
 */