test_array = [[1,2,3],[4,5,6],[7,8,9]]

def rotate_90(m):
    N = len(m)
    ret = [[0] * N for _ in range(N)]

    for r in range(N):
        for c in range(N):
            ret[c][N-1-r] = m[r][c] # 회전 전 열 == 회전 후 행, 회전 후 열 == N-1-회전 전 행
    return ret

def rotate_180(m):
    N = len(m)
    ret = [[0]*N for _ in range(N)]
    """
    회전 후의 행 번호는 N-1 의 값에서 전의 행 번호를 뺀 것과 같다.
    회전 후의 열 번호는 N-1 의 값에서 전의 열 번호를 뺀 것과 같다.
    """
    for r in range(N):
        for c in range(N):
            ret[N-1-r][N-1-c] = m[r][c]
    return ret

def rotate_270(m):
    N = len(m)
    ret = [[0]*N for _ in range(N)]
    for r in range(N):
        for c in range(N):
            ret[N-1-c][r] = m[r][c]
    return ret

def rotate(m, d):
    """
    2차원 배열을 90도 단위로 회전하여 따로 반환
    2차원 배열은 열과 행의 수가 같은 정방형 배열에 해당
    input: 
    m: 회전하고자 하는 2차원 정방형 배열
    d: 90도 회전 단위 (-1: -90도, 1: 90도, 2: 180도)
    """
    N = len(m)
    ret = [[0]*N for _ in range(N)]
    
    if d % 4 == 1:
        for r in range(N):
            for c in range(N):
                ret[C][N-1-r] = m[r][c]
    elif d % 4 == 2:
        for r in range(N):
            for c in range(N):
                ret[N-1-c][N-1-r] = m[r][c]
    elif d % 4 == 3:
        for r in range(N):
            for c in range(N):
                ret[N-1-c][r] = m[r][c]
    else:
        for r in range(N):
            for c in range(N):
                ret[r][c] = m[r][c]
                
    return ret

print(rotate_90(test_array))
"""
[[7, 4, 1], 
[8, 5, 2], 
[9, 6, 3]]
"""
print(rotate_180(test_array))
"""
[[9, 8, 7], 
[6, 5, 4], 
[3, 2, 1]]
"""
print(rotate_270(test_array))
"""
[[3, 6, 9],
[2, 5, 8], 
[1, 4, 7]]
"""


# [[0]*N]*N 을 사용하지 않는 이유

arr1 = [[0]*3 for _ in range(3)]
arr2 = [[0]*3]*3

arr1[0][0] = 999
arr2[0][0] = 999

print(arr1) # [[999, 0, 0], [0, 0, 0], [0, 0, 0]]
print(arr2) # [[999, 0, 0], [999, 0, 0], [999, 0, 0]]
# arr

"""
-1%4 == 3
-1%4 == (-1*4 +3)%4 == 3

(-5) / 4 = -1.25 --> floor(-1.25) = -2
(-5) % 4 = (-2 × 4 + 3) % 4 = 3.
"""

# https://shoark7.github.io/programming/algorithm/rotate-2d-array