package fio34ifj34fdsf

fun main() {
    var a = 1
    var b = 2

    a = b.also { b = a }

    println("a:$a, b:$b")

    val listA = mutableListOf<Int>(1,2,3)
    val listB = mutableListOf<Int>(3,2,1)

    for (i in listA.indices){
        listA[i] = listB[i].also { listB[i] = listA[i] }
    }

    println("listA: $listA")
    println("listB: $listB")
}