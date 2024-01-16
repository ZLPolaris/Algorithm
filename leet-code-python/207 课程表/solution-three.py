import collections
from typing import List


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adjList = collections.defaultdict(list)
        for edge in prerequisites:
            adjList[edge[0]].append(edge[1])
            pass

        visited = [0 for _ in range(numCourses)]
        print(adjList)

        def dfs(start: int) -> bool:
            s = [start]
            visited[start] = 1
            while s:
                ele = s[len(s) - 1]
                for v in adjList[ele]:
                    if visited[v] == 0:
                        s.append(v)
                        visited[v] = 1
                        break
                        pass
                    elif visited[v] == 1:
                        return False
                    pass
                if s[len(s) - 1] == ele:
                    visited[ele] = 2
                    s.pop()
                    pass
                pass
            return True

        for i in range(numCourses):
            if visited[i] == 0:
                if not dfs(i):
                    return False
                pass
            pass
        return True
        pass
