import math



def is_sosu(n):
    if n == 1:
        return False
    if n == 2 or n == 3:
        return True
    for i in range(2, n//2+1):
        if n%i == 0:
            return False
    return True

def is_prime_num(l, r):
    arr = [True for i in range(r+1)]
    arr[1] = False

    for i in range(2, int(math.sqrt(r))+1):
        if arr[i] == True:
            j = 2
            while i * j <= r:
                arr[i*j] = False
                j += 1
    return len([i for i in range(l, r+1) if arr[i]])


while True:
    n = int(input())
    if n == 0:
        break

    l, r = n+1, n*2

    print(is_prime_num(l,r))