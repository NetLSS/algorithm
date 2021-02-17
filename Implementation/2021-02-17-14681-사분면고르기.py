def r(x, y):
    if x > 0:
        print(1 if y > 0 else 4)
    elif x < 0:
        print(2 if y > 0 else 3)

x = int(input())
r(x, int(input()))