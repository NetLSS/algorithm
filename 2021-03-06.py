# 1753
import heapq
import sys

input = sys.stdin.readline

INF = int(1e9)
V, E = map(int, input().split())
start = int(input())

graph = [[]for i in range(V+1)]
distance = [INF] * (V+1)



# parent = [] * (V + 1)
# edges = [ [] for i in range( V + 1)]

for i in range(E):
    u, v, w = map(int, input())
    graph[u].append((v, w))

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:


# def find_parent(parent, x):
#     if parent[x] != x:
#         parent[x] = find_parent(parent, parent[x])
#     return parent[x]

# def union_item(parent, a, b):
#     a = find_parent(parent, a)
#     b = find_parent(parent, b)

#     if a < b:
#         parent[b] = a
#     else:
#         parent[a] = b