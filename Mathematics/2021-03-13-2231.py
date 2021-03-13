# 2231
n = input()
t = False
for i in range(1, int(n)):
    str_i = str(i)
    sum_i = 0
    for si in str_i:
        sum_i+=int(si)
    sum_i += i
    if sum_i == int(n):
        print(i)
        t = True
        break
if t==False:
    print(0)