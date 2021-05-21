n, m = map(int, input().split())
arr = []
for _ in range(n):
    arr.append(int(input()))

dp = [10_001] * (m + 1)

dp[0] = 0

for i in range(len(arr)):
    for j in range(arr[i], m + 1):
        dp[j] = min(dp[j], dp[j - arr[i]] + 1)

if dp[m] == 10_001:
    print(-1)
else:
    print(dp[m])

"""
2 15
2 
3
5

3 7
2
3
5
2
"""