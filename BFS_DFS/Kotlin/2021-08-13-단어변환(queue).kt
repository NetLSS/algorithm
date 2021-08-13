import java.util.*
import kotlin.math.min

class Solution210813T1045 {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        var answer = 0

        if (target !in words)
            return answer

        data class Word(val depth: Int, val word: String, val isVisited: List<Boolean>)

        val q: Queue<Word> = LinkedList()

        q.add(Word(0, begin, List(words.size) { false }))

        while (q.isNotEmpty()) {
            val currentWord = requireNotNull(q.poll())

            currentWord.run {
                // 가장 먼저 타겟이 되는 순간이 가장 짧은 변환 과정임
                if (word == target) {
                    return depth
                }

                isVisited.forEachIndexed { index, b ->
                    if (!b && isDiffOne(word, words[index])) {
                        q.add(Word(depth + 1, words[index], isVisited.toMutableList().apply { set(index, true) }))
                    }
                }
            }
        }
        return answer
    }

    private fun isDiffOne(strA: String, strB: String): Boolean {
        var diffCount = 0
        strA.forEachIndexed { index, c ->
            if (c != strB[index])
                diffCount++
            if (diffCount > 1)
                return false
        }

        return diffCount == 1
    }
}

/*
begin	target	words	return
"hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
"hit"	"cog"	["hot", "dot", "dog", "lot", "log"]	0
 */