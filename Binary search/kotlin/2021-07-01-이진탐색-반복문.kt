package o3jeiwj

fun binarySearch(array: List<Int>, start: Int, end: Int, target: Int): Int?{
    var s = start
    var e = end
    while(s<=e){
        val mid = (s+e)/2

        if (array[mid] == target){
            return mid
        }else if(array[mid] < target){
            s=mid+1
        }else{
            e=mid-1
        }
    }
    return null
}

fun main()=with(System.`in`.bufferedReader()){
    val (n, target) = readLine().split(" ").map { it.toInt() }
    val arr = readLine().split(" ").map { it.toInt() }

    println(binarySearch(arr, 0,n-1, target)?:"존재 하지 않음")
}

/*
10 7
1 3 5 7 9 11 13 15 17 19
3

Process finished with exit code 0
 */