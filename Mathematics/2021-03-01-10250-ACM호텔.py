import math
def f(H, W, N):
    ho = math.ceil(N/H)
    ch = N%H
    if ch == 0:
        ch = H
    print(f"{ch}{ho:02d}")

n = int(input())

for _ in range(n):
    H, W, N = map(int, input().split())
    f(H, W, N)
