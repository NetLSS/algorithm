from typing import cast


n = int(input())

dp = [-1] * 251
dp[0] = 1 # 2x0 직사각형을 채우는 방법의 수는 1가지입니다. "아무것도 안 하는 것"을 하나의 방법으로 셉니다.
dp[1] = 1
dp[2] = 3
def solve(n):
    if dp[n] != -1:
        return dp[n]
    dp[n] = solve(n-1) + 2*solve(n-2)
    return dp[n]

is_do = True
while is_do:
    print(solve(n))
    try:
        n = int(input())
    except:
        is_do=False

