n, k = map(int, input().split())

count = 0

while n != 1:
    if n % k == 0:
        n //= k
        count+=1
    elif n < k:
        count += n-1
        n = 1
    else:
        rest = n % k
        n = n - rest
        count += rest

print(count)   