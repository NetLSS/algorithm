import sys

input = sys.stdin.readline
flush = sys.stdout.flush

def sol():
    n = int(input())
    m = int(input())
    INF = 1e9
    dp = [[INF] * (n+1) for _ in range(n+1)]

    for i in range(1, n+1):
        dp[i][i] = 0

    for i in range(m):
        a, b, v = map(int, input().split())
        if v < dp[a][b]:
            dp[a][b] = v

    for k in range(1,n+1):
        for a in range(1, n+1):
            if dp[a][k] == INF:
                continue
            for b in range(1, n+1):
                if dp[k][b] == INF or a == b:
                    continue
                if dp[a][b] > dp[a][k]+dp[k][b]: # min() 쓰는 것 보다 속도 빠른듯. 대입 때문에 그런가
                    dp[a][b] = dp[a][k]+dp[k][b]
                
    for a in range(1,n+1):
        for b in range(1,n+1):
            if dp[a][b] == INF:
                print(0, end=" ")
            else:
                print(dp[a][b], end=" ")
        print()

sol()