# 1753

V, E = map(int, input().split())
start = int(input())


parent = [] * (V + 1)
edges = [ [] for i in range( V + 1)]

for i in range(E):
    edges[u] = (w, v)
    

def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_item(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b