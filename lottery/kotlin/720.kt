import kotlin.random.Random

class Lotto720 {
    private val groups = ArrayDeque<Int>(5).apply { addAll(listOf(1,2,3,4,5)) }
    private val numbers = ArrayDeque<Int>(10).apply { addAll(List(10){it}) }

    init {
        Thread.sleep(77)
        groups.shuffle(Random(System.currentTimeMillis()))
        Thread.sleep(77)
        numbers.shuffle(Random(System.currentTimeMillis()))
        Thread.sleep(77)
        numbers.shuffle(Random(System.currentTimeMillis()))
        Thread.sleep(77)
        numbers.shuffle(Random(System.currentTimeMillis()))
        Thread.sleep(77)
        numbers.shuffle(Random(System.currentTimeMillis()))
        Thread.sleep(77)
        numbers.shuffle(Random(System.currentTimeMillis()))
        Thread.sleep(77)
        numbers.shuffle(Random(System.currentTimeMillis()))
    }

    fun pickNumber() {
        val winningGroup = groups.random(Random(System.currentTimeMillis()))
        val winningNumber = mutableListOf<Int>()
        for (i in 1..6) {
            Thread.sleep(77)
            winningNumber.add(numbers.random())
        }

        println("${winningGroup}조 $winningNumber")
    }
}

fun main() {
    print("뽑을 개수 : ")
    val pickCnt = readLine()!!.toInt()

    for (i in 1..pickCnt) {
        Lotto720().pickNumber()
    }
}