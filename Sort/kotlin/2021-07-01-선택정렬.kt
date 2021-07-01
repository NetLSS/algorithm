package waf34434w4

fun main() {
    val list = mutableListOf(7, 5, 9, 0, 3, 1, 6, 2, 4, 8)
    list.shuffle()
    println(list)

    for (i in list.indices) {
        var minIndex = i
        for (j in i + 1 until list.size) {
            if (list[j] < list[minIndex]) {
                minIndex = j
            }
        }
        list[i] = list[minIndex].also { list[minIndex] = list[i] }
    }

    println(list)
}

/*
[9, 6, 1, 3, 8, 4, 7, 0, 5, 2]
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

 */