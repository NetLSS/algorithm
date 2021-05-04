xy_data = input()

col = ord(xy_data[0]) - ord('a') + 1
row = int(xy_data[1])

steps = [(-1, -2), (+1, -2), (-2, -1), (-2, +1),
         (+2, -1), (+2, +1), (-1, +2), (+1, +2)]

count = 0

for ix, iy in steps:
    c_col = col + ix
    c_row = row + iy

    if c_col < 1 or c_row < 1 or c_col >= 8 or c_row >= 8:
        continue
    count += 1

print(count)