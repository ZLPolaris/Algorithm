import collections
from typing import List


class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        adjList = collections.defaultdict(list)
        for flight in flights:
            adjList[flight[0]].append((flight[1], flight[2]))

