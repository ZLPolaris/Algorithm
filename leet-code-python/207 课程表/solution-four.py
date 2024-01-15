import collections
from typing import List


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adjList = collections.defaultdict(list)
        in_degree = [0 for _ in range(numCourses)]
        for edge in prerequisites:
            adjList[edge[1]].append(edge[0])
            in_degree[edge[0]] += 1
            pass
        q = collections.deque(u for u in range(numCourses) if in_degree[u] == 0)
        visited = 0
        while q:
            ele = q.popleft()
            visited += 1
            for edge_point in adjList[ele]:
                in_degree[edge_point] -= 1
                if in_degree[edge_point] == 0:
                    q.append(edge_point)
                    pass
                pass
            pass
        return visited == numCourses
