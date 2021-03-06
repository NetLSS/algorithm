# 1011번

import math

T = int(input())

for _ in range(T):
    x, y = map(int, input().split())
    distance = y - x # 거리

    # 내림
    num = math.floor(math.sqrt(distance))   # n제곱 <= 거리 < (n+1)제곱일때 n제곱 # 4일때 2
    num_square = num ** 2   # n제곱의 제곱 
    increase_num = math.sqrt(num_square) 

    if distance < 4:
        print(distance)
        continue

    if distance == num_square:
        print(2 * num - 1)
        continue
    elif num_square < distance <= num_square + increase_num:
        print(2 * num)
        continue
    elif num_square + increase_num < distance:
        print(2 * num + 1)
        continue

