import random
from time import sleep

random_offset = 1

group_num = [1,2,3,4,5] # 조
lottery_num = [i for i in range(1,46)]
print(lottery_num)

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

    lottery = []

    while True:
        random.shuffle(lottery_num)
        sleep(0.07)
        num = random.choice(lottery_num)
        lottery_num.remove(num)
        
        lottery.append(num)

        if len(lottery) == 6:
            break
    lottery.sort()
    print(f"{lottery}")