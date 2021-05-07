array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(arr, start, end):
    p = start
    l = start + 1
    r = end

    if start >= end:
        return

    while l <= r:
        while l <= end and arr[l] <= arr[p]:
            l += 1
        while r > start and arr[r] >= arr[p]:
            r -= 1

        if l > r:
            arr[p], arr[r] = arr[r], arr[p]
        else:
            arr[r], arr[l] = arr[l], arr[r]

    quick_sort(arr, start, r-1)
    quick_sort(arr, r+1, end)

quick_sort(array, 0, len(array)-1)

print(array)
