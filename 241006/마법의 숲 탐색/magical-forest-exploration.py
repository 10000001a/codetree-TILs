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


class ForestCellType(Enum):
    EMPTY = -1
    NORMAL = 0
    CENTER = 1
    EXIT = 2


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
        self.score = self.score + self.get_score(golem) + 1

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

        if center.row >= -1:
            self.map[center.row + 1][center.col] = golem.id

        if center.row >= 0:
            self.map[center.row][center.col - 1] = golem.id
            self.map[center.row][center.col] = golem.id
            self.map[center.row][center.col + 1] = golem.id

        if center.row >= 1:
            self.map[center.row - 1][center.col] = golem.id

    def clear_golem(self):
        self.golems = {}
        for j in range(len(self.map)):
            self.map[j] = list([-1] * len(self.map[0]))

    def get_score(self, golem: Golem) -> int:
        score = 0
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
    forest.golem_start(Golem(i, col - 1, Direction.from_num(dir_num)))
    # forest.print()

print(forest.score)