from typing import List


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        visited = [0 for _ in range(numCourses)]
        valid = True
        adjList = self.buildAdjList(numCourses, prerequisites)
        print(adjList)

        def dfs(u: int):
            nonlocal valid
            visited[u] = 1
            print(visited)
            for v in adjList[u]:
                if visited[v] == 0:
                    dfs(v)
                    pass
                elif visited[v] == 1:
                    valid = False
                    return
                pass
            visited[u] = 2
            pass

        for i in range(numCourses):
            if not valid:
                return False
            if visited[i] == 0:
                dfs(i)
                pass
            pass
        return valid

    def buildAdjList(self, numCourses: int, prerequisites: List[List[int]]) -> List[List[int]]:
        adjList = [[] for _ in range(numCourses)]
        for item in prerequisites:
            adjList[item[0]].append(item[1])
            pass
        return adjList
