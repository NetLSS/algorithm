# Q.40
# my code (BFS)
import sys
from collections import deque

input = sys.stdin.readline
flush = sys.stdout.flush

import heapq
INF = int(1e9)

# 상하좌우
dx = [+0, +0, -1, +1]
dy = [-1, +1, +0, +0]

n, m = map(int, input().split())

graph = [[] for _ in range(n+1)]
visit = [False for _ in range(n+1)]
distance = [0 for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

start = 1
distance[start] = 0
visit[start] = True
q = deque([start])

while q:
    start = q.popleft()

    for b in graph[start]:
        if not visit[b]:
            distance[b] += distance[start] + 1
            visit[b] = True
            q.append(b)

max_distance = max(distance)
barn_num = distance.index(max_distance)
count = distance.count(max_distance)

print(barn_num, max_distance, count)

"""
[input]
6 7
3 6
4 3
3 2
1 3
1 2
2 4
5 2
[output]
4 2 3
"""