import sys

IN = sys.stdin.readline

n, m = map(int, IN().split())


table = [
    list(map(int, IN().split())) for _ in range(n)
]


result = 0

for i in range(n):
    before = -1
    count = 0
    for j in range(n):
        if before != table[i][j]:
            count = 1
            before = table[i][j]
        else:
            count += 1
        
        if count >= m:
            result += 1
            break

    before = -1
    count = 0
    for j in range(n):
        if before != table[j][i]:
            count = 1
            before = table[j][i]
        else:
            count += 1
        
        if count >= m:
            result += 1
            break

print(result)