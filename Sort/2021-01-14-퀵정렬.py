array = [5,7,9,0,3,1,6,2,4,8]

def quick_sort(array, start, end):
    if start >= end: # 원소가 1개 인 경우 탈출
        return
    pivot = start # 피벗은 첫번 째 원소 기준
    left = start + 1
    right = end
    while left <= right:
        # 피벗 보다 큰 데이터 찾을 때 까지 반복
        while left <= end and array[left] <= array[pivot]:
            left += 1
        # 피벗 보다 작은 데이터 찾을 때 까지 반복
        while  start < right  and  array[right] >= array[pivot] :
            right -= 1

        if left > right: # 피벗이 엇갈린 경우, 파티션 후 loop 중지
            array[right], array[pivot] = array[pivot], array[right]
        else: # 엇갈리지 않은 경우
            array[left], array[right] = array[right], array[left]
    
    quick_sort(array, start, right - 1)
    quick_sort(array, right + 1, end)

quick_sort(array, 0, len(array) - 1)
print(array)
# [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]