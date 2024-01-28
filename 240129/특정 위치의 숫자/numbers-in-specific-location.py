import sys

li = list(map(int, sys.stdin.readline().split(' ')))
# print(li)

result = 0

result += li[2]
result += li[4]
result += li[9]

print(result)