# A38 문제

import sys

input = sys.stdin.readline
flush = sys.stdout.flush
INF = int(1e9)
def sol():
    n, m = map(int, input().split())
    dp = [[INF] * (n+1) for _ in range(n+1)]
    
    for a in range(1,n+1):
        dp[a][a] = 0
    
    for _ in range(m):
        a, b = map(int, input().split())
        dp[a][b] = 1
    
    for k in range(1, n+1):
        for a in range(1, n+1):
            for b in range(1, n+1):
                dp[a][b] = min(dp[a][b], dp[a][k]+dp[k][b])
    
    result = 0

    # 도달 가능 체크
    for i in range(1, n+1):
        count = 0
        for j in range(1, n+1):
            # i == j [i][j] 인경우는 무조건 카운트. 이후 나머지는 비교가능(도달 가능 시 ) 카운트)
            if dp[i][j] != INF or dp[j][i] != INF: 
                count += 1
        if count == n:
            result += 1

    print(result)
sol()

"""
입력:
6 6
1 5
3 4
4 2
4 6
5 2
5 4
출력:
1
"""