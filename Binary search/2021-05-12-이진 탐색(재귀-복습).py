def bin_search(arr, target, start, end):
    if start >= end:
        return None

    mid = (start+end)//2

    if arr[mid] == target:
        return mid+1

    if arr[mid] > target:
        return bin_search(arr, target, start, end-1)
    else:
        return bin_search(arr, target, start+1, end)


n, target = map(int, input().split())
arr = list(map(int, input().split()))

ret=bin_search(arr, target, 0, len(arr)-1)

print(ret)







'''
10 7
1 3 5 7 9 11 13 15 17 19

10 8
1 3 5 7 9 11 13 15 17 19
'''
