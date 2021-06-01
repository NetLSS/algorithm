def find_parent(parent, a):
    if parent[a] != a:
        # 경로 압축 (최종적으로는 이부분 1번만 타면 모든 root를 가져올 수 있음)
        parent[a] = find_parent(parent, parent[a])
    return parent[a]

def union_parent(parent, a, b):
    a, b = find_parent(parent, a), find_parent(parent, b)

    if a > b:
        parent[a] = b
    else:
        parent[b] = a

v, e = map(int, input().split())
parent = [i for i in range(v + 1)]

# 입력 받은 union 수행
for i in range(e):
    a, b = map(int, input().split())
    union_parent(parent, a, b)

# 
for i in range(1, v + 1):
    print(find_parent(parent, i), end = ' ')

print()

for i in range(1, v + 1):
    print(parent[i], end = ' ')

"""
6 4
1 4
2 3
2 4
5 6

1 1 1 1 5 5 
1 1 1 1 5 5
"""