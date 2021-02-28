n = int(input())

corss = 1
cross_range = 1
add_num = 2

while True:
    if cross_range < n:
        cross_range += add_num
        add_num+=1
        corss+=1
    else:
        break

if add_num % 2 == 0:
    print(f"{corss - (n - (cross_range-corss)-1)}/{n - (cross_range-corss)}")
else:
    print(f"{n - (cross_range-corss)}/{corss - (n - (cross_range-corss)-1)}")
