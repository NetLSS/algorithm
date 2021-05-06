from collections import deque

def bfs(graph, v, visited):
    q = deque()

    q.append(v)

    visited[v] = True

    while q:

        popped_v = q.popleft()
        
        print(popped_v, end=' ')
        
        for x in sorted(graph[popped_v]):
            if not visited[x]:
                visited[x] = True
                q.append(x)
    


# 그래프 인접 리스트 표현 방식 (가중치는 모두 동일 하다는 가정)
# 연결된 노드 번호만 저장
graph = [
    [],
    [2,3,8],
    [1,7],
    [1,4,5],
    [3,5],
    [3,4],
    [7],
    [2,6,8],
    [1,7]
]

visited = [False] * 9

bfs(graph, 1, visited)