class Solution_210813T1529 {
    fun solution(numbers: IntArray, target: Int): Int {
        return numbers.fold(listOf(0)) { acc, i ->
            acc.run {
                map{it+i} + map{it-i}
            }
        }.count{it == target}
    }
}

/*
재복습
- fold 는 누산기 역할
- 람다에서 누산기에 지정한 타입과 같은 타입을 반환해야함. (즉, 여기서는 listOf<Int> 타입
 */
/*
numbers	            target	    return
[1, 1, 1, 1, 1] 	3	        5
 */