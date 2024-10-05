from typing import List, Optional
from collections import deque


class Node:
    def __init__(self, id: int, parent_id: int, color: int, max_depth: int):
        self.id = id
        self.parent_id = parent_id
        self.children: List = []
        self.color = color
        self.max_depth = max_depth

    def add_child(self, child_node):
        if self.max_depth == 1:
            return

        if child_node.max_depth >= self.max_depth:
            child_node.change_max_depth(self.max_depth - 1)
        self.children.append(child_node)

    def change_color(self, color: int) -> None:
        self.color = color

    def change_max_depth(self, max_depth: int):
        self.max_depth = max_depth

    def get_binary_color(self) -> int:
        return 2 ** (5 - self.color)


class Tree:
    def __init__(self):
        self.root: List[Node] = []
        self.node_list: List[Optional[Node]] = [None] * 100001

    def add_node(self, id, parent_id, color, max_depth) -> None:
        new_node = Node(id, parent_id, color, max_depth)
        self.node_list[id] = new_node

        if parent_id == -1:
            self.root.append(new_node)
        else:
            self.node_list[parent_id].add_child(new_node)

    def change_color(self, id, color) -> None:
        target_node = self.node_list[id]

        will_visit: deque[Node] = deque([target_node])

        while will_visit:
            current_visit_node = will_visit.popleft()

            will_visit.extend(current_visit_node.children)

            current_visit_node.change_color(color)

    def get_color(self, id: int) -> int:
        return self.node_list[id].color

    def get_score(self) -> int:
        score = 0
        for root in self.root:
            score = score + self.get_score_each(root)

        return score

    def get_score_each(self, root: Node) -> int:
        score_list = [0] * 100001

        will_visit = deque([root])

        while will_visit:
            current_node: Node = will_visit.popleft()

            will_visit.extend(current_node.children)

            score_list[current_node.id] = current_node.get_binary_color()

            if current_node.parent_id == -1:
                continue

            parent_node: Node = self.node_list[current_node.parent_id]

            while parent_node is not None:
                binary_str = bin(score_list[parent_node.id])
                binary_str = binary_str[2:]
                if len(binary_str) < 5:
                    binary_str = '0' * (5 - len(binary_str)) + binary_str
                if binary_str[current_node.color - 1] == '1':
                    break

                score_list[parent_node.id] = score_list[parent_node.id] | score_list[current_node.id]

                parent_node = self.node_list[parent_node.parent_id]

        return sum(map(lambda b: (bin(b).count('1') ** 2), score_list))


###########################################################################

N = int(input())

tree = Tree()

for _ in range(N):
    command_and_args = input().split()

    command = command_and_args[0]

    if command == '100':
        tree.add_node(
            int(command_and_args[1]),
            int(command_and_args[2]),
            int(command_and_args[3]),
            int(command_and_args[4])
        )

    if command == '200':
        tree.change_color(int(command_and_args[1]), int(command_and_args[2]))

    if command == '300':
        print(tree.get_color(int(command_and_args[1])))

    if command == '400':
        print(tree.get_score())