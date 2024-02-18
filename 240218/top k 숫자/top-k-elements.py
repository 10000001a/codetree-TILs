import sys
from sortedcontainers import SortedSet

IN = sys.stdin.readline

n, k = map(int, IN().split())

s_set = SortedSet()

for i in map(int, IN().split()):
    s_set.add(i)


print(
    ' '.join(
        list(
            map(
                lambda i: str(s_set[i]),
                range(len(s_set) - 1, len(s_set) - 1 - k, -1)
            )
        )
    )
)