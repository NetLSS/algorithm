package ggkrgok3t3g4g

// fold 는 누산기 역할을 한다고 보면된다.

class Example {
    fun main0(numbers: IntArray, target: Int): Int {

        return numbers.fold(listOf(0)) { list, i ->
            list.run {
                map { it + i } + map { it - i }
            }
        }.count { it == target }
    }

    fun main1() {
        val fruits = listOf("apple", "apricot", "banana", "blueberry", "cherry", "coconut")

        println(fruits.groupBy { it.first() }) // {a=[apple, apricot], b=[banana, blueberry], c=[cherry, coconut]}

        /*
        inline fun <T, R> Iterable<T>.fold(
            initial: R,
            operation: (acc: R, T) -> R
        ): R
         */
        // collect only even length Strings
        val evenFruits = fruits.groupingBy { it.first() }
            .fold(listOf<String>()) { acc, e -> if (e.length % 2 == 0) acc + e else acc }

        println(evenFruits) // {a=[], b=[banana], c=[cherry]}
    }

    fun main2() {
        val fruits = listOf("cherry", "blueberry", "citrus", "apple", "apricot", "banana", "coconut")


        /*
        inline fun <T, K, R> Grouping<T, K>.fold(
            initialValueSelector: (key: K, element: T) -> R,
            operation: (key: K, accumulator: R, element: T) -> R
        ): Map<K, R>
         */
        val evenFruits = fruits.groupingBy { it.first() }
            .fold({ key, _ -> key to mutableListOf<String>() }, // 초기값 설정 키+벨류(스트링 리스트)형식
                { _, accumulator, element ->
                    accumulator.also { (_, list) -> if (element.length % 2 == 0) list.add(element) }
                })

        val sorted = evenFruits.values.sortedBy { it.first }
        println(sorted) // [(a, []), (b, [banana]), (c, [cherry, citrus])]
    }
}

fun main() {
    Example().run {
        // ex0
        main0(intArrayOf(1, 1, 1, 1, 1), 3)

        // ex1
        main1()

        // ex2
        main2()
    }
}