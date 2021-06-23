import org.omg.CORBA.PERSIST_STORE
import java.util.*
import kotlin.properties.Delegates

lateinit var indegree: MutableList<Int>
var v by Delegates.notNull<Int>()
var e by Delegates.notNull<Int>()
lateinit var graph: MutableList<MutableList<Int>>

fun main() {
    with(Scanner(System.`in`)) {
        // 노드의 개수와 간선 개수 입력 받기
        v = nextInt()
        e = nextInt()

        // 모든 노드의 대한 진입 차수를 0으로 초기화
        indegree = (0..v).map { 0 }.toMutableList()

        // 각 노드에 연결된 간선 정보를 담기 위한 연결 리스트(그래프) 초기화
        graph = (0..v).map { mutableListOf<Int>() }.toMutableList()

        // 방향 그래프의 모든 간선 정보를 입력받기
        (1..e).map {
            val a = nextInt()
            val b = nextInt()
            graph[a].add(b)
            indegree[b]++
        }

        topology_sort()

    }
}

fun topology_sort() {
    val result = mutableListOf<Int>()
    var q = ArrayDeque<Int>()

    // 처음 시작할 때 진입차수가 0인 노드를 모두 삽입
    for (i in 1..v) {
        if (indegree[i] == 0) {
            q.addLast(i)
        }
    }

    while(q.isNotEmpty()){
        // 큐에서 원소 꺼내기
        val now = q.pop()
        result.add(now)

        for(i in graph[now]){
            indegree[i]--

            if(indegree[i]==0){
                q.addLast(i)
            }
        }

    }

    for(i in result){
        print("$i ")
    }
}

/*

7 8
1 2
1 5
2 3
2 6
3 4
4 7
5 6
6 4
1 2 5 3 6 4 7

 */