class Solution210823T1810 {
    val TABLE_SIZE = 5
    fun solution(table: Array<String>, languages: Array<String>, preference: IntArray): String {
        var answer: String = ""
        var score = -1
        table.map {
            var currentLng = ""
            var currentScore = 0
            it.split(" ").mapIndexed { index, s ->
                when (index) {
                    0 -> currentLng = s
                    else -> if (s in languages) currentScore += preference.elementAt(languages.indexOf(s)) * (TABLE_SIZE - index + 1)
                }
            }
            if (currentScore > score) {
                answer = currentLng
                score = currentScore
            } else if (currentScore == score && answer > currentLng) answer = currentLng
        }
        return answer
    }
}

fun main() {
    println("${"abcd".toLowerCase() < "Abcd".toLowerCase()}")
    println("${"abcd".toLowerCase() < "Bbcd".toLowerCase()}")
}

/*
table	languages	preference	result
["직업군 5점언어 4점언어 3점언어 2점언어 1점언어", ...]
["SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"]	["PYTHON", "C++", "SQL"]	[7, 5, 5]	"HARDWARE"
["SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"]	["JAVA", "JAVASCRIPT"]	[7, 5]	"PORTAL"
 */