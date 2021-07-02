package fewfewfewf


// 출처:  , - , 윤수현 , Lee Dong Gyu , 윤병관 외 4 명
class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        println(genres.indices.groupBy { genres[it] }.toList())

        return genres.indices.groupBy { genres[it] }
            .toList() //  [(classic, [0, 2, 3]), (pop, [1, 4])]
            .sortedByDescending { it.second.sumOf {i-> plays[i] } } // 플레이 타임 더한 걸로 내림차 정렬 (장르 정렬)
            .map { it.second.sortedByDescending {i-> plays[i] }.take(2) } // 플레이 타임순 노래 내임차 정렬 (장르내 노래 정렬) 뒤 2개 까지만 택.
            .flatten() // 노래 index 장르별 2개씩 정렬되어있는 것 다차원 -> 1차원으로 평탄화
            .toIntArray() // IntArray 로 변환하여 반환
    }
}

fun main() {
    Solution().run {
        println(
            solution(
                arrayOf("classic", "pop", "classic", "classic", "pop"),
                intArrayOf(500, 600, 150, 800, 2500)
            ).toList()
        )
    }
}