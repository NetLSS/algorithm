def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b

v, e = map(int, input().split())
parent = [0] * (v + 1)

edges = []
result = 0

# 부모를 자기 자신으로 초기화
for i in range(1 ,v + 1):
    parent[i] = i

# 간선 입력 받기
for _ in range(e):
    a, b, cost = map(int, input().split())
    edges.append((cost, a, b))

# 비용 순 오름차 정렬 
edges.sort()

# 크루스칼 알고리즘
for edge in edges:
    cost, a, b = edge

    # 사이클이 발생하지 않을 떄만 union
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost
    
print(result)


"""
7 9
1 2 29
1 5 75
2 3 35
2 6 34
3 4 7
4 6 23
4 7 13
5 6 53
6 7 2

159
"""