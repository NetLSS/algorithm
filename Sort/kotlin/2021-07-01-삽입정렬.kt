package f43v3rg

fun main() {
    val list = mutableListOf(7, 5, 9, 0, 3, 1, 6, 2, 4, 8)

    for (i in 1 until list.size){
        for(j in i downTo 1 step 1){
            if (list[j] < list[j-1]){
                list[j] = list[j-1].also { list[j-1] = list[j] }
            }
            else{
                break
            }
        }
    }

    println(list)
}

/*
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]


 */