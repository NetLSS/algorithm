array = [('바나나', 2, 1), ('사과', 5, 1), ('당근', 3, 9), ('피자', 3, 1)]


def setting(data):
    return data[1]


array.sort(key=setting)  # 1번 인덱스로만 비교 정렬

print(array)
# [('바나나', 2, 1), ('당근', 3, 9), ('피자', 3, 1), ('사과', 5, 1)]

print(sorted(array, key=lambda x: (x[1], x[2])))  # 1번 인덱스 값과 동일하면 2번째 인덱스로 비교
# [('바나나', 2, 1), ('피자', 3, 1), ('당근', 3, 9), ('사과', 5, 1)]
