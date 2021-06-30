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
    val tail = array.slice(1 until  array.size)

    val leftSide = tail.filter { it <= pivot }.toMutableList()
    val rightSide = tail.filter { it > pivot }.toMutableList()


    return quickSort(leftSide) + pivot + quickSort(rightSide)
}

fun quicksort(items:List<Int>):List<Int>{
    if (items.count() < 2){
        return items
    }
    val pivot = items[items.count()/2]

    val equal = items.filter { it == pivot }
//    println("pivot value is : "+equal)

    val less = items.filter { it < pivot }
//    println("Lesser values than pivot : "+less)

    val greater = items.filter { it > pivot }
//    println("Greater values than pivot : "+greater)

    return quicksort(less) + equal + quicksort(greater)
}

/*
array = [5,7,9,0,3,1,6,2,4,8]

def quick_sort(array):
    if len(array) <= 1:
        return array

    pivot = array[0]
    tail = array[1:]

    left_side = [x for x in tail if x <= pivot]
    right_side = [x for x in tail if x > pivot]

    return quick_sort(left_side) + [pivot] + quick_sort(right_side)

print(quick_sort(array))
 */