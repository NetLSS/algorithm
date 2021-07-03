package sdver4v4

class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {

        var isMatched = false
        var matchedMin = Int.MAX_VALUE
        val isVisited = MutableList<Boolean>(words.size) { false }

        fun dfs(isVisited: MutableList<Boolean>, current: String, depth: Int): Int {
            if (depth == words.size)
                return 0

            words.forEachIndexed { index, s ->
                if (!isVisited[index] && current - s == 1) {
                    if (s == target) {
                        isMatched=true
                        matchedMin = minOf(depth, matchedMin)
                        return depth
                    }
                    isVisited[index] = true
                    dfs(isVisited, s, depth + 1)
                    isVisited[index] = false
                }
            }
            return 0
        }

        dfs(isVisited, begin, 0)

        return if (isMatched)
            matchedMin+1
        else
            0
    }
}

operator fun String.minus(b: String): Int {
    if (this.length != b.length) {
        return -1
    }
    var cnt = 0
    this.forEachIndexed { index, c ->
        if (c != b[index]) {
            cnt++
            if (cnt > 1) {
                return -1
            }
        }
    }
    return if(cnt==1) 1 else -1
}


fun main() {
    Solution().run {
        solution("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log", "cog"))
    }
}

/*
begin	target	words	return
"hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
"hit"	"cog"	["hot", "dot", "dog", "lot", "log"]	0
 */