import sys
from collections import deque

IN = sys.stdin.readline

class Shelf:
    def __init__(self):
        self.books = deque()
    
    def initBooks(self, until):
        self.books = deque(range(1, until+1))

    def isEmpty(self):
        return len(self.books) == 0
    
    def popleft(self):
        return self.books.popleft()
    
    def pop(self):
        return self.books.pop()

    def popall(self):
        tmp = list(self.books)
        self.books = deque()
        return tmp


    def appendleft(self, book):
        return self.books.appendleft(book)
    
    def append(self, book):
        return self.books.append(book)

    def appendleftall(self, books):
        self.books.extendleft(reversed(books))
        # self.books = deque(list(books) + list(self.books))
    
    def appendall(self, books):
        self.books = deque(list(self.books) + list(books))
    

n, k = map(int, IN().split())

shelfs = [None] + [ Shelf() for _ in range(k)]
shelfs[1].initBooks(n)

q = int(IN())

for _ in range(q):
    k, i, j = map(int, IN().split())

    if k == 1 and not shelfs[i].isEmpty():
        shelfs[j].append(shelfs[i].popleft())

    if k == 2 and not shelfs[i].isEmpty():
        shelfs[j].appendleft(shelfs[i].pop())

    if k == 3:
        shelfs[j].appendleftall(shelfs[i].popall())

    if k == 4:
        shelfs[j].appendall(shelfs[i].popall())
    
for s in shelfs[1:]:

     print(len(s.books), ' '.join(map(str, s.books)))