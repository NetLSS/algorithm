n = int(input())

while n!=1:
    i = 2
    while True:
        if n % i == 0:
            n /= i
            print(i)
            break
        i+=1