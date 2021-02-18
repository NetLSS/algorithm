
s = input()#.replace("()","2+").replace("[]","3+")

def func(s):
    # (()[[]])([]) # 28
    stack = []

    for i in range(len(s)):
        if s[i] == '(' or s[i] == '[':
            stack.append(s[i])
        elif s[i] == ')':
            e_v = ""
            sum = 0
            while True:
                try:
                    p = stack.pop()
                except:
                    print(0)
                    return
                if p == '(':
                    if len(e_v) == 0:
                        sum = 2
                    else:
                        try:
                            sum = int(eval(e_v[:-1]))
                            sum *= 2
                        except:
                            print(0)
                            return
                    stack.append(str(sum)+"+")
                    break
                else:
                    e_v += p
                
        elif s[i] == ']':
            e_v = ""
            sum = 0
            while True:
                try:
                    p = stack.pop()
                except:
                    print(0)
                    return
                if p == '[':
                    if len(e_v) == 0:
                        sum = 3
                    else:
                        try:
                            sum = int(eval(e_v[:-1]))
                            sum *= 3
                        except:
                            print(0)
                            return
                    stack.append(str(sum)+"+")
                    break
                else:
                    e_v += p
    try:
        print(eval(''.join(stack)[:-1]))
    except:
        print(0)
    
func(s)