array = [6,9,7,8]
# [6,5,4,3]
#[5, 7, 9, 0, 3, 1, 6, 2, 4, 8]



def quick_sort(arr, start, end):

    # 원소가 1개인 경우 종료
    if start >= end:
        return
    
    p = start # 첫 번째 데이터를 피벗으로 정함 (호어 분할 방식)
    left = start + 1 
    right = end 

    while left <= right:
        
        # 피벗 보다 큰 데이터 없으면 End+1 인덱스 까지 감
        while left <= end and arr[left] <= arr[p]:
            left += 1

        # 피벗 보다 작은 데이터 없으면 start 즉 pivot 인덱스 까지 감
        while right > start and arr[right] >= arr[p]:
            right -= 1


        if left > right:
            arr[p], arr[right] = arr[right], arr[p]

        else:
            arr[right], arr[left] = arr[left], arr[right]

    quick_sort(arr, start, right-1)
    quick_sort(arr, right+1, end)

quick_sort(array, 0, len(array)-1)

print(array)
