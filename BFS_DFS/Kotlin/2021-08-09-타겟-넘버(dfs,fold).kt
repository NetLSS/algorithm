class Solution43165 {
    fun solution(numbers: IntArray, target: Int): Int {
        return numbers.fold(listOf(0)){ acc: List<Int>, i: Int ->
            acc.run {
                map{ it + i } + map { it - i }
            }
        }.count { it == target }
    }
}