import sys

input = sys.stdin.readline

def find_parent(parent, x):
    if parent[x] != x:
        return find_parent(parent, parent[x])
    return x

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b: # 부모가 큰 녀석을 작은 부모에 연결 (법칙이 아니라 하겠다고 따로 내가 약속)
        parent[b] = a
    else:
        parent[a] = b


n, m = map(int, input().split())

parent = [i for i in range(n+1)]
plan_root = []

for i in range(1, n+1):
    arr = [0] + list(map(int, input().split()))
    for j in range(1, n+1):
        if arr[j] == 1:
            union_parent(parent, i, j)


plan_root = list(map(int, input().split()))

changed = False
current_parent = find_parent(parent, plan_root[0])

for i in range(1,m):
    if current_parent != find_parent(parent, plan_root[i]):
        changed = True
        break

if changed:
    print("NO")
else:
    print("YES")
        

"""
[input]
5 4
0 1 0 1 1
1 0 1 1 0
0 1 0 0 0
1 1 0 0 0
1 0 0 0 0
2 3 4 3
[output]
YES
"""