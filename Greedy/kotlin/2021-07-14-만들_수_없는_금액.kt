package feowo3ofow

import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val coinList = readLine()!!.trim().split(" ").map { it.toInt() }.sorted()

    for (i in 1..Int.MAX_VALUE){
        if(i in coinList)
            continue

        val coinListFiltered = coinList.filter { it < i }.sorted()
        var isPossible = false



        data class Coin(val cost:Int, val isVisit:List<Boolean>, val result : Int)
        val q: Queue<Coin> = LinkedList()

        q.add(Coin(coinListFiltered[0], MutableList<Boolean>(coinListFiltered.size){false}.apply { set(0,true) }, coinListFiltered[0]))

        while (q.isNotEmpty()){
            val cur = q.poll()

            if(cur.result == i){
                isPossible = true
                break
            }

            cur.isVisit.forEachIndexed { index, visit ->
                if(!visit){
                    q.add(Coin(coinListFiltered[index], mutableListOf<Boolean>().apply { addAll(cur.isVisit); set(index,true) }, cur.result+coinListFiltered[index]))
                    q.add(Coin(coinListFiltered[index], mutableListOf<Boolean>().apply { addAll(cur.isVisit); set(index,true) }, cur.result))
                }
            }
        }

        if(!isPossible) {
            println(i)
            return
        }
    }
}

/*
5
3 2 1 1 9
8

Process finished with exit code 0

 */