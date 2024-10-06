from collections import deque
from enum import Enum
from typing import Tuple, Optional, List


class Direction(Enum):
    NORTH = 0
    EAST = 1
    SOUTH = 2
    WEST = 3

    @staticmethod
    def from_num(num: int):
        if num > 3:
            num = num - 4
        return [Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST][num]

    def to_move_stat(self) -> Tuple[int, int]:
        if self is Direction.NORTH:
            return -1, 0

        if self is Direction.EAST:
            return 0, 1

        if self is Direction.SOUTH:
            return 1, 0

        if self is Direction.WEST:
            return 0, -1


class Cell:
    def __init__(self, row, col):
        self.row = row
        self.col = col


class Golem:
    def __init__(self, id: int, col: int, exit_dir: Direction):
        self.id = id
        self.location = Cell(-2, col)
        self.exit = exit_dir

    def move_down(self):
        self.location = Cell(self.location.row + 1, self.location.col)

    def move_west(self):
        self.location = Cell(self.location.row, self.location.col - 1)
        self.exit = Direction.from_num(self.exit.value - 1)

    def move_east(self):
        self.location = Cell(self.location.row, self.location.col + 1)
        self.exit = Direction.from_num(self.exit.value + 1)


class Forest:
    def __init__(self, row: int, column: int):
        self.score = 0
        self.golems = {}
        self.map: List[List[int]] = []
        for _ in range(row):
            self.map.append(list([-1] * column))

    def golem_start(self, golem: Golem):
        self.golems[golem.id] = golem
        while True:
            result = self.move_golem(golem)

            if not result:
                break

        if golem.location.row < 1:
            self.clear_golem()
            return

        self.save_golem(golem)
        # print('score:', self.get_score(golem) + 1)
        new_score = self.get_score(golem)
        if new_score >= 2:
            self.score = self.score + new_score + 1

    def move_golem(self, golem: Golem) -> bool:
        if self.is_south_empty(golem):
            golem.move_down()
            return True

        if self.is_west_empty(golem):
            golem.move_west()
            golem.move_down()
            return True

        if self.is_east_empty(golem):
            golem.move_east()
            golem.move_down()
            return True

        return False

    def is_south_empty(self, golem):
        center = golem.location

        result: bool = True

        if center.row + 2 >= len(self.map):
            return False

        if center.row >= -2 and center.row + 2 < len(self.map):
            result = result and self.map[center.row + 2][center.col] == -1

        if center.row >= -1:
            result = (result and
                      self.map[center.row + 1][center.col - 1] == -1 and
                      self.map[center.row + 1][center.col + 1] == -1)

        return result

    def is_west_empty(self, golem):
        center = golem.location

        result: bool = True

        if center.col == 1 or center.row >= len(self.map) - 2:
            return False

        if center.row >= -1:
            result = result and self.map[center.row + 1][center.col - 1] == -1

        if result and center.row >= 0:
            result = (result and
                      self.map[center.row][center.col - 2] == -1)

        if result and center.row >= 1:
            result = (result and
                      self.map[center.row - 1][center.col - 1] == -1)

        result = (result and
                  self.map[center.row + 1][center.col - 2] == -1 and
                  self.map[center.row + 2][center.col - 1] == -1)

        return result

    def is_east_empty(self, golem):
        center = golem.location

        result: bool = True

        if center.col >= len(self.map[0]) - 2 or center.row >= len(self.map) - 2:
            return False

        if center.row >= -1:
            result = result and self.map[center.row + 1][center.col + 1] == -1

        if result and center.row >= 0:
            result = (result and
                      self.map[center.row][center.col + 2] == -1)

        if result and center.row >= 1:
            result = (result and
                      self.map[center.row - 1][center.col + 1] == -1)

        result = (result and
                  self.map[center.row + 1][center.col + 2] == -1 and
                  self.map[center.row + 2][center.col + 1] == -1)

        return result

    def check_golem_can_go_south(self, golem: Golem):
        center: Cell = golem.location

        if center.row >= len(self.map) - 1:
            return False

        return (self.map[center.row + 2][center.col - 1] == -1 and
                self.map[center.row + 2][center.col] == -1 and
                self.map[center.row + 2][center.col + 1] == -1)

    def save_golem(self, golem):
        center: Cell = golem.location

    # if center.row >= -1:
        self.map[center.row + 1][center.col] = golem.id

    # if center.row >= 0:
        self.map[center.row][center.col - 1] = golem.id
        self.map[center.row][center.col] = golem.id
        self.map[center.row][center.col + 1] = golem.id

    # if center.row >= 1:
        self.map[center.row - 1][center.col] = golem.id

    def clear_golem(self):
        self.golems = {}
        for j in range(len(self.map)):
            self.map[j] = list([-1] * len(self.map[0]))

    def get_score(self, golem: Golem) -> int:
        score = -1
        will_visit = deque([golem])
        visited = set()

        while will_visit:
            current_golem: Golem = will_visit.popleft()
            # print(current_golem.id, current_golem.location.row, current_golem.location.col)
            score = max(score, current_golem.location.row + 1)
            visited.add(current_golem.id)

            dr, dc = current_golem.exit.to_move_stat()
            exit_row, exit_col = current_golem.location.row + dr, current_golem.location.col + dc

            if exit_row >= 1:
                golem_id = self.map[exit_row - 1][exit_col]
                if golem_id != -1 and golem_id not in visited:
                    will_visit.append(self.golems[golem_id])

            if exit_row <= len(self.map) - 2:
                golem_id = self.map[exit_row + 1][exit_col]
                if golem_id != -1 and golem_id not in visited:
                    will_visit.append(self.golems[golem_id])

            if exit_col >= 1:
                golem_id = self.map[exit_row][exit_col - 1]
                if golem_id != -1 and golem_id not in visited:
                    will_visit.append(self.golems[golem_id])

            if exit_col <= len(self.map[0]) - 2:
                golem_id = self.map[exit_row][exit_col + 1]
                if golem_id != -1 and golem_id not in visited:
                    will_visit.append(self.golems[golem_id])

        return score

    def print(self):
        for row in self.map:
            print(row)


##############################################

R, C, K = map(int, input().split())

forest = Forest(R, C)

for i in range(K):
    col, dir_num = map(int, input().split())
    # print(i, col)
    forest.golem_start(Golem(i, col - 1, Direction.from_num(dir_num)))
    # if i == 49:
    #     forest.print()
    # print('i: ', i)

print(forest.score)

# 5 70 50
# 12 2
# 69 3
# 18 3
# 14 1
# 35 3
# 28 1
# 68 3
# 62 3
# 32 3
# 19 2
# 6 3
# 4 2
# 4 1
# 7 0
# 46 3
# 65 3
# 62 2
# 10 0
# 17 1
# 36 1
# 62 1
# 17 0
# 24 0
# 66 0
# 43 2
# 49 2
# 2 0
# 5 0
# 14 1
# 7 0
# 31 2
# 15 0
# 58 0
# 38 2
# 47 1
# 6 3
# 68 1
# 46 2
# 69 0
# 44 1
# 63 1
# 25 0
# 22 3
# 15 1
# 35 3
# 24 1
# 66 2
# 7 1
# 19 1
# 24 2


# [-1, -1, -1, -1, -1, 35, -1, -1, -1, -1, -1, -1, -1, -1, 43, -1, -1, -1, -1, -1, -1, -1, -1, 45, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1]
# [-1, -1, -1, -1, 35, 35, 35, -1, -1, -1, -1, -1, -1, 43, 43, 43, -1, -1, 48, -1, -1, -1, 45, 45, 45, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 46, -1, 38, 38, 38]
# [-1, -1, -1, -1, 27, 35, -1, 29, -1, -1, 47, -1, -1, 28, 43, -1, 31, 48, 48, 48, -1, 42, -1, 45, 41, -1, -1, 49, -1, -1, 30, -1, -1, -1, 44, -1, -1, 33, -1, -1, 39, -1, -1, 37, -1, -1, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 32, -1, -1, -1, -1, 40, -1, 46, 46, 46, 36, 38, -1]
# [-1, -1, -1, 27, 27, 27, 29, 29, 29, 47, 47, 47, 28, 28, 28, 31, 31, 31, 48, -1, 42, 42, 42, 41, 41, 41, 49, 49, 49, 30, 30, 30, -1, 44, 44, 44, 33, 33, 33, 39, 39, 39, 37, 37, 37, 34, 34, 34, -1, -1, -1, -1, -1, -1, -1, -1, 32, 32, 32, -1, -1, 40, 40, 40, -1, 46, 36, 36, 36, -1]
# [-1, -1, -1, -1, 27, -1, -1, 29, -1, -1, 47, -1, -1, 28, -1, -1, 31, -1, -1, -1, -1, 42, -1, -1, 41, -1, -1, 49, -1, -1, 30, -1, -1, -1, 44, -1, -1, 33, -1, -1, 39, -1, -1, 37, -1, -1, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 32, -1, -1, -1, -1, 40, -1, -1, -1, -1, 36, -1, -1]