import random

random_offset = 1

loop_num = int(input("뽑을 개수:"))

for i in range(loop_num):

    group = random.randrange(1, 5 + random_offset) # 조

    lottery = []

    while True:
    
        num = random.randrange(0, 9 + random_offset)
        
        if num in lottery:
            continue

        lottery.append(num)

        if len(lottery) == 6:
            break

    print(f"{group}조: {lottery}")