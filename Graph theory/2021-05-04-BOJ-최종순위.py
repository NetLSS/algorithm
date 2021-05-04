# A45

from collections import deque
import sys

input = sys.stdin.readline

for test_case in range(int(input())):
    # 노드 개수
    n = int(input())
    # 진입 차수
    indegree = [0] * (n+1)
    # 각 노드에 연결된 간선 정보 인접 행렬
    graph = [[False] * (n+1) for _ in range(n+1)]
    # 작년 순위 정보
    data = list(map(int, input().split()))
    # 방향 그래프의 간선 정보 초기화
    for i in range(n):
        for j in range(i+1, n):
            graph[data[i]][data[j]] = True  # 자기 보다 낮은 것 가르키도록
            indegree[data[j]] += 1

    # 올해 변경된 순위 정보 입력
    m = int(input())
    for i in range(m):
        a, b = map(int, input().split())
        # 간선의 방향 뒤집기
        if graph[a][b]:
            graph[a][b] = False
            graph[b][a] = True
            indegree[a] += 1
            indegree[b] -= 1
        else:
            graph[a][b] = True
            graph[b][a] = False
            indegree[a] -= 1
            indegree[b] += 1

    # 위상 정렬(Topology Sort) 시작
    result = []  # 알고리즘 수행 결과가 저장될 리스트
    q = deque()  # 큐 기능을 위한 deque 라이브러리 사용

    # 처음 시작 시 진입 차수 0 인 노드를 큐에 삽입 (가장 순위 높은 노드)
    for i in range(1, n+1):
        if indegree[i] == 0:
            q.append(i)

    certain = True  # 위상 정렬 결과가 한 개 인지
    cycle = False  # 그래프 내 사이클 존재 여부

    # 노드 수 만큼 반복
    for i in range(n):
        # 큐가 비어 있다면 사이클이 발생 한것임
        if len(q) == 0:
            cycle = True
            break

        # 큐 원소 2개 이상일 경우 결과 여러가지라는 의미
        if len(q) >= 2:
            certain = False
            break

        # 큐에서 원소 꺼내기
        now = q.popleft()
        result.append(now)
        # 해당 원소와 연결된 노드 진입차수 -1
        for j in range(1, n+1):
            if graph[now][j]:
                indegree[j] -= 1
                # 새롭게 진입 차수가 0이 되는 노드를 큐에 삽입
                if indegree[j] == 0:
                    q.append(j)

    if cycle:
        print("IMPOSSIBLE")
    elif not certain:
        print("?")
    else:
        for i in result:
            print(i, end=' ')
        print()

"""
3
5
5 4 3 2 1
2
2 4
3 4
3
2 3 1
0
4
1 2 3 4
3
1 2
3 4
2 3


1
5
5 4 3 2 1
2
2 4
3 4
"""

