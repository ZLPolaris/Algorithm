import collections
from typing import List


class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        outAdjList = collections.defaultdict(list)
        inDegree = [0 for _ in range(numCourses)]
        for edge in prerequisites:
            outAdjList[edge[1]].append(edge[0])
            inDegree[edge[0]] += 1
            pass
        q = collections.deque(u for u in range(numCourses) if inDegree[u] == 0)
        result = []
        while q:
            ele = q.popleft()
            result.append(ele)
            for edge_point in outAdjList[ele]:
                inDegree[edge_point] -= 1
                if inDegree[edge_point] == 0:
                    q.append(edge_point)
                    pass
                pass
            pass
        return result if len(result) == numCourses else []
