package foofoffo2oo3

// https://programmers.co.kr/learn/courses/30/lessons/42579

data class Music(
    val id: Int,
    val genres: String,
    val playTimes: Int
)

class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        val musics = mutableListOf<Music>()
        val playTimesMap = mutableMapOf<String, Int>()

        for (i in genres.indices) {
            musics.add(Music(i, genres[i], plays[i]))

            // 키가 없는 경우만 새로 넣고, 그 뒤에는 플레이시간을 누적
            playTimesMap.putIfAbsent(genres[i], plays[i])?.let {
                playTimesMap[genres[i]] = playTimesMap[genres[i]]!! + plays[i]
            }
        }

        // 플레이 시간 높은 장르 순서로
        playTimesMap.toList().sortedByDescending { it.second }.forEach {
            musics.groupBy { it.genres }.let { musicMap ->
                var cnt = 0
                // 플레이 시간 비교 같은 경우 Id 로 비교해서 정렬
                musicMap[it.first]!!.sortedWith(compareBy({ -it.playTimes }, { it.id })).forEach loop@{
                    if (cnt == 2) return@loop
                    answer.add(it.id)
                    cnt++
                }
            }
        }
        return answer.toIntArray()
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

/*
genres	plays	return
["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
 */