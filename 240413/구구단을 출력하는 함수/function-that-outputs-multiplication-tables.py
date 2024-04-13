import sys

IN = sys.stdin.readline

li = sorted(list(map(int, IN().split())))

for i in range(li[0], li[2] + 1):
    if i == li[1]:
        continue
    
    for j in range(1, 10):
        print('{} * {} = {}'.format(i, j, i * j))