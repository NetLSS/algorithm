arr = [[] for i in range(14+1)]

for i in range(0,14+1):
    if i == 0:
        for j in range(0,14):
            arr[i].append(j+1)
    else:
        for j in range(0,14):
            if j == 0:
                arr[i].append(1)
            else:
                arr[i].append(arr[i][j-1] + arr[i-1][j])
                
n = int(input())
for _ in range(n):
    a = int(input())
    b = int(input())
    print(arr[a][b-1])