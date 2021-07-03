package wevih3oi4h4ivh3

import java.util.*

class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        val isVisited = Array<Boolean>(words.size) { false }

        data class Word(val depth:Int, val string: String, val isVisited:Array<Boolean>)

        val q:Queue<Word> = LinkedList()
        q.add(Word(0,begin,isVisited))

        while (q.isNotEmpty()){
            val currentWord = q.poll()

            if(currentWord.string==target)
                return currentWord.depth

            currentWord.isVisited.forEachIndexed { index, b ->
                if(!b && currentWord.string - words[index] == 1){
                    q.add(Word(currentWord.depth+1,words[index],currentWord.isVisited.clone().apply { set(index,true) }))
                }
            }
        }

        return 0
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
