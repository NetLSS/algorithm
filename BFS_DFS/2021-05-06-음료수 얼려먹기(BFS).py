from collections import deque

n, m = map(int, input().split())

dx = [-1,+1,0,0]
dy = [0,0,-1,+1]

data = []

for i in range(n):
    data.append(list(map(int,input())))

#print(*data,end=" ")
# 1,000,000
count = 0

for i in range(n):
    for j in range(m):
        #print(f"[{i}|{j}]")
        if data[i][j] == 0:
            #print(f"{i},{j}")
            count += 1
            data[i][j] = -1
            q = deque()
            q.append((i,j))
            while q:
                ci,cj = q.popleft()

                for ii in range(4): # i 변수 한번 더 쓰지 않도록 주의!!!
                    mi = ci + dx[ii]
                    mj = cj + dy[ii]
                    if mi < 0 or mj < 0 or mi >= n or mj >= m:
                        continue

                    if data[mi][mj] == 0:
                        data[mi][mj]=-1
                        q.append((mi,mj))
                        #print(f"{count}:{mi},{mj}")

print(count)

"""
4 5
00110
00011
11111
00000
3

15 14
00000111100000
11111101111110
11011101101110
11011101100000
11011111111111
11011111111100
11000000011111
01111111111111
00000000011111
01111111111000
00011111111000
00000001111000
11111111110011
11100011111111
11100011111111
8
"""