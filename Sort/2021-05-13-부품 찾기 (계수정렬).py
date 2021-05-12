n = int(input())
item_list = list(map(int, input().split()))

# 조건) 1 <= N <= 1,000,000
exsits_list = [False for _ in range(1_000_000 + 1)]

for item in item_list:
    exsits_list[item] = True

m = int(input())
order_list = list(map(int, input().split()))

for order in order_list:
    if exsits_list[order]:
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
