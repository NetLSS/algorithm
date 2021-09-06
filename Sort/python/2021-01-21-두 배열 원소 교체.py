n, k = map(int, input().split())

a = list(map(int, input().split()))
b = list(map(int, input().split()))

print(a)
print(b)

a.sort()
b.sort(reverse=True)

for i in range(k):
    if a[i] < b[i]:
        a[i], b[i] = b[i], a[i]
    else:
        break

print(sum(a))

"""
5 3
1 2 5 4 3
5 5 6 6 5
"""