import sys
input = sys.stdin.readline

def find_parent(parent, x):
    if parent[x] != x:
        return find_parent(parent, parent[x])
    return x

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b :
        parent[b] = a
    else :
        parent[a] = b

n = int(input())

parent = [0] * n
px = []
py = []
pz = []
edges = []

for i in range(n):
    parent[i] = i

for i in range(n):
    x,y,z = map(int, input().split())
    # x, y, z 를 각 리스트에 저장.
    # 처음에는 모든 간선을 확인하는 식으로 짜려고 했으나. 그럴경우 메모리 초과 발생.
    px.append((x,i))
    py.append((y,i))
    pz.append((z,i))

# 때문에 x,y,z 각각 정렬후 최소가 되는 값을 터널로 사용
px.sort()
py.sort()
pz.sort()

for i in range(n-1):
    edges.append((px[i+1][0]-px[i][0], px[i][1], px[i+1][1]))
    edges.append((py[i+1][0]-py[i][0], py[i][1], py[i+1][1]))
    edges.append((pz[i+1][0]-pz[i][0], pz[i][1], pz[i+1][1]))

edges.sort()
result = 0
for edge in edges:
    cost, a, b = edge
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost

print(result)

"""
5
11 -15 -15
14 -5 -15
-1 -1 -5
10 -4 -1
19 -4 19

"""