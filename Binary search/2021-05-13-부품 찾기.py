def bin_search(arr, target, start, end):
    while start <= end:
        mid = (start+end)//2

        if arr[mid] == target:
            print("yes", end='')
            return

        if arr[mid] > target:
            end = mid - 1
        else:
            start = mid + 1

    print("no", end='')


n = int(input())
item_list = list(map(int, input().split()))

m = int(input())
order_list = list(map(int, input().split()))

item_list.sort()

for order in order_list:
    bin_search(item_list, order, 0, len(item_list)-1)
    print(" ", end='')

"""
5
8 3 7 9 2
3
5 7 9
no yes yes 
"""

# for order in order_list:
#     if order in item_list:
#         print("yes ", end='')
#     else:
#         print("no", end='')
