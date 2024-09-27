numbers = [1, 2, 3, 5, 4, 6, 7, 8, 9 , 10, 11, 12, 13]

num = []

for i in range(1, 14):
    num.append(i)

num.sort(key=str)

def lexicalOrder(n):
    num = [i for i in range(1, n + 1)].sort(key=str)
    # for i in range(1, 14):
    #     num.append(i)

    return num

print(lexicalOrder(13))

print(num)