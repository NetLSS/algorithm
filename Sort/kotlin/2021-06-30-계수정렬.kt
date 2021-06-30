package fio34ifj34f

fun main() {
    val list = listOf<Int>(7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2)

    val count = MutableList(list.maxOrNull()!! + 1) { 0 }

    for (num in list) {
        count[num]++
    }
    count.forEachIndexed { index, i ->
        for (j in 1..i)
            print("$index ")
    }

}

// 0 0 1 1 2 2 3 4 5 5 6 7 8 9 9