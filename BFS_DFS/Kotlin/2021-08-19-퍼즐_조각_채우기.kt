// https://programmers.co.kr/learn/courses/30/lessons/84021
// solve 까지 2시간 45분

import java.awt.Point
import java.util.*
import kotlin.math.min

class Solution210819T0010 {
    // 테이블 에서 dfs 로 블록 단위를 찾고. 보드에서도 빈칸을 dfs로 빈칸을 찾아서 해당 블록 단위와 동일 모양인지 체크. 동일하면 할당.
    // 이런 식으로 전부 확인 후. 보드 or 테이블을 회전 시켜서 각각 다시 비교

    // 상하좌우
    private val dx = intArrayOf(0,0,-1,+1)
    private val dy = intArrayOf(-1,+1,0,0)

    fun solution(game_board: Array<IntArray>, table: Array<IntArray>): Int {
        var answer: Int = 0

        val isVisitedTable = MutableList<MutableList<Boolean>>(table.size){ MutableList(table.size){false} }

        data class BlockInfo (val points: MutableList<Point>, val shapePoints: MutableList<Point> = mutableListOf())

        val tableBlocks = mutableListOf<BlockInfo>()
        // 각각의 블록 TableBlocks 에 담기
        for (y in table.indices) {
            for (x in table.indices) {
                if (table[y][x] == 1 && !isVisitedTable[y][x]) {
                    val currentBlocks = mutableListOf<Point>()
                    val q : Queue<Point> = LinkedList()
                    var minX = Int.MAX_VALUE
                    var minY = Int.MAX_VALUE
                    q.add(Point(x,y))

                    while (q.isNotEmpty()) {
                        val cur = q.poll()
                        if (isVisitedTable[cur.y][cur.x])
                            continue

                        minX = min(minX, cur.x)
                        minY = min(minY, cur.y)

                        currentBlocks.add(cur)
                        isVisitedTable[cur.y][cur.x] = true
                        for (i in dx.indices) {
                            val ix = cur.x + dx[i]
                            val iy = cur.y + dy[i]

                            if (ix >= 0 && iy >= 0 && ix < table.size && iy < table.size) {
                                if (table[iy][ix] == 1 && !isVisitedTable[iy][ix]) {
                                    q.add(Point(ix,iy))
                                }
                            }
                        }
                    }

                    tableBlocks.add(BlockInfo(currentBlocks.toMutableList(), currentBlocks.map { Point(it.x - minX, it.y - minY) }.toMutableList()))

                }
            }
        }

        var currentGameBoard = game_board
        for (rotate_cnt in 0..3) {
            if (rotate_cnt != 0) {
                currentGameBoard = rotate(currentGameBoard, 1)
            }

            // 빈 공간 정보를 계산
            val emptySpace = mutableListOf<BlockInfo>()
            for (y in currentGameBoard.indices) {
                for (x in currentGameBoard.indices) {
                    if (currentGameBoard[y][x] == 0) {
                        val currentBlocks = mutableListOf<Point>()
                        val q : Queue<Point> = LinkedList()
                        var minX = Int.MAX_VALUE
                        var minY = Int.MAX_VALUE
                        q.add(Point(x,y))

                        while (q.isNotEmpty()) {
                            val cur = q.poll()

                            if (currentGameBoard[cur.y][cur.x] == -1)
                                continue

                            minX = min(minX, cur.x)
                            minY = min(minY, cur.y)

                            currentBlocks.add(cur)
                            currentGameBoard[cur.y][cur.x] = -1
                            for (i in dx.indices) {
                                val ix = cur.x + dx[i]
                                val iy = cur.y + dy[i]

                                if (ix >= 0 && iy >= 0 && ix < table.size && iy < table.size) {
                                    if (currentGameBoard[iy][ix] == 0 ){
                                        q.add(Point(ix,iy))
                                    }
                                }
                            }
                        }
                        emptySpace.add(BlockInfo(currentBlocks.toMutableList(), currentBlocks.map { Point(it.x - minX, it.y - minY) }.toMutableList()))
                    }
                }
            }

            // 블록 채워넣기
            for (empty_space in emptySpace) {

                // 이미 채워진 경우는 pass
                val testPoint = empty_space.points.first()
                if (currentGameBoard[testPoint.y][testPoint.x] == 2) {
                    continue
                }

                for (block in tableBlocks) {
                    if (isSameShape(empty_space.shapePoints, block.shapePoints)) {
                        empty_space.points.map {
                            answer++
                            currentGameBoard[it.y][it.x] = 2
                        }
                        tableBlocks.remove(block)
                        break
                    }
                }

            }

            // 방문 처리 해제
            for (r in currentGameBoard.indices) {
                for (c in currentGameBoard.indices) {
                    if (currentGameBoard[r][c] == -1) {
                        currentGameBoard[r][c] = 0
                    }
                }
            }
        }

        return answer
    }

    private fun isSameShape(a: List<Point>, b: List<Point>): Boolean {
        if (a.size != b.size)
            return false
        a.map {
            if (it !in b)
                return false
        }
        return true
    }

    private fun rotate (target: Array<IntArray>, degree: Int): Array<IntArray> {
        // 90도 회전 단위 (-1: -90도, 1: 90도, 2: 180도)
        val n = target.size
        val ret = Array(n){ IntArray(n){0} }

        when (degree % 4) {
            1 -> {
                for (r in 0 until n) {
                    for (c in 0 until n) {
                        ret[c][n-1-r] = target[r][c]
                    }
                }
            }
            2 -> {
                for (r in 0 until n) {
                    for (c in 0 until n) {
                        ret[n-1-c][n-1-r] = target[r][c]
                    }
                }
            }
            3 -> {
                for (r in 0 until n) {
                    for (c in 0 until n) {
                        ret[n-1-c][r] = target[r][c]
                    }
                }
            }
            else -> {
                for (r in 0 until n) {
                    for (c in 0 until n) {
                        ret[r][c] = target[r][c]
                    }
                }
            }

        }

        return ret
    }
}

fun main() {
    val list1 = mutableListOf<Point>(Point(1,1), Point(1,2))
    val list2 = mutableListOf<Point>(Point(1,2), Point(1,1) )
    if (list1 == list2)
        println("same list")


   Solution210819T0010().solution(
       arrayOf(
           intArrayOf(1,1,0,0,1,0),
           intArrayOf(0,0,1,0,1,0),
           intArrayOf(0,1,1,0,0,1),
           intArrayOf(1,1,0,1,1,1),
           intArrayOf(1,0,0,0,1,0),
           intArrayOf(0,1,1,1,0,0)
       ),
       arrayOf(
           intArrayOf(1,0,0,1,1,0),
           intArrayOf(1,0,1,0,1,0),
           intArrayOf(0,1,1,0,1,1),
           intArrayOf(0,0,1,0,0,0),
           intArrayOf(1,1,0,1,1,0),
           intArrayOf(0,1,0,0,0,0)
       )
   ).run {
       println(this)
   }

}



/*
게임 보드 : 0은 빈칸, 1은 이미 채워진 칸을 나타냅니다.
테이블    : 0은 빈칸, 1은 조각이 놓인 칸을 나타냅니다.
game_board	        table	            result
[[1,1,0,0,1,0],     [[1,0,0,1,1,0],     14
[0,0,1,0,1,0],      [1,0,1,0,1,0],
[0,1,1,0,0,1],      [0,1,1,0,1,1],
[1,1,0,1,1,1],      [0,0,1,0,0,0],
[1,0,0,0,1,0],      [1,1,0,1,1,0],
[0,1,1,1,0,0]]	    [0,1,0,0,0,0]]


[[0,0,0],[1,1,0],[1,1,1]]	[[1,1,1],[1,0,0],[0,0,0]]	0
 */

/*
[[0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0],
[1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0],
[0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0],
[1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1],
[0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0],
[0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1],
[0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0],
[0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0],
[1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0],
[0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0],
[0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1],
[0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0]]

[[1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1],
[1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1],
[1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0],
[0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0],
[1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0],
[1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0],
[1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1],
[1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1],
[0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1],
[1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1],
[1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1],
[1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1]]
 */