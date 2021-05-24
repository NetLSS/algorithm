# 2798번

n, m = map(int, input().split())

arr = list(map(int, input().split()))

ret = 0
for i in range(len(arr)):
    for j in range(len(arr)):
        for k in range(len(arr)):
            if i == j or i == k or k == j:
                continue
            if i < j or i < k or k < j:
                continue
            if arr[i]+arr[j]+arr[k] <= m:
                ret = max(ret, arr[i]+arr[j]+arr[k])

print(ret)