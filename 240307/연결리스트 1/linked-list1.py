import sys

IN = sys.stdin.readline

class Node:
    def __init__(self, text: str):
        self.text = text
        self.prev = None
        self.next_ = None

    def setNext(self, node):
        self.next_ = node
    
    def setPrev(self, node):
        self.prev = node

s_init = IN()[:-1]
cur = Node(s_init)


n = int(IN())

for _ in range(n):
    input_ = IN().split()

    if input_[0] == '1':
        cur.setPrev(Node(input_[1]))

    
    if input_[0] == '2':
        cur.setNext(Node(input_[1]))


    if input_[0] == '3':
        cur = cur.prev


    if input_[0] == '4':
        cur = cur.next_
    

    print(cur.prev.text if cur.prev is not None else '(Null)', cur.text, cur.next_.text if cur.next_ is not None else '(Null)')