# 큰 데이터와 작은 데이터의 차이가 1,000,000 이하 일 때 쓰면 효율적 (양의 정수)

array = [7,5,9,0,3,1,6,2,9,1,4,8,0,5,2]

count = [ 0 for _ in range(9 - 0 + 1)]

for item in array:
    count[item] += 1

for i, num in enumerate(count):
    print(f"{i}"*num, end='')
print()