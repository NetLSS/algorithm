import kotlin.math.abs

// https://programmers.co.kr/learn/courses/30/lessons/42860
class Solution210814T1847 {
    fun solution(name: String): Int {
        val ALPHABET_NUMBER = 26
        var answer = 0

        val charArray = CharArray(name.length) { 'A' }
        var currentCursor = 0

        while (!charArray.contentEquals(name.toCharArray())) {
            // 서로 다른 알파벳이면 조이스틱을 위 or 아래로 움직여 일치하도록 변경
            if (name[currentCursor] != charArray[currentCursor]) {
                answer += minOf(abs(name[currentCursor] - charArray[currentCursor]), ALPHABET_NUMBER - abs(name[currentCursor] - charArray[currentCursor]))

                charArray[currentCursor] = name[currentCursor]
            } else { // nextCursor 구하기 (조이스틱을 좌 or 우로 이동하는 최단거리 구하기)
                var rightIndex : Int? = null
                var rightCount = -1
                var leftIndex : Int? = null
                var leftCount = -1
                for (i in currentCursor until (charArray.size + currentCursor)) {
                    rightCount++
                    val index = if (i >= charArray.size) i - charArray.size else i
                    if (name[index] != charArray[index]){
                        rightIndex = index
                        break
                    }
                }


                for (i in currentCursor downTo (currentCursor - charArray.size + 1)) {
                    leftCount++
                    val index = if (i < 0) charArray.size + i else i
                    if (name[index] != charArray[index]){
                        leftIndex = index
                        break
                    }
                }

                if (rightIndex != null && leftIndex != null) {
                    when {
                        rightCount <= leftCount -> {
                            currentCursor = rightIndex
                            answer += rightCount
                        }
                        else -> {
                            currentCursor = leftIndex
                            answer += leftCount
                        }
                    }
                }

            }

        }

        return answer
    }
}

fun main() {
    for (i in 1 downTo -10){
        println(i)
    }

    Solution210814T1847().solution("ABAAAAAAAAABB").run {
        println(this    )
    }
}

/*
name	return
"JEROEN"	56
"JAN"	23
 */