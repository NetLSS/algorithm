import math
import sys

input = sys.stdin.readline

t = int(input())

def is_prime_num(l, r):
    arr = [True for i in range(r+1)]
    arr[1] = False

    for i in range(2, int(math.sqrt(r))+1):
        if arr[i] == True:
            j = 2
            while i * j <= r:
                arr[i*j] = False
                j += 1
    return arr

arr = is_prime_num(1, 10000)
for i in range(t):
    n = int(input())
    l = -1
    gap = int(1e9)
    for index in range(len(arr)):
        if arr[index]:
            if arr[n-index]:
                if abs(index - (n-index)) < gap:
                    gap = abs(index - (n-index)) 
                    l = index
    print(l, n-l)
