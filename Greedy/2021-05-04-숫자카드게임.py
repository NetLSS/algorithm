n, m = map(int, input().split())

min_max = -9999

for row in range(n):
    arr = list(map(int, input().split()))
    arr.sort()
    min_max = max(min_max, arr[0])

print(min_max)

"""
2 4
7 3 1 8
3 3 3 4

3
"""