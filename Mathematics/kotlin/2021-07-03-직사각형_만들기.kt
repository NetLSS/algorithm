package wefwevf2323

class Solution {
    fun solution(v: Array<IntArray>): IntArray {
        val answer = mutableListOf<Int>()
        val mapX :MutableMap<Int,Int> = mutableMapOf()
        val mapY :MutableMap<Int,Int> = mutableMapOf()

        v.map {
            mapX.putIfAbsent(it[0],1)?.let{ _->
                mapX[it[0]]=mapX[it[0]]!! + 1
            }

            mapY.putIfAbsent(it[1],1)?.let{ _->
                mapY[it[1]]=mapY[it[1]]!! + 1
            }
        }
        answer.add(mapX.filter { it.value==1 }.keys.first())
        answer.add(mapY.filter { it.value==1 }.keys.first())

        return answer.toIntArray()
    }
}

/*
v	result
[[1, 4], [3, 4], [3, 10]]	[1, 10]
[[1, 1], [2, 2], [1, 2]]	[2, 1]
 */