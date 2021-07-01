package fio34ifj34f

fun main() {
    val array = mutableListOf<Int>(5,7,9,0,3,1,6,2,4,8)

    val sortedArray = quickSort(array)
    print(sortedArray)
}

fun quickSort(array: List<Int>): List<Int>{
    if (array.size<=1)
        return array

    val pivot = array[0]
    val tail = array.slice(1 until array.size)

    val leftSide = tail.filter { it <= pivot }.toMutableList()
    val rightSide = tail.filter { it > pivot }.toMutableList()

    return quickSort(leftSide) + pivot + quickSort(rightSide)
}


/*
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
 */