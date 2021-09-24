import java.util.*
import kotlin.math.max
import kotlin.math.min

class Solution210914T1946 {
    fun solution(enter: IntArray, leave: IntArray): IntArray {
        var answer: IntArray = IntArray(enter.size){0}

        var preMax = 0
        leave.mapIndexed { index, l ->
            println("____________________")
            println("preMax = $preMax vs ${enter.indexOf(l)} = ${max(preMax, enter.indexOf(l))}")
            preMax = max(preMax, enter.indexOf(l))
            if (index != 0) {
                println("index != 0")
                println("current leave: $l")
                println("subList from ${enter.indexOf(l) + 1} to ${preMax + 1}")
                println("sub: ${enter.toMutableList().subList(enter.indexOf(l) + 1, preMax + 1)}")

                // l(현재 leave)를 제외한 나머지, 현재 leave 부터 preMax 까지 (subList 의 두번째 인자 인덱스는 불포함으로 sub)
                for (e in enter.toMutableList().subList(enter.indexOf(l) + 1, preMax + 1)) {
                    answer[l-1]++ // 현재 leave 와
                    answer[e-1]++ // e 는 반드시 만난다.
                    // 현재 leave 가 먼저 들어와있고 나가기 까지 (나갈 수 있는 최대 인덱스. 최대한 나가게.) 남아있는 사람은 모두 만나기 때문
                    // leave 가 나가기 전에 먼저 들어와 있는 경우 반드시 만난다.
                    println("must meet $l with $e")
                    println("${l-1}++ ${e-1}++")
                }
            }
        }

        return answer
    }
}

fun main() {
    Solution210914T1946().run {
        println(solution(intArrayOf(1,2,3,4), intArrayOf(4,3,2,1)).toMutableList())
    }
}

/*
yun 님

#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> enter, vector<int> leave) {
    int n = enter.size();
    vector<int> ret(n);

    set<int> hold; // 입실해서 안나간 사람들 hold
    for (int i = 0, j = 0; i < n; ++i) {
        ret[enter[i] - 1] += hold.size(); // i번째 사람이 들어온 경우
        for (int it : hold) ret[it - 1]++;

        hold.insert(enter[i]); // i 번째 사람 추가
        while (j < n && hold.find(leave[j]) != hold.end()) hold.erase(leave[j++]); // leave 할 사람 그대로 퇴실
        // hold.find(leave[j]) != hold.end(): 못 찾은 경우. 수행x
    }

    return ret;
}

 */

/*
재원님 (윤님 과 같은 아이디어 ㅋㅋ)
들여보내고, 나갈 사람 다 내보내고, 반복
최소로 만나도록.

#include <bits/stdc++.h>

using namespace std;
int in[1010],out[1010];

vector<int> solution(vector<int> enter, vector<int> leave) {
    int n=enter.size();
    vector<int> answer(n,0);
    reverse(leave.begin(),leave.end());
    memset(in,-1,sizeof(in)); memset(out,-1,sizeof(out));
    int curr=1;
    for(int i=0;i<n;i++){
        while(!leave.empty()&&in[leave.back()]!=-1){
            out[leave.back()]=curr++;
            leave.pop_back();
        }
        in[enter[i]]=curr++;
    }
    while(!leave.empty()&&in[leave.back()]!=-1){
            out[leave.back()]=curr++;
            leave.pop_back();
        }
    for(int i=1;i<=n;i++) for(int j=1;j<=n;j++){
        if(i==j) continue;
        if(out[i]<in[j]||out[j]<in[i]) continue;
        answer[i-1]++;
    }
    return answer;
}
 */

/*
또 다른 예로 입실 순서가 [1, 4, 2, 3], 퇴실 순서가 [2, 1, 3, 4]인 경우,
[1, 4, 2, 3], [2, 1, 3, 4]
1번과 4번은 반드시 만났습니다.
 */

/*
	[3, 2, 1], [1, 3, 2]
	2:3
 */

/*
[debug]
println(solution(intArrayOf(1, 10, 9, 2, 3, 8, 7, 4, 5, 6), intArrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)).toMutableList())

____________________
preMax = 0 vs 1 = 1
____________________
preMax = 1 vs 2 = 2
index != 0
current leave: 9
subList from 3 to 3
sub: []
____________________
preMax = 2 vs 5 = 5
index != 0
current leave: 8
subList from 6 to 6
sub: []
____________________
preMax = 5 vs 6 = 6
index != 0
current leave: 7
subList from 7 to 7
sub: []
____________________
preMax = 6 vs 9 = 9
index != 0
current leave: 6
subList from 10 to 10
sub: []
____________________
preMax = 9 vs 8 = 9
index != 0
current leave: 5
subList from 9 to 10
sub: [6]
must meet 5 with 6
4++ 5++
____________________
preMax = 9 vs 7 = 9
index != 0
current leave: 4
subList from 8 to 10
sub: [5, 6]
must meet 4 with 5
3++ 4++
must meet 4 with 6
3++ 5++
____________________
preMax = 9 vs 4 = 9
index != 0
current leave: 3
subList from 5 to 10
sub: [8, 7, 4, 5, 6]
must meet 3 with 8
2++ 7++
must meet 3 with 7
2++ 6++
must meet 3 with 4
2++ 3++
must meet 3 with 5
2++ 4++
must meet 3 with 6
2++ 5++
____________________
preMax = 9 vs 3 = 9
index != 0
current leave: 2
subList from 4 to 10
sub: [3, 8, 7, 4, 5, 6]
must meet 2 with 3
1++ 2++
must meet 2 with 8
1++ 7++
must meet 2 with 7
1++ 6++
must meet 2 with 4
1++ 3++
must meet 2 with 5
1++ 4++
must meet 2 with 6
1++ 5++
____________________
preMax = 9 vs 0 = 9
index != 0
current leave: 1
subList from 1 to 10
sub: [10, 9, 2, 3, 8, 7, 4, 5, 6]
must meet 1 with 10
0++ 9++
must meet 1 with 9
0++ 8++
must meet 1 with 2
0++ 1++
must meet 1 with 3
0++ 2++
must meet 1 with 8
0++ 7++
must meet 1 with 7
0++ 6++
must meet 1 with 4
0++ 3++
must meet 1 with 5
0++ 4++
must meet 1 with 6
0++ 5++
[9, 7, 7, 5, 5, 5, 3, 3, 1, 1]

 */