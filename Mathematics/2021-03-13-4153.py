# 4153

while True:
    data = list(map(int, input().split()))
    
    if sum(data) == 0:
        break
    
    data.sort()
    
    if data[0]**2 + data[1]**2 == data[2]**2:
        print('right')
    else:
        print('wrong')