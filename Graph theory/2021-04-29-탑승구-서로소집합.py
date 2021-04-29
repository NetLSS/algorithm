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

g = int(input())
p = int(input())

parent = [0] * (g + 1)

for i in range(1, g + 1):
    parent[i] = i

result = 0

for _ in range(p):
    data = find_parent(parent, int(input())) # 루트를 가져왔을 때
    if data == 0 : # 0 이면 도킹 불가한것임
        break
    union_parent(parent, data, data-1) # 아닌 경우 도킹후 루트를 도킹게이트-1로 설정. 그래야 알맞게 다음 도킹 차례 때 도킹 되지 않은 높은 게이트 부터 도킹 하므로
    result += 1

print(result)