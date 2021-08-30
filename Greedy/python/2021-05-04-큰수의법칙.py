n, m, k = map(int, input().split())

numbers = list(map(int, input().split()))

numbers.sort(reverse=True)
print(numbers)
result = 0

result = (numbers[0]*k + numbers[1])*(m//(k+1)) + (numbers[0]*(m%(k+1)))

print(result)