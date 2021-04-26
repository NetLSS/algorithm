# A40

import heapq

import sys


input = sys.stdin.readline

INF = int(1e9)


n, m = map(int, input().split())


start = 1

graph = [[] for _ in range(n + 1)]

distance = [INF] * (n + 1) # 초기 최단 거리는 모두 무한대로 초기화


for _ in range(m):

    a, b = map(int, input().split())

    graph[a].append((b, 1))

    graph[b].append((a, 1))


def dijkstra(start):
    q = []

    distance[start] = 0 # 시작 노드는 거리 0으로 설정
    heapq.heappush(q, (distance[start], start))

    while q:

        dist, now = heapq.heappop(q)

        if distance[now] < dist:
            continue


        for node_num, node_dist in graph[now]:

            cost = dist + node_dist

            # 최단 거리 갱신
            if cost < distance[node_num]:
                distance[node_num] = cost
                heapq.heappush(q, (cost, node_num))

dijkstra(start)

max_node = 0
max_distance = 0
result = []

for i in range(1, n + 1):
    if max_distance < distance[i]: # 더 큰 값이 있다면, 최대 거리 갱신
        max_node = i
        max_distance = distance[i] 
        result = [max_node] # 최대 거리 노드 개수 배열 초기화
    elif max_distance == distance[i]:
        result.append(i)

print(max_node, max_distance, len(result))

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