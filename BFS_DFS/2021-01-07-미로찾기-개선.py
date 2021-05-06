from collections import deque

n, m = map(int, input().split())

graph = []

for i in range(n):
    graph.append(list(map(int, input())))

# 상, 하, 좌, 우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# BFS 소스코드 구현
def bfs(x, y):
    # 큐(Queue) 구현을 위해 deque 라이브러리 사용
    queue = deque()
    queue.append((x,y))

    # queue가 빌 때까지 반복
    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            # 범위 검사
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            
            # 벽 검사
            if graph[nx][ny] == 0:
                continue
            
            # 처음 방문시 최단 거리 기록
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))
                if nx == n -1 and ny == m -1:
                    return graph[n - 1][m - 1]
                
    return graph[n - 1][m - 1]
    
print(bfs(0,0))
