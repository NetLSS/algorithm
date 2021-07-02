package foofoffooo3

class Solution {
    var answer = 1
    fun solution(clothes: Array<Array<String>>): Int {

        val clothesMap: MutableMap<String, MutableList<String>> = mutableMapOf()

        for (cloth in clothes) {
            if (clothesMap.containsKey(cloth[1])) {
                clothesMap[cloth[1]]!!.add(cloth[0])
            } else {
                clothesMap[cloth[1]] = mutableListOf("", cloth[0]) // 선택안하는 경우 ""로 추가해서 넣어줌.
            }
        }

        for(list in clothesMap.values){
            answer *= list.size
        }

        //makeCombination(clothesMap, 0, clothesMap.keys.size)
        return answer - 1 // 모두 안입는 경우 제외.
    }


    // 모든 경우의 수를 만드는 경우 시간 초과 발생.
    private fun makeCombination(
        map: MutableMap<String, MutableList<String>>,
        depth: Int,
        end: Int
    ) {
        if (depth == end) {
            answer++
            return
        }

        val CurrentKey = map.keys.toList()[depth]
        map[CurrentKey]!!.forEach { _ ->
            makeCombination(map, depth + 1, end)
        }
    }
}

fun main() {
    Solution().run {
        println(
            solution(
                arrayOf(
                    arrayOf("yellowhat", "headgear"),
                    arrayOf("bluesunglasses", "eyewear"),
                    arrayOf("green_turban", "headgear")
                )
            )
        )
    }
}
/*
clothes	return
[["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]	5
[["crowmask", "face"], ["bluesunglasses", "face"], ["smoky_makeup", "face"]]	3

 */