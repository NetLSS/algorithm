tailrec fun factorial(n: Int, acc: Int): Int {
    return if (n <= 0) {
        acc
    } else {
        factorial(n-1, n*acc)
    }
}

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    if (k < 0 || k > n) {
        println("0")
        return
    }

    try {
        println(factorial(n, 1) / (factorial(k, 1) * factorial(n - k, 1)) % 1_000_000_007)
    } catch (e: Exception) {
        println(0)
    }
}

/*
https://www.acmicpc.net/problem/11401
https://onsil-thegreenhouse.github.io/programming/problem/2018/04/02/problem_combination/
 */
