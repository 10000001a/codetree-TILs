import sys

IN = sys.stdin.readline

N, K = map(int, IN().split())

x = [set([i]) for i in range(K + 1)]

seat = {
    i: i for i in range(K + 1)
}

print(seat)

change = [
    tuple(map(int, IN().split())) for _ in range(K) 
]

print(change)