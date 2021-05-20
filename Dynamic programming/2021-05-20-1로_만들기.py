x = int(input())

d = [0] * 30001

# 1은 계산하지 않아도 되므로 최소 계산 횟수 0
# for문에서 2부터 사용자가 입력한 x 수까지 차례대로 최소 계산수를 구해나간다.

for i in range(2, x + 1):
    # 현재 수에서 1을 빼는 경우
    d[i] = d[i-1] + 1

    # 현재 수가 2로 나누어 떨어지는 경우
    if i % 2 == 0:
        d[i] = min(d[i], d[i//2] + 1)
    
    # 현재 수가 3으로 나누어 떨어지는 경우
    if i % 3 == 0:
        d[i] = min(d[i], d[i//3] + 1)
    
    # 현재 수가 5로 나누어 떨어지는 경우
    if i % 5 == 0:
        d[i] = min(d[i], d[i//5] + 1)

print(d[x])

"""
26
3
"""


# num = int(input())
# count = 0
# def to1(num, count):
#     if num == 1:
#         return count

#     if num % 5 == 0:
#         num /= 5
#     elif (num-1) % 5 == 0:
#         num -= 1
#     elif num % 3 == 0:
#         num /= 3
#     elif (num-1) % 3 == 0:
#         num -= 1
#     elif num % 2 == 0:
#         num /= 2
#     else:
#         num -= 1

#     count += 1
#     return to1(num, count)

# print(to1(num,count))
