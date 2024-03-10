import sys 

IN = sys.stdin.readline

n, k, b = map(int, IN().split())

dropped = set()

for _ in range(b):
    dropped.add(int(IN()))
    # dropped.append(int(IN()))

ans = [1 if 1 in dropped else 0]

# print(ans)

for i in range(2, k + 1):
    # print('i: ',i)
    if i in dropped:
        ans.append(ans[i - 2] + 1)
    else:
        ans.append(ans[i - 2])

# print(ans)

for i in range(k + 1, n + 1):
    da = 0

    # print(i - k, i)

    if i - k in dropped:
        da -= 1
    
    if i in dropped:
        da += 1

    ans.append(ans[i - 2] + da)

#     3 4   6 7 8
# 1 2     5       9 10
# print(ans)
    
print(min(ans))