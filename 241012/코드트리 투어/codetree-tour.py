import heapq
import math
from heapq import heapify
from typing import Optional

Q = 0
n, m = 0, 0


class Tour:
    def __init__(self, id: int, revenue: int, dest: int):
        self.id = id
        self.revenue = revenue
        self.dest = dest

    def __lt__(self, other):
        return self.id < other.id

    def __repr__(self):
        return f"id: {self.id}, revenue: {self.revenue}, dest: {self.dest}"

    def __str__(self):
        return f"id: {self.id}, revenue: {self.revenue}, dest: {self.dest}"


class CodeTreeLand:

    def __init__(self, number_of_city: int):
        self.edge_map: list[list[int | float]] = []

        for _ in range(number_of_city):
            self.edge_map.append(list([math.inf] * number_of_city))
        for i in range(number_of_city):
            self.edge_map[i][i] = 0

        # 투어 시작지점의 초기값은 0
        self.start_location = 0
        self.cost_from_start_location = [math.inf] * n

        self.tour_list: list[Optional[Tour]] = [None] * 30001
        self.tour_heap: list[tuple[int, Tour]] = []

    def add_edge(self, v: int, u: int, w: int):
        if self.edge_map[v][u] > w:
            self.edge_map[v][u] = w
            self.edge_map[u][v] = w

    def add_tour(self, tour_id, revenue, dest):
        tour = Tour(tour_id, revenue, dest)

        if self.cost_from_start_location[dest] != math.inf:
            profit = int(revenue - self.cost_from_start_location[dest])
            if profit >= 0:
                heapq.heappush(self.tour_heap, (-profit, tour))

        self.tour_list[tour_id] = tour

    def delete_tour(self, id):
        # print('(( start')
        # print(self.tour_heap)
        self.tour_heap = list(filter(lambda x: x[1].id != id, self.tour_heap))
        self.tour_list[id] = None
        # print(self.tour_heap)
        heapify(self.tour_heap)
        # print(self.tour_heap)
        # print('(( end')

    def init_cost_from_start_location(self):
        self.cost_from_start_location = [math.inf] * n
        self.cost_from_start_location[self.start_location] = 0

        visited = [False] * n

        for _ in range(n):
            tmp_location = -1
            minimum = math.inf
            for i in range(n):
                if visited[i] == False and self.edge_map[self.start_location][i] < minimum:
                    tmp_location = i
                    minimum = self.edge_map[self.start_location][i]

            if tmp_location == -1:
                break

            visited[tmp_location] = True

            for i in range(n):
                if (self.edge_map[tmp_location][i] > 0
                        and self.cost_from_start_location[i] > self.cost_from_start_location[tmp_location] +
                        self.edge_map[tmp_location][i]):
                    self.cost_from_start_location[i] = self.cost_from_start_location[tmp_location] + \
                                                       self.edge_map[tmp_location][i]

    def change_start_location(self, start_location: int):
        self.start_location = start_location
        self.init_cost_from_start_location()

        self.tour_heap = []
        for tour in self.tour_list:
            if tour is None:
                continue
            cost = self.cost_from_start_location[tour.dest]

            if cost != math.inf:
                heapq.heappush(self.tour_heap, (-(tour.revenue - cost), tour))

    def sell(self) -> int:
        # print('sell: ', self.tour_heap)
        if self.tour_heap:
            profit, tour = heapq.heappop(self.tour_heap)
            self.tour_list[tour.id] = None

            return tour.id

        return -1

    def print_edge(self):
        for row in self.edge_map:
            print(row)


###

Q = int(input())

code_tree_land = None

for _ in range(Q):
    query = list(map(int, input().split()))

    if query[0] == 100:
        n = query[1]
        m = query[2]

        code_tree_land = CodeTreeLand(n)

        for i in range(1, len(query) // 3):
            code_tree_land.add_edge(*query[3 * i: 3 * (i + 1)])

        code_tree_land.init_cost_from_start_location()

    if query[0] == 200:
        code_tree_land.add_tour(query[1], query[2], query[3])
    if query[0] == 300:
        code_tree_land.delete_tour(query[1])
    if query[0] == 400:
        print(code_tree_land.sell())
    if query[0] == 500:
        code_tree_land.change_start_location(query[1])