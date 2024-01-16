import collections
from typing import List


class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        adjList = collections.defaultdict(list)
        for item in prerequisites:
            adjList[item[1]].append(item[0])
            pass
        visited = [0 for _ in range(numCourses)]
        result = []
        print(adjList)

        def dfs(u: int) -> bool:
            visited[u] = 1
            for v in adjList[u]:
                if visited[v] == 0:
                    if not dfs(v):
                        return False
                    pass
                elif visited[v] == 1:
                    return False
                pass
            visited[u] = 2
            result.insert(0, u)
            return True
            pass

        for i in range(numCourses):
            if visited[i] == 0:
                b = dfs(i)
                if not b:
                    return []
        return result
