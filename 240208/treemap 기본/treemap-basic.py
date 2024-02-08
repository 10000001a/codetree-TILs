import sys

from sortedcontainers import SortedDict

IN = sys.stdin.readline

n = int(IN())

sd = SortedDict()

for _ in range(n):
    line = IN().split()

    if line[0] == "add":
        sd[int(line[1])] = int(line[2])

    if line[0] == "remove":
        del sd[int(line[1])]

    if line[0] == "find":
        if int(line[1]) in sd:
            print(sd[int(line[1])])
        else:
            print("None")

    if line[0] == "print_list":
        if sd:
            print(' '.join(list(map(str, sd.values()))))
        else:
            print("None")