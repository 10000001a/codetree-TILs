import sys

IN = sys.stdin.readline

n = int(IN())

x = set()

for _ in range(n):
    cmd, num = IN().split()
    num = int(num)

    if cmd == "find":
        print(str(num in x).lower())
        

    if cmd == "add":
        x.add(num)

    if cmd == "remove":
        x.remove(num)