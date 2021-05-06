from collections import deque

n, m = map(int, input().split())

dx = [-1, +1, 0, 0]
dy = [0, 0, -1, +1]

data = []

for _ in range(n):
    data.append(list(map(int, input())))

data[0][0] = -1
q = deque([(0, 0, 1)])
count = 1

# BFS
while q:
    x, y, cnt = q.popleft()
    if x == n-1 and y == m-1:
        break
    for i in range(4):
        cx = x + dx[i]
        cy = y + dy[i]

        if cx < 0 or cy < 0 or cx >= n or cy >= m:
            continue

        if data[cx][cy] == 1:
            data[cx][cy] = -1
            q.append((cx, cy, cnt+1))

print(cnt)

"""
5 6
101010
111111
000001
111111
111111
10

3 3
110 
010
011
5
"""
