n = int(input())
plans = list(map(str, input().split()))

current = (1,1)

for plan in plans:
    if plan == "L":
        c_row = current[0] + 0
        c_col = current[1] + -1
    elif plan == "R":
        c_row = current[0] + 0
        c_col = current[1] + 1
    elif plan == "U":
        c_row = current[0] + -1
        c_col = current[1] + 0
    elif plan == "D":
        c_row = current[0] + 1
        c_col = current[1] + 0


    if c_row < 1 or c_col < 1 or c_row > n or c_col > n:
        continue
    current = (c_row,c_col)

print(*current)