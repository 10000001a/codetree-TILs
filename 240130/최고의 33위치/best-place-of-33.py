import sys

IN = sys.stdin.readline

n = int(IN())

table = [list(map(int, IN().split())) for _ in range(n)]

def x(i, j):
    result = 0

    for x in range(i, i+3):
        for y in range(j, j + 3):
            if table[x][y] == 1:
                result += 1
    
    return result

result = 0


for i in range(0, n - 2):
    for j in range(0, n - 2):
        result = max(x(i, j), result)

print(result)