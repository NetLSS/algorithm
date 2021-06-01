import heapq

# 도시 개수, 통로 개수, 최초 발송지
n, m, c = map(int, input().split()) 

INF = int(1e9)

# 각 간선 저장
graph = [ [] for _ in range(n + 1)] 

# 최단 거리
distance = [INF] * (n + 1) 

for _ in range(m):
    x, y, z = map(int, input().split())
    graph[x].append((y,z))

def dijkstra(start, graph, distance):
    distance[start] = 0
    q = [(0, start)]

    while q:
        dis, now = heapq.heappop(q)

        # 이미 갱신된적있으면 continue
        if distance[now] < dis :
            continue

        for target, cost in graph[now]:
            if distance[target] > dis + cost:
                distance[target] = dis + cost
                heapq.heappush(q, (distance[target], target))

dijkstra(c, graph, distance)

count = 0
time = 0
for item in distance:
    if item != INF:
        count += 1
        time = max(time, item)

# 최초 발송지 제외 (count - 1)
print(count-1, time)


    

