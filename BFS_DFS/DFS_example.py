def dfs(graph, v, visited):
    # 방문 처리
    visited[v] = True 
    print(v, end=' ')

    # 연결된 노드중 미방문 노드 방문 처리 (재귀)
    for i in sorted(graph[v]): # 2개 이상 시 낮은 번호 부터 방문하도록 정렬
        if visited[i] == False:
            dfs(graph, i, visited)


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

dfs(graph, 1, visited)