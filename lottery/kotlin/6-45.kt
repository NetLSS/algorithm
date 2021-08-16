import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.random.Random

fun main() {
    val numberBox = ArrayDeque<Int>()

    print("뽑을 개수 : ")
    val pickCount = readLine()!!.toInt()

    numberBox.run {
        for (pick in 1..pickCount){
            val winningPicks = mutableListOf<Int>()
            numberBox.addAll(List<Int>(45){it + 1})

            for (i in 1..6) {
                Thread.sleep(77)
                for (shuffle in 1..7) {
                    shuffle(Random(System.currentTimeMillis()))
                }
                winningPicks.add(removeFirst())
            }
            println(winningPicks.sorted())
        }
    }
}