import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import java.util.*
import java.util.Collections.shuffle
import kotlin.coroutines.CoroutineContext
import kotlin.random.Random as kRandom

fun main() = runBlocking {
    BuyLottery().startBuyMachine()

}

class BuyLottery : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.IO
    private val groups = mutableListOf<Int>().apply { addAll(listOf(1, 2, 3, 4, 5)) }
    private val numbers = mutableListOf<Int>().apply { addAll(List(10) { it }) }

    init {
        runBlocking(Dispatchers.IO) {
            repeat(7) {
                delay(77)
                groups.shuffle(Random(System.currentTimeMillis()))
            }
        }
    }

    private suspend fun buy720(buyCount: Int = 0) {
        println("[720 연금 복권 구매]")
        val pickCnt: Int = if (buyCount <= 0) {
            print("뽑을 개수 : ")
            kotlin.runCatching {
                readLine()?.toInt() ?: 0
            }.getOrDefault(0)
        } else {
            buyCount
        }

        val channel = Channel<String>()

        coroutineScope {
            repeat(pickCnt) {
                launch {
                    delay(it * 7L)
                    val winningGroup = groups.random(kRandom(System.currentTimeMillis()))
                    val winningNumber = mutableListOf<Int>()
                    for (i in 1..6) {
                        delay(77L + it * 7L)
                        winningNumber.add(numbers.random())
                    }
                    channel.send("${winningGroup}조 $winningNumber")
                }
            }

            launch {
                repeat(pickCnt) {
                    println(channel.receive())
                }
            }.join()
        }
    }

    @Suppress("FunctionName")
    private fun buy6_45(buyCount: Int = 0) {
        println("[6-45 로또 복권 구매]")
        val numberBox = mutableListOf<Int>()
        val pickCount: Int = if (buyCount <= 0) {
            print("뽑을 개수 : ")
            kotlin.runCatching {
                readLine()?.toInt() ?: 0
            }.getOrDefault(0)
        } else {
            buyCount
        }

        numberBox.run {
            launch {
                while (isActive) {
                    delay(kRandom(System.currentTimeMillis()).nextLong(7, 777))
                    if (size > 0)
                        shuffle(this@run, Random(System.currentTimeMillis()))
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

    private fun <E> MutableList<E>.removeFirst(): E {
        return removeAt(0)
    }

    suspend fun startBuyMachine() {
        print(
            """
            구매할 복권 종류
            0 = 6-45
            1 = 720
            2 = 6-45, 720 둘다
            입력 해주세요 :
        """.trimIndent()
        )
        kotlin.runCatching {
            readLine()?.toInt() ?: 0
        }.onSuccess {
            when (it) {
                0 -> buy6_45()
                1 -> buy720()
                2 -> {
                    buy6_45()
                    buy720()
                }
            }
        }.onFailure {
            println("잘못된 입력입니다.")
        }
    }

}
