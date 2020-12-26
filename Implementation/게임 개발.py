rows, cols = map(int,input().split())
cur_r, cur_c, cur_way = map(int, input().split())
game_maps = []
ways = [(-1,0),(0,1),(1,0),(0,-1)] # 북, 동, 남, 서
anticlockwise = [(0,-1), (-1,0), (0,1), (1,0)]
back = [(1,0),(0,-1),(-1,0),(0,1)]
for i in range(rows):
    i_map = list(map(int, input().split()))
    game_maps.append(i_map)
game_maps[cur_r][cur_c] = -1

print(game_maps)
loop = True
cnt = 0
while loop:
    move = False
    for i in range(4):
        mov_r, mov_c = anticlockwise[cur_way]
        cur_way = ways.index((mov_r,mov_c))
        mov_r += cur_r
        mov_c += cur_c
        if mov_c >= 0 and mov_r >= 0 and mov_c < cols and mov_r < rows:
            if game_maps[mov_r][mov_c] == 0:
                cur_c = mov_c
                cur_r = mov_r
                game_maps[cur_r][cur_c] = -1
                move = True
                cnt += 1
                print("0",cur_r, cur_c)
                print(game_maps)
                input("0")
                break
    if move == False:
        mov_r, mov_c = back[cur_way]
        mov_r += cur_r
        mov_c += cur_c
        if mov_c > 0 and mov_r > 0 and mov_c < cols and mov_r < rows:
            if game_maps[mov_r][mov_c] != 1:
                cur_c = mov_c
                cur_r = mov_r
                cnt+=1
                print("1-0",cur_r, cur_c)
                print(game_maps)
                input("1-0")
            if game_maps[mov_r][mov_c] == 1:
                loop = False
                print("1",cur_r, cur_c)
                print(game_maps)
                input("1")
        else:
            loop = False
    print("2",cur_r, cur_c)
    print(game_maps)
    input("2")


print(cnt)


"""
  남
서  동
  북
4 4
1 1 0
1 1 1 1
1 0 0 1
1 1 0 1
1 1 1 1
"""
