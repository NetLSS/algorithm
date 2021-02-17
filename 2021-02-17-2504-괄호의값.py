
s = input().replace("()","2").replace("[]","3")


# (()[[]])([]) # 28
stack = []
for i in range(len(s)):
    if s[i] == '(' or s[i] == '[':
        stack.append(s[i])
    elif s[i] == ')':
        while True:
            p = stack.pop()
            sum = 0
            if p.isdigit():
                sum += int(p)
            if p == '(':
                sum *= 2
                stack.append(str(sum)+"+")

    elif s[i] == ']':

    