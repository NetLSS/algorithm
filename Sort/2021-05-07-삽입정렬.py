array = [ 7, 5, 9, 0, 3, 1, 6, 2, 4, 8, -9, -5, -6, -7]


for i in range(1, len(array)):
    breaked = False
    min_index = i-1
    for j in range(i-1,-1,-1):
        if j == 0 and array[j] > array[i]:
            array.insert(j, array.pop(i))
            break
        elif j == i-1 and array[j] < array[i]:
            break
        if array[j] < array[i]:
            array.insert(j+1, array.pop(i))
            breaked = True
            break
        
print(array)