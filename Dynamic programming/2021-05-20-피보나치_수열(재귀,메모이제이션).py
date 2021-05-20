# top-down : 큰 문제를 해결하기 위해 작은 문제를 호출

dp = [0] * 100

def fibo(x):
    if x == 1 or x == 2:
        return 1
    
    if dp[x] != 0:
        return dp[x]
    
    dp[x] = fibo(x-1) + fibo(x-2)
    return dp[x]

print(fibo(99))
