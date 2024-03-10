import sys

IN = sys.stdin.readline

n, k = map(int, IN().split())

nums = list(map(int, IN().split()))

sum_ = sum(nums[:k])
max_ = sum_

for i in range(k, n):
    sum_ -= nums[i - k]
    sum_ += nums[i]

    max_ = max(max_, sum_)

print(max_)