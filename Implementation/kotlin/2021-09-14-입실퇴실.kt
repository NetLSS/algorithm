import java.util.*
import kotlin.math.max
import kotlin.math.min

class Solution210914T1946 {
    fun solution(enter: IntArray, leave: IntArray): IntArray {
        var answer: IntArray = IntArray(enter.size){0}

        var preMax = 0
        leave.mapIndexed { index, l ->
            preMax = max(preMax, enter.indexOf(l))
            if (index != 0) {
                println("subList from ${enter.indexOf(l) + 1} to ${preMax + 1}")
                println("current l: $l")
                for (e in enter.toMutableList().subList(enter.indexOf(l) + 1, preMax + 1)) {
                    answer[l-1]++
                    answer[e-1]++
                }
            }
        }

        return answer
    }
}

fun main() {
    Solution210914T1946().run {
        println(solution(intArrayOf(3,2,1), intArrayOf(1, 3, 2)))
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