import sys

IN = sys.stdin.readline

N, M = map(int, IN().split())

group_a = []
group_b = []

for _ in range(N):
    group_a.append(list(IN()[0:M]))

for _ in range(N):
    group_b.append(list(IN()[0:M]))

count = 0

for i in range(M-2):
    for j in range(i+1, M-1):
        for k in range(j+1, M):
            
            intersection = set([(a[i], a[j], a[k]) for a in group_a]).intersection(set([(b[i], b[j], b[k]) for b in group_b]))

            if not intersection:
                count+= 1
            
print(count)