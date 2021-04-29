import sys
input = sys.stdin.readline

gate_num = int(input())
plane_num = int(input())

docking_num = []
is_dock_gate_num = [False] * gate_num

for _ in range(plane_num):
    docking_num.append(int(input())-1)

count = 0
for i in range(plane_num):
    is_all_full = True
    for target_gate in range(docking_num[i], -1, -1):
        if is_dock_gate_num[target_gate] == False:
            is_all_full = False
            is_dock_gate_num[target_gate] = True
            count+=1
            break
    if is_all_full:
        break

print(count)

"""
[input1]
4
3
4
1
1
[output1]
2

[input2]
4
6
2
2
3
3
4
4
[output2]
3
"""