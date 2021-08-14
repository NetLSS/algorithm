import java.util.*

class Solution210814T1246 {
    fun solution(tickets: Array<Array<String>>): Array<String> {
        var answer = arrayOf<String>()

        // 도착지를 알파벳 오름차순으로 정렬
        tickets.sortBy {
            it[1]
        }

        val isVisited = MutableList(tickets.size){false}

        data class Tickets(val depth: Int, val answer: Array<String>, val isVisited: List<Boolean>)
        val q : Queue<Tickets> = LinkedList()

        // ICN 에서 출발.
        tickets.forEachIndexed { index, strings ->
            if (strings[0] == "ICN")
                q.add(Tickets(1, arrayOf("ICN", tickets[index][1]), isVisited.toMutableList().apply { set(index, true) }))
        }

        while (q.isNotEmpty()) {
            val current = q.poll()
            if (current.depth == tickets.size){
                return current.answer
            }

            current.isVisited.forEachIndexed { index, b ->
                if(!b && current.answer.last() == tickets[index][0]){
                    q.add(Tickets(current.depth+1, current.answer + tickets[index][1], current.isVisited.toMutableList().apply { set(index, true) }))
                }
            }
        }

        return answer
    }
}

fun main() {
    Solution210814T1246().solution(arrayOf(arrayOf("ICN", "SFO"), arrayOf("ICN", "ATL"), arrayOf("SFO", "ATL"), arrayOf("ATL", "ICN"), arrayOf("ATL","SFO")))
}

/*
tickets	return
[["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	["ICN", "JFK", "HND", "IAD"]
[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]

T 5 : [["ICN", "BOO"], ["ICN", "COO"], ["COO", "DOO"], ["DOO", "COO"], ["BOO", "DOO"], ["DOO", "BOO"], ["BOO", "ICN"], ["COO", "BOO"]]
ans : ["ICN", "BOO", "DOO", "BOO", "ICN", "COO", "DOO", "COO", "BOO"]
 */