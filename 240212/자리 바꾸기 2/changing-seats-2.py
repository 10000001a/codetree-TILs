import sys

IN = sys.stdin.readline

N, K = map(int, IN().split())

x = [set([i]) for i in range(N + 1)]

seat = {
    i: i for i in range(N + 1)
}

change = [
    tuple(map(int, IN().split())) for _ in range(K) 
]

for _ in range(3):
    for a, b in change:
        tmp = seat[a]
        seat[a] = seat[b]
        seat[b] = tmp

        x[seat[a]].add(a)
        x[seat[b]].add(b)


for i in range(1, N + 1):
    print(len(x[i]))