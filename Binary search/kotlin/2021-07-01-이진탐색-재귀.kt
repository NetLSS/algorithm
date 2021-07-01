package o3jeiwj32


fun binarySearch(arr: List<Int>, start: Int, end: Int, target: Int): Int? {
    if (start >= end)
        return null

    val mid = (start + end) / 2
    if (arr[mid] == target)
        return mid
    else if (arr[mid] > target)
        return binarySearch(arr, start, end - 1, target)
    else
        return binarySearch(arr, start + 1, end, target)

}

fun main()=with(System.`in`.bufferedReader()) {
    val (n, target) = readLine().split(" ").map { it.toInt() }
    val arr = readLine().split(" ").map { it.toInt() }

    println(binarySearch(arr, 0,n-1, target) ?:"존재 하지 않음")
}

/*
10 7
1 3 5 7 9 11 13 15 17 19
3

Process finished with exit code 0
 */