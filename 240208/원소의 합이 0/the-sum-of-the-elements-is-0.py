import sys

IN = sys.stdin.readline

n = int(IN());

A = list(map(int, IN().split()))
B = list(map(int, IN().split()))
C = list(map(int, IN().split()))
D = list(map(int, IN().split()))


dict_ab = {}
dict_cd = {}

for a in A:
    for b in B:
        s = a + b
        if s in dict_ab:
            dict_ab[s] += 1
        else:
            dict_ab[s] = 1

for a in C:
    for b in D:
        s = a + b
        if s in dict_cd:
            dict_cd[s] += 1
        else:
            dict_cd[s] = 1



ans = 0

for k in dict_ab:
    if -k in dict_cd:
        ans += dict_ab[k] * dict_cd[-k]

print(ans)