import sys
input = sys.stdin.readline
INF = int(1e9)

# 노드의 개수, 간선의 개수를 입력 받기
n, m = map(int, input().split())
# 시작 노드 번호를 입력받기
start = int(input())
# 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트 만들기
graph = [[] for _ in range(n + 1)]
# 방문한 적이 있는지 체크하는 목적의 리스트를 만들기
visited = [False for i in range(n + 1)]
# 최단 거리 테이블을 모두 무한으로 초기화
distance = [INF for i in range(n + 1)]
# 모든 간선 정보를 입력 받기
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
# 방문 하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드의 번호를 반환


def get_smallest_node():
    min_value = INF
    index = 0
    for i in range(1, n+1):
        if not visited[i]:
            if min_value > distance[i]:
                min_value = distance[i]
                index = i
    return index

# dijkstra


def dijkstra(start):
    # 시작 노드에 대해서 초기화
    distance[start] = 0
    visited[start] = True
    # 시작 노드와 연결된 노드의 거리 초기화
    for j in graph[start]:
        distance[j[0]] = j[1]
    # 시작 노드를 제외한 전체 n - 1 개의 노드에 대한 반복
    for i in range(n-1):
        now = get_smallest_node()
        visited[now] = True
        for data in graph[now]:
            cost = distance[now] + data[1]
            if cost < distance[data[0]]:
                distance[data[0]] = cost


# 다익스트라 알고리즘 수행
dijkstra(start)
# 모든 노드로 가기 위한 최단 거리를 출력
for i in range(1, n + 1):
    if distance[i] == INF:
        print("INFINITY")
    else:
        print(distance[i])

"""
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2


[output]
0
2
3
1
2
4
"""
