n = int(input())


count = 0

for i in range(n+1):
    if i != 0 and i % 3 == 0:
        count += 60*60
        continue

    # 0~59 중 3이 포함된 것은 15개
    count += 15 * 60 + 45 * 15

print(count)

