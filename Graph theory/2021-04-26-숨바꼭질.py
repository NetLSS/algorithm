# Q.40

import sys

input = sys.stdin.readline
flush = sys.stdout.flush

import heapq
INF = int(1e9)

# 상하좌우
dx = [+0, +0, -1, +1]
dy = [-1, +1, +0, +0]

n, m = map(int, input().split())
v_graph = [[INF]*(n+1) for _ in range(n+1)] # 거리 비용
distance = [[INF]*(n+1) for _ in range(n+1)] # 최단 거리

for i in range(n+1):
    v_graph[i][i] = 0
    distance[i][i] = 0

for _ in range(m):
    a, b = map(int, input().split())
    v_graph[a][b] = 1

q = [(distance[1][1], 1, 1)]

while q:
    dis, a, b = heapq.heappop(q)

    if dis > distance[a][b] :
        continue

    for i in range(1,n+1):
        if v_graph[a][i] != INF:
            cost = distance[a][i] + dis

            if cost < distance[a][i]:
                distance[a][i] = cost
                heapq.heappush(q, (cost, a, i))
    # for i in range(4):
    #     cx = a+dx[i]
    #     cy = b+dy[i]

    #     if cx < 0 or cy < 0 or cx >= n+1 or cy >= n+1:
    #         continue

    #     cost = distance[cx][cy] + dis

    #     if cost < distance[cx][cy]:
    #         distance[cx][cy] = cost
    #         heapq.heappush(q, (cost, cx, cy))
    

print(distance)

"""
6 7
3 6
4 3
3 2
1 3
1 2
2 4
5 2
"""