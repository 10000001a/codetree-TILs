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
        new_node = Node(input_[1])
        
        if cur.prev is not None:
            cur.prev.setNext(new_node)
            new_node.setPrev(cur.prev)
        new_node.setNext(cur)
        cur.setPrev(new_node)

    
    if input_[0] == '2':
        new_node = Node(input_[1])

        if cur.next_ is not None:
            cur.next_.setPrev(new_node)
            new_node.setNext(cur.next_)
        new_node.setPrev(cur)
        cur.setNext(new_node)



    if input_[0] == '3' and cur.prev is not None:
        cur = cur.prev


    if input_[0] == '4' and cur.next_ is not None:
        cur = cur.next_
    

    print(cur.prev.text if cur.prev is not None else '(Null)', cur.text, cur.next_.text if cur.next_ is not None else '(Null)')