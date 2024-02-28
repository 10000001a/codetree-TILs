import heapq
import sys

IN = sys.stdin.readline

n, m = map(int, IN().split())

nums = list(map(lambda x: -int(x), IN().split()))

for _ in range(m):
    heapq.heappush(nums, heapq.heappop(nums)+1)

print(-heapq.heappop(nums))