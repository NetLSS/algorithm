from collections import deque

queue = deque()

queue.append(5)
queue.append(2)
queue.append(3)
queue.append(7)
queue.popleft()
queue.append(1)
queue.append(4)
queue.popleft()

print(queue) #  deque([3, 7, 1, 4])
queue.reverse()
print(queue) # deque([4, 1, 7, 3])

print(list(queue)) # [4, 1, 7, 3]