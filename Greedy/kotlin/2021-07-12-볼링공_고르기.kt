package wecewf32kkszc

fun main() {
    var answer = 0
    var (n, m) = readLine()!!.trim().split(" ").map { it.toInt() }
    val coef = MutableList(m+1){0} // 계수
    val ballList = readLine()!!.trim().split(" ").map{coef[it.toInt()]++; it.toInt()}

    coef.filter { it != 0 }.let{
        for(i in it.indices){
            n -= it[i]
            answer += it[i] * n
        }
    }

    println(answer)
}

/*
5 3
1 3 2 3 2
8

Process finished with exit code 0


8 5
1 5 4 3 2 4 5 2
25

Process finished with exit code 0
 */