import sys

IN = sys.stdin.readline

tmp = {}

n = int(IN())

for _ in range(n):
    x, y = map(int, IN().split())

    if x in tmp:
        tmp[x] = min(tmp[x], y)
    else:
        tmp[x] = y

print(sum(tmp.values()))