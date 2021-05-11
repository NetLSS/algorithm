n = int(input())
arr = []
for _ in range(n):
    arr.append(int(input()))

arr.sort(key=lambda x: -x)

print(*arr)

"""
3
15
27
12
27 15 12
"""