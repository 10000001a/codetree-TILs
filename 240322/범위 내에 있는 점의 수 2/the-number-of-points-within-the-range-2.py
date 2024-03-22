import sys

IN = sys.stdin.readline

N, Q = map(int, IN().split())

dots = sorted(list(map(int, IN().split())))
dots_set = set(dots)

sum_ = [0]
ans = 0

for i in range(1, dots[-1]+ 1):
    if i in dots_set:
        sum_.append(sum_[-1] + 1)
    else:
        sum_.append(sum_[-1])


for _ in range(Q):
    x, y = map(int, IN().split())
    x = x if x > 0 else 1
    if x >= len(sum_):
        print(0)
        continue

    y = min(y, len(sum_) - 1)
    
    print(sum_[y] - sum_[x - 1])