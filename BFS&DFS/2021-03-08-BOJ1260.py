from collections import deque
n, m , start = map(int, input().split())

graph = [[] for i in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(n+1):
    graph[i].sort()

dfs_visited = [-1] * (n+1)
bfs_visited = [-1] * (n+1)

dfs_result = []
bfs_result = []
stack = []
queue = deque()

def dfs(start):
    dfs_result.append(start)
    dfs_visited[start] = 1
    stack.append(start)

    for i in graph[start]:
        if dfs_visited[i] == -1:
            dfs(i)

dfs(start)

def bfs(start):
    bfs_result.append(start)
    bfs_visited[start] = 1
    queue.append(start)
    while queue:
        now = queue.popleft()
        for i in graph[now]:
            if bfs_visited[i] == -1:
                bfs_visited[i] = 1
                queue.append(i)
                bfs_result.append(i)

bfs(start)

print(*dfs_result)
print(*bfs_result)