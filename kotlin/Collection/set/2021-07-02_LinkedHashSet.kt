package ggkrgok3t3g4g.set

// 느리지만 저장 공간을 좀 더 효율적으로 사용하는 트리셋.

fun main() {
    val intLinkedHashSet: LinkedHashSet<Int> = linkedSetOf(35, 21, 76, 26, 75)
    intLinkedHashSet.add(4)
    intLinkedHashSet.remove(21)

    println(intLinkedHashSet)
    intLinkedHashSet.clear()
    println(intLinkedHashSet)
}