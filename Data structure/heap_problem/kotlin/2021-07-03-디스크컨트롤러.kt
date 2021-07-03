package efefw3f3f

import java.lang.Exception
import java.util.*

class Solution {

    data class Job(val requestTime: Int, val taskTime: Int)

    fun solution(jobs: Array<IntArray>): Int {
        var jobsList = jobs.toMutableList().sortedBy { it[0] }

        val priorityQueue: PriorityQueue<Job> = PriorityQueue { a, b ->
            when {
                a.taskTime < b.taskTime -> -1
                a.taskTime > b.taskTime -> 1
                else -> 0
            }
        }

        var taskCnt = 0
        var time = 0
        var total = 0
        while (true) {
            if (taskCnt == jobs.size)
                break

            fun jobScheduling() {
                for (t in jobsList.indices) {
                    var finish = false
                    jobsList[t].let { // 삽질:가급적 람다 내부에서 람다 호출 객체는 건들지 않도록 하자!
                        if (it[0] <= time) {
                            priorityQueue.add(Job(it[0], it[1]))
                        } else {
                            finish = true
                        }
                    }
                    if (finish) {
                        if (t < jobsList.size)
                            jobsList = jobsList.subList(t, jobsList.size)
                        break
                    }
                    if(t==jobsList.size-1){ // 삽질:1개만 남는경우 finish 플래그가 동작 하지 않아서 방심했다!
                        jobsList = listOf()
                        break
                    }
                }
            }

            jobScheduling()

            if (priorityQueue.isEmpty())
                time = jobsList.first()[0]

            while (priorityQueue.isNotEmpty()) {
                val currentJob = priorityQueue.poll()
                time += currentJob.taskTime
                total += time - currentJob.requestTime
                taskCnt++
                jobScheduling() // 삽질:테스크가 끝날 때마다 스케쥴링을 해주어야한다! 그래야 중간 요청타임에 맞는 작업을 불러올 수 있다!
            }
        }
        return total / taskCnt
    }
}

fun main() {
    Solution().run {
        solution(arrayOf(intArrayOf(0, 3), intArrayOf(1, 9), intArrayOf(2, 6))).let {
            println(it)
        }
//        solution(arrayOf(intArrayOf(0, 1), intArrayOf(0, 1), intArrayOf(0, 1))).let {
//            println(it)
//        }
    }
}

/*
jobs	return
[[0, 3], [1, 9], [2, 6]]	9

 */