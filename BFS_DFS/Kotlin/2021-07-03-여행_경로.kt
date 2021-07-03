package fewifj34oif3jiodfgrg

import java.util.*

class Solution {
    fun solution(tickets: Array<Array<String>>): Array<String> {
        var answers = mutableListOf<List<String>>()
        var answer = arrayOf<String>()

        data class Tickets(val depth: Int, val isVisited:Array<Boolean>, val list:Array<String>)
        val q :Queue<Tickets> = LinkedList()
        q.add(Tickets(0,Array<Boolean>(tickets.size){false}, arrayOf()))

        while (q.isNotEmpty()){
            val cur = q.poll()

            if(cur.depth==tickets.size){
                answers.add((arrayOf("ICN")+cur.list).toList())
            }

            cur.isVisited.forEachIndexed { index, b ->
                if(!b){
                    if (cur.depth==0 ){
                        if( tickets[index][0] == "ICN")
                            q.add(Tickets(cur.depth+1,cur.isVisited.clone().apply { set(index,true) },cur.list+tickets[index][1]))
                    }else if(cur.list.last() == tickets[index][0]){
                        q.add(Tickets(cur.depth+1,cur.isVisited.clone().apply { set(index,true) },cur.list+tickets[index][1]))
                    }
                }
            }
        }
        answers.sortBy {
            it.toString()
        }
        answer = answers[0].toTypedArray()
        return answer
    }
}

fun main() {
    Solution().run {
        println(solution(arrayOf(arrayOf("ICN", "JFK"), arrayOf("HND", "IAD"), arrayOf("JFK", "HND"))).toList())
    }
}

/*
tickets	return
[["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	["ICN", "JFK", "HND", "IAD"]
[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
 */