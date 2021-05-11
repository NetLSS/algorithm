def binary_search(array, target, start, end):
    # 못 찾는 경우
    # 보유값 보다 낮은값이 target 인 경우 start==0, end==-1 이 되어 None 반환
    # 보유값 보다 높은값이 target 인 경우 start==len(array)+1, end==len(array) 이 되어 None 반환
    if start > end:
        return None

    mid = (start + end) // 2

    if array[mid] == target:
        return mid

    if array[mid] > target:
        return binary_search(array, target, start, mid-1)
    else:
        return binary_search(array, target, mid+1, end)


n, target = list(map(int, input().split()))

array = list(map(int, input().split()))

result = binary_search(array, target, 0, n - 1)

if result == None:
    print("원소가 존재하지 않음")
else:
    print(result + 1)

'''
10 7
1 3 5 7 9 11 13 15 17 19
'''
