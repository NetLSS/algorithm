n = int(input())
arr = []

for _ in range(n):
    name, score = input().split()
    arr.append((name,int(score)))

arr.sort(key=lambda x: x[1])

print(*[i[0] for i in arr])

"""
2
홍길동 95
이순신 77

이순신 홍길동
"""