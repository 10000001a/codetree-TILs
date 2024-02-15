import sys

IN = sys.stdin.readline

a_count, b_count = map(int, IN().split(' '))

set_a = set(map(int, IN().split()))
set_b = set(map(int, IN().split()))

print(len((set_a - set_b).union (set_b - set_a) ))