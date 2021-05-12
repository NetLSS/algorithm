def bin_search(arr, target, start, end):
    
    while start <= end:
        mid = (start+end)//2

        if arr[mid] == target:
            return mid+1
        
        if arr[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return None

n, target = map(int,input().split())
arr = list(map(int,input().split()))

print(bin_search(arr, target, 0, len(arr)-1))

    


'''
10 7
1 3 5 7 9 11 13 15 17 19

10 8
1 3 5 7 9 11 13 15 17 19
'''