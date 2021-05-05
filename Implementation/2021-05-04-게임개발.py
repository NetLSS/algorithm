n, m = map(int, input().split())
a, b, d = map(int, input().split())

game_map = [[] * i for i in range(n)]


dx = [0,+1,0,-1] # row
dy = [-1,0,+1,0] # col
face = [0,1,2,3]
dx_back = [1,0,-1,0]
dy_back = [0,-1,0,+1]
# 0: 육지
# 1: 바다

# 0북, 1동, 2남, 3서
# 의 왼쪽은
# 좌, 상, 우, 하
for i in range(n):
    game_map[i] = list(map(int, input().split()))

print(game_map)

c_row = a
c_col = b
c_face = d

game_map[a][b] = -1
count = 1

while True:
    cannot_move_count = 0
    for i in range(4):
        move_row = c_row + dx[c_face]
        move_col = c_col + dy[c_face]
        if move_col < 0 or move_row < 0 or move_col > m or move_row > n:
            cannot_move_count+=1
            continue

        if game_map[move_row][move_col] == 0:
            c_row = move_row
            c_col = move_col
            
            print(f"moved {c_row},{c_col} (face:{c_face})")
            game_map[move_row][move_col] = -1
            count += 1
            
            break
        else:
            cannot_move_count+=1
        
        c_face = face[c_face-1]
    
    if cannot_move_count == 4:
        move_row = c_row + dx_back[c_face]
        move_col = c_col + dy_back[c_face]
        if move_col < 0 or move_row < 0 or move_col > m or move_row > n:
            break
        if game_map[move_row][move_col] == 1: 
            break

print(count)
"""
4 4
1 1 0
1 1 1 1
1 0 0 1
1 1 0 1
1 1 1 1
"""