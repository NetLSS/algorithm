# 변경하지 않은 경우, 각각 숫자가 다른 기호로 변환되는 경우를 못함 

from collections import deque
import re
def solution(numstrs, words):
    answer = [0] * len(words)

    symbol = [
        ["O","()","ㄱ"],     #0
        ["I","ㄴ"],          #1
        ["Z","S","F","ㄷ"], #2 # 7_ 처리하기*
        ["E","B","ㄹ"],      #3
        ["A","ㅁ"],          #4
        ["Z","S","ㅂ"],      #5
        ["b","G","ㅅ"],      #6
        ["T","Y","ㅇ"],      #7 
        ["B","K","ㅈ"],     #8 # E3 처리하기 **
        ["g","q","ㅊ"]       #9    
        ]      

    # 숫자 문자열 범위 만큼 반복
    for i in range(len(words)):
        cur_words = words[i] # "2455373"
        used_symbol = []
        cur_answers = deque([cur_words])
        # 0~9 까지 심볼 차례대로 변경 
        for j in range(len(symbol)):
            for k in range(len(cur_answers)):
                cur_answer :str= cur_answers.popleft()
                added = False
                for sym in symbol[j]:
                    # 바꾸려는 숫자가 있고 and 현재 심볼이 사용되고 있지 않으면.
                    if cur_answer.find(str(j)) != -1 and cur_answer.find(sym) == -1:
                        new_answer = re.sub(str(j), sym, cur_answer)
                        cur_answers.append(new_answer)
                        added = True
                if(not added):
                    cur_answers.append(cur_answer)
            
        cur_answers = set(cur_answers)
        cur_answers = list(cur_answers)
        for j in range(len(cur_answers)):
            cur_answers[j] = re.sub("F", "7_", cur_answers[j])
            cur_answers[j] = re.sub("K", "E3", cur_answers[j])

            cur_answers[j] = re.sub("ㄱ", "0", cur_answers[j])
            cur_answers[j] = re.sub("ㄴ", "1", cur_answers[j])
            cur_answers[j] = re.sub("ㄷ", "2", cur_answers[j])
            cur_answers[j] = re.sub("ㄹ", "3", cur_answers[j])
            cur_answers[j] = re.sub("ㅁ", "4", cur_answers[j])
            cur_answers[j] = re.sub("ㅂ", "5", cur_answers[j])
            cur_answers[j] = re.sub("ㅅ", "6", cur_answers[j])
            cur_answers[j] = re.sub("ㅇ", "7", cur_answers[j])
            cur_answers[j] = re.sub("ㅈ", "8", cur_answers[j])
            cur_answers[j] = re.sub("ㅊ", "9", cur_answers[j])
        
        for numstr in numstrs:
            for ans in cur_answers:
                if numstr.find(ans) != -1:
                    answer[i] += 1


                
        
    return answer
solution(["ZASSETE", "S4Z537B", "7_ASZEYB"],	["2455373", "425", "373", "378"]) # S4Z537B, 7_ASZEYB
"""
입출력 예
numstrs	words	result
["ZASSETE", "S4Z537B", "7_ASZEYB"],	["2455373", "425", "373", "378"]	[3, 2, 3, 2]
["ZAZZ373"]	["2422373", "5455373", "2455373"],	[1, 1, 0]
"""


"""
문제 설명
다음과 같이 숫자를 알파벳 대소문자, 숫자, 기호를 조합해서 표현할 수 있습니다.

숫자	기호
0	O(알파벳 대문자 오), ()
1	I(알파벳 대문자 아이)
2	Z, S, 7_
3	E, B
4	A
5	Z, S
6	b, G
7	T, Y
8	B, E3
9	g, q
이때, 숫자로 이루어진 문자열을 표현하는 방법은 다음과 같습니다.

각 숫자는 정해진 방식에 따라 비슷한 모양의 다른 기호로 치환해서 적습니다.
1-1. 이때, 다른 기호로 치환하지 않고 그대로 적어도 됩니다.
한 숫자가 서로 다른 기호로 치환될 수 있습니다.
단, 서로 다른 숫자가 같은 기호로 치환되지는 않습니다.
예를 들어 숫자 "2455373"의 경우 다음과 같은 방식으로 치환됩니다.

"ZASSETE", "S4Z537B", "7_ASZEYB", ...

다음은 "2455373"을 치환한 결과가 아닙니다.

"ZAZZ373"

첫 번째 숫자 2와 세 번째 숫자 5가 같은 기호 'Z'로 치환되어 3번 규칙에 맞기 않기 때문입니다. 따라서 위 문자열의 경우 원래 문자열은 "2422373" 또는 "5455373"입니다.

또 다른 예시로 숫자 "225"의 경우 다음과 같이 치환할 수 있습니다.

"ZZ5", "ZZS", "SSZ", "Z7_S", "S7_Z", "SZ5" ...

그러나 "225"를 "ZSZ" 나 "SSS"와 같이 치환할 수는 없습니다.

문자열들이 담긴 배열 numstrs와 숫자로된 단어들이 담긴 배열 words가 매개변수로 주어질 때, 각 단어가 포함된 문자열은 몇개인지 순서대로 배열에 담아 return 하도록 solution 함수를 완성해주세요.

제한사항
numstrs의 길이는 1 이상 100 이하입니다.
numstrs의 각 원소는 길이가 1 이상 100 이하인 문자열입니다.
numstrs의 문자열은 알파벳 대소문자와 숫자, 특수 문자 (, ), _로만 이루어져 있습니다.
규칙에 맞게 치환한 문자열만 입력으로 주어집니다.
words의 길이는 1 이상 10 이하입니다.
words의 원소는 길이가 1 이상 8 이하인 문자열입니다.
words의 문자열은 숫자로만 이루어져 있습니다.
숫자 문자열은 0으로 시작할 수 있습니다.
매칭된 부분 문자열을 제외한 나머지 문자열들이 올바르게 치환된 문자열이 아니어도 괜찮습니다.
예를 들어 "B7_"에서, 37"를 검색한 경우, "B7"가 "37"를 치환한 문자열로 검색되고 "_"는 매칭되는 문자가 없지만 무시해도 됩니다.
입출력 예
numstrs	words	result
["ZASSETE", "S4Z537B", "7_ASZEYB"]	["2455373", "425", "373", "378"]	[3, 2, 3, 2]
["ZAZZ373"]	["2422373", "5455373", "2455373"]	[1, 1, 0]
입출력 예 설명
입출력 예 #1

숫자로된 단어	포함 문자열
"2455373"	ZASSETE", "S4Z537B, 7_ASZEYB
"425"	S4Z537B, 7_ASZEYB
"373"	ZASSETE, S4Z537B, 7_ASZEYB
"378"	S4Z537B, 7_ASZEYB
"425"의 경우 '2'와 '5'가 동시에 S로 치환될 수 없기 때문에 "ZASSETE" 의 "ASS"에 해당되지 않습니다.

입출력 예 #2

문제의 설명과 같습니다.
"""


"""
S4Z537B
['7_4SSETE', '7_4SS3Y3', 'S455ETE', '2ASSETE', '24ZZ373', 'Z4SSBYB', '7_A553Y3', '2ASS3T3', '2A553Y3', '24SS3Y3', '7_AZZ373', '7_A553T3', '7_4SSE7E', 'SAZZBYB', ...]
"""