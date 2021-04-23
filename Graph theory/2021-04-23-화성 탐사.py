# Q39

import sys

input = sys.stdin.readline
flush = sys.stdout.flush
INF = int(1e9)

def dij(a,b):
    if vis_graph[a][b]:
        return
    vis_graph[a][b] = True

    if b+1<n: #and vis_graph[a][b+1]: #우
        dij_graph[a][b+1] = min(dij_graph[a][b+1], v_graph[a][b]+v_graph[a][b+1])
    if b-1>=0: #and vis_graph[a][b-1]: # 좌
        dij_graph[a][b-1] = min(dij_graph[a][b-1], v_graph[a][b]+v_graph[a][b-1])
    if a-1>=0: #and vis_graph[a-1][b]: # 상
        dij_graph[a-1][b] = min(dij_graph[a-1][b], v_graph[a][b]+v_graph[a-1][b])
    if a+1<n: #and vis_graph[a+1][b]: # 하
        dij_graph[a+1][b] = min(dij_graph[a+1][b], v_graph[a][b]+v_graph[a+1][b])




T = int(input())
for _ in range(T):
    n = int(input())
    v_graph = [[0]*(n) for _ in range(n)]
    dij_graph = [[INF]*(n) for _ in range(n)]
    vis_graph = [[False]*(n) for _ in range(n)]
    for i in range(n):
        v_graph[i] = list(map(int, input().split()))

    dij_graph[0][0] = v_graph[0][0]
    vis_graph[0][0] = True
    
    for i in range(n):
        for j in range(n):
            dij(i, j)
    
    print(dij_graph)
