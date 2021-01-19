import queue

n = int(input())
que = []

for i in range(n):
    que.append(int(input()))

for i in range(len(que)):
    max_index = i
    for j in range(i+1, len(que)):
        if que[j] > que[max_index]:
            max_index = j
    que[i], que[max_index] = que[max_index], que[i]

print(que)