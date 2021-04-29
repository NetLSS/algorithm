def find_parent(parent, x):
    if parent[x] != x:
        return find_parent(parent, parent[x])
    return x

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


n, m = map(int, input().split())

parent = [0] * n
edges = []
result = 0
total_cost = 0
for i in range(n):
    parent[i] = i

for _ in range(m):
    x, y, z = map(int, input().split())
    edges.append((z,x,y))
    edges.append((z,y,x))
    total_cost += z

# 중요! 비용 순 정렬을 하지 않으면 제대로 된 답이 나오지 않는다.
# 비용이 가장 낮은 순서 부터 신장 트리를 생성해야 올바른 답이 나오기 때문이다.
edges.sort()

for edge in edges:
    cost, a, b = edge
    
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost
    
print(total_cost - result)

"""
7 11
0 1 7
0 3 5
1 2 8
1 3 9
1 4 7
2 4 5
3 4 15
3 5 6
4 5 8
4 6 9
5 6 11
"""