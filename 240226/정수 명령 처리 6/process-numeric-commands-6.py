import heapq
import sys

IN = sys.stdin.readline

N = int(IN())

heap = []

for _ in range(N):
    args = IN().split()

    if args[0] == 'push':
        heapq.heappush(heap, -int(args[1]))

        
    if args[0] == 'size':
        print(len(heap))

    if args[0] == 'empty':
        print(1 if len(heap) == 0 else 0)

    if args[0] == 'pop':
        print(-heapq.heappop(heap))

    if args[0] == 'top':
        print(-heap[0])