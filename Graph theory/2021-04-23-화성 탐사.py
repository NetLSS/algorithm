# Q39

import sys

input = sys.stdin.readline
flush = sys.stdout.flush

import heapq
INF = int(1e9)

dx = [-1,0,1,0]
dy = [0,1,0,-1]

T = int(input())
for _ in range(T):
    n = int(input())
    v_graph = [[0]*(n) for _ in range(n)]
    distance = [[INF]*(n) for _ in range(n)]
    for i in range(n):
        v_graph[i] = list(map(int, input().split()))

    x, y = 0, 0
    distance[x][y] = v_graph[x][y]
    q = [(distance[x][y], x, y)]

    while q:
        # 우선 순위 큐를 사용하여 최단 거리가 가장 짧은 노드 부터 pop
        dist, x, y = heapq.heappop(q)
        
        # 노드가 while로 부터 이미 처리된 경우 (최단 거리가 더 짧아져 있으면 갱신된것 이므로)
        if distance[x][y] < dist:
            continue

        # 현재 노드에서 각 방향으로 도착하는 거리가 원래 최단 거리 보다 짧은 경우 갱신
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue

            cost = dist + v_graph[nx][ny]
            if distance[nx][ny] > cost:
                distance[nx][ny] = cost
                heapq.heappush(q, (cost, nx, ny))
    
    # 각 테스트 케이스에 대한 정답 출력
    print(distance[n-1][n-1])

"""
[input]
3
3
5 5 4
3 9 1 
3 2 7
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
7
9 0 5 1 1 5 3
4 1 2 1 6 5 3
0 7 6 1 6 8 5
1 1 7 8 3 2 3
9 4 0 7 6 4 1
5 8 3 2 4 8 3
7 4 8 4 8 3 4

[output]
20
19
36
"""