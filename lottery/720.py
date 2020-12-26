import random
from time import sleep

random_offset = 1

group_num = [1,2,3,4,5] # 조
lottery_num = [0,1,2,3,4,5,6,7,8,9]

# 7
random.shuffle(lottery_num)
sleep(0.07)
random.shuffle(lottery_num)
sleep(0.07)
random.shuffle(lottery_num)
sleep(0.07)
random.shuffle(lottery_num)
sleep(0.07)
random.shuffle(lottery_num)
sleep(0.07)
random.shuffle(lottery_num)
sleep(0.07)
random.shuffle(lottery_num)
sleep(0.07)

loop_num = int(input("뽑을 개수:"))

for i in range(loop_num):

    sleep(0.07)
    group = random.choice(group_num) # 조

    lottery = []

    while True:
        sleep(0.07)
        num = random.choice(lottery_num)
        
        lottery.append(num)

        if len(lottery) == 6:
            break

    print(f"{group}조: {lottery}")