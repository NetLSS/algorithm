# 메모리 초과...

def edit_dist(str1, str2):
    n = len(str1)
    m = len(str2)

    dp = [[0]*(m+1) for _ in range(n+1)]
    dp_str = [""]*(m+1) #[[]*(m+1) for _ in range(n+1)]
    dp_str_tmp = [""]*(m+1) #[[]*(m+1) for _ in range(n+1)]
    #dp_str[0][0] = []
    
    for i in range(1, n + 1):
        dp[i][0] = i
        #dp_str[i][0] = [('a',str1[i-1])] #f"a {str1[i-1]}\n"

    for j in range(1, m + 1):
        dp[0][j] = j
        #dp_str[0][j] =  [('a',str2[j-1])] #f"a {str2[j-1]}\n"
        dp_str[j] = f"a{str2[j-1]}"
    #print(dp_str)
    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if str1[i-1] == str2[j-1]: #  복사
                dp[i][j] = dp[i - 1][j - 1]
                #dp_str[i][j] += dp_str[i - 1][j - 1] + ('c',str2[j-1])#f"c {str2[j-1]}\n"
                dp_str_tmp[j] = dp_str[j-1] + f"c{str2[j-1]}"
            else:
                min_num = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1])
                dp[i][j] = 1 + min_num
                if min_num == dp[i][j-1]: # 삽입
                    #dp_str[i][j] += dp_str[i][j-1] + ('a',str2[j-1])#+ f"a {str2[j-1]}\n"
                    dp_str_tmp[j] = dp_str[j-1] + f"a{str2[j-1]}"
                elif min_num == dp[i-1][j]: # 삭제
                    #dp_str[i][j] += dp_str[i-1][j] + ('d',str2[j-1])#+ f"d {str2[j-1]}\n"
                    #dp_str_tmp[j] = dp_str[j] + f" d {str2[j-1]}"
                    pass
                else: # 교체
                    #dp_str[i][j] += dp_str[i-1][j-1] + ('m',str2[j-1])#+ f"m {str2[j-1]}\n"
                    dp_str_tmp[j] = dp_str[j-1] + f"m{str2[j-1]}"
        dp_str = dp_str_tmp
    
    #print((dp_str[n][m])[:-1])
    #print(dp_str[-1])
    for i , v in enumerate(dp_str[-1]) :
        if i % 2 == 0:
            print(v,end=' ')
        else:
            print(v)
        

edit_dist(input(), input())