package ggkrgok3t3g4g.set
/*
내부적으로 키와 인덱스를 이용해 검색과 변경 등을 매우 빠르게 처리할 수 있는 자료구조
 */
fun main() {
    val intHashSet: HashSet<Int> = hashSetOf(6,3,4,7)
    intHashSet.add(5)
    intHashSet+=99

    intHashSet.remove(6)
    intHashSet-=3

    println(intHashSet)
}

/*
[99, 4, 5, 7]

Process finished with exit code 0

 */