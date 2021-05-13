n, m = map(int, input().split())
arr = list(map(int, input().split()))

def bin_search(arr, target, start, end):
    last_mid = 0
    mid = (start + end)//2
    while start <= end:
        last_mid = mid
        mid = (start + end)//2

        sum = 0
        
        for i in arr:
            if i > mid:
                sum += i - mid
        
        if sum == target:
            return mid
        
        if sum > target:
            start = mid + 1
        else:
            end = mid - 1
    return last_mid

print(bin_search(arr,m, 0, max(arr)))
    
"""
4 6
19 15 10 17

2 3
10 10
8
"""