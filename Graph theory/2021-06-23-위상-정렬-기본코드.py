from collections import deque

# 노드의 개수와 간선 개수 입력 받기
v, e = map(int, input().split())

# 모든 노드의 대한 진입 차수를 0으로 초기화
indegree = [0] * (v + 1)

# 각 노드에 연결된 간선 정보를 담기 위한 연결 리스트(그래프) 초기화
graph = [[] for i in range(v + 1)]

# 방향 그래프의 모든 간선 정보를 입력받기
for _ in range(e):
    a, b = map(int, input().split())
    graph[a].append(b)
    
    # 진입 차수 1 증가
    indegree[b] += 1

# 위상 정렬 함수
def topology_sort():
    result = [] # 알고리즘 수행 결과
    q = deque()

    # 처음 시작할 때 진입차수가 0인 노드를 모두 삽입
    for i in range(1, v+1):
        if indegree[i] == 0:
            q.append(i)
    
    # 큐가 빌 때 까지 반복
    while q:
        # 큐에서 원소 꺼내기
        now = q.popleft()
        result.append(now)

        # 해당 원소와 연결된 모드들의 진입차수에서 1 빼기
        for i in graph[now]:
            indegree[i] -= 1

            # 새롭게 진입 차수가 0이 되는 노드를 큐에 삽입
            if indegree[i] == 0:
                q.append(i)

    # 위상 정렬을 수행한 결과 출력
    for i in result:
        print(i,end=' ')

topology_sort()

'''
7 8 
1 2
1 5
2 3
2 6
3 4
4 7
5 6
6 4
1 2 5 3 6 4 7
'''