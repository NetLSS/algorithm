import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.random.Random

fun main() {
    BuyLottery().startBuyMachine()
}

class BuyLottery : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.IO
    private val groups = ArrayDeque<Int>(5).apply { addAll(listOf(1, 2, 3, 4, 5)) }
    private val numbers = ArrayDeque<Int>(10).apply { addAll(List(10) { it }) }

    init {
        runBlocking(Dispatchers.IO) {
            repeat(7) {
                delay(77)
                groups.shuffle(Random(System.currentTimeMillis()))
            }
        }
    }

    private fun buy720(buyCount: Int = 0) {
        println("[720 연금 복권 구매]")
        val pickCnt: Int = if (buyCount <= 0) {
            print("뽑을 개수 : ")
            readLine()!!.toInt()
        } else {
            buyCount
        }

        for (pCnt in 1..pickCnt) {
            val winningGroup = groups.random(Random(System.currentTimeMillis()))
            val winningNumber = mutableListOf<Int>()
            for (i in 1..6) {
                Thread.sleep(77)
                winningNumber.add(numbers.random())
            }

            println("${winningGroup}조 $winningNumber")
        }


    }

    @Suppress("FunctionName")
    private fun buy6_45(buyCount: Int = 0) {
        println("[6-45 로또 복권 구매]")
        val numberBox = ArrayDeque<Int>()
        val pickCount: Int = if (buyCount <= 0) {
            print("뽑을 개수 : ")
            readLine()!!.toInt()
        } else {
            buyCount
        }

        numberBox.run {
            launch {
                while (isActive) {
                    delay(Random(System.currentTimeMillis()).nextLong(7, 777))
                    shuffle(Random(System.currentTimeMillis()))
                }

            }
            for (pick in 1..pickCount) {
                val winningPicks = mutableListOf<Int>()
                addAll(List(45) { it + 1 })

                for (i in 1..6) {
                    Thread.sleep(77)
                    for (shuffle in 1..7) {
                        shuffle(Random(System.currentTimeMillis()))
                    }
                    winningPicks.add(removeFirst())
                }
                println(winningPicks.sorted())
                clear()
            }
        }
    }

    fun startBuyMachine() {
        print(
            """
            구매할 복권 종류
            0 = 6-45
            1 = 720
            2 = 6-45, 720 둘다
            입력 해주세요 :
        """.trimIndent()
        )
        when (readLine()!!.toInt()) {
            0 -> {
                buy6_45()
            }

            1 -> {
                buy720()
            }

            2 -> {
                buy720()
                buy6_45()
            }
        }
    }

}
