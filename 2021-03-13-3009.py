#3009

x1,y1 = map(int,input().split())
x2,y2 = map(int,input().split())
x3,y3 = map(int,input().split())

xs = [x1,x2,x3]
ys = [y1,y2,y3]

while True:
    xnow = xs.pop()
    if xnow not in xs:
        x = xnow
        break
    else:
        xs=[xnow]+xs

while True:
    ynow = ys.pop()
    if ynow not in ys:
        y = ynow
        break
    else:
        ys=[ynow]+ys
print(x,y)