package ggkrgok3t3g4g.set

import java.util.*
/*
hash set 보다 성능이 좀 떨어지고 데이터를 추가 삭제시 시간이 좀 걸리지만 검색과 정렬이 뛰어남
 */
fun main() {
    val initSortedSet: TreeSet<Int> = sortedSetOf(4,1,7,2)
    initSortedSet.add(6)
    initSortedSet.remove(1)
    println(initSortedSet)

    initSortedSet.clear()
    println(initSortedSet)
}