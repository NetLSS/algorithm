"""
2021 ***** 3번 문제

그래프가 주어질 때
자기 자신 보다 작은 노드로 가는 길이의 총 합

5
1,2
2,3
3,4
4,5

20

노드 1은 2,3,4,5로 가는 거리 합
노드 2는 3,4,5 로 가는 거리합
노드 3은 4,5 로가는 거리합
노드 4는 5로 가는 거리합
= 20
"""

INF = 1e9
answer = 0

n = 5
dp = [ [INF] * (n+1) for _ in range(n+1)]

for i in range(1, n + 1):
    dp[i][i] = 0

arr  = [(1,2),(2,3),(3,4),(4,5)]

for a,b in arr:
    dp[a][b] = 1 # 거리는 모두 1


# 플로이드 워셜 알고리즘으로 3중 for문으로 k를 a->b를 갈때 k를 거쳐가는 a->k->b 거리가 더 짧으면 이 거리로 대체시킴.
for k in range(1, n+1):
    for a in range(1, n+1):
        if dp[a][k] == INF:
            continue
        for b in range(1, n+1):
            if dp[k][b] == INF or a== b:
                continue
            if dp[a][b] > dp[a][k]+dp[k][b]:
                dp[a][b] = dp[a][k]+dp[k][b]

for a in range(1,n+1):
    for b in range(1,n+1):
        if dp[a][b] == INF or a > b: # 자기 자신 보다 큰 노드로 가는 길 거리의 합만 더하기 위해서
            continue
        else:
            answer += dp[a][b]

print(answer)

