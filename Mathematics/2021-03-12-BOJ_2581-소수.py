m = int(input())
n = int(input())

def is_sosu(num):
    if num == 1:
        return False
    if num == 2 or num == 3:
        return True
    
    for i in range(2,num//2+1):
        if num%i == 0:
            return False
    return True

sum_ = 0
min_sosu = -1

for i in range(m,n+1):
    if is_sosu(i):
        if min_sosu == -1:
            min_sosu = i
        sum_ += i

if min_sosu!=-1:
    print(sum_)
    print(min_sosu)
else:
    print(-1)
