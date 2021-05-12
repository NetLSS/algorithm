n = int(input())
item_set = set(map(int, input().split())) # set 자료형 사용

m = int(input())
order_list = list(map(int, input().split()))

for order in order_list:
    if order in item_set:
        print("yes ", end='')
    else:
        print("no ", end='')

"""
5
8 3 7 9 2
3
5 7 9
no yes yes 
"""
