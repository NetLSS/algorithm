n, m = map(int, input().split())
INF = int(1e10)
graph = [ [INF] * (n+1) for _ in range(n+1)]

# 자기 자신으로 가는 비용은 0
for i in range(1, n+1):
    graph[i][i] = 0

for _ in range(m):
    a, b = map(int, input().split())

    # 양 방향 연결
    graph[a][b] = 1
    graph[b][a] = 1

x, k = map(int, input().split())

for mid in range(1, n+1):
    for start in range(1, n+1):
        if graph[start][mid] == INF:
            continue
        for end in range(1, n+1):
            if graph[mid][end] == INF:
                continue
            graph[start][end] = min(graph[start][end], graph[start][mid] + graph[mid][end])

if (graph[k][x]) == INF or graph[1][k] == INF:
    print(-1)
else:
    print(graph[1][k] + graph[k][x])

"""
5 7
1 2
1 3
1 4
2 4 
3 4
3 5
4 5
4 5

[out-put]
3


"""


"""
4 2
1 3
2 4
3 4


-1
"""