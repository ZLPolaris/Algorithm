import collections
from typing import List


# 复习使用dfs解决拓扑排序问题
class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        adj_list = collections.defaultdict(list)
        for data in prerequisites:
            adj_list[data[1]].append(data[0])

        visited = [0] * numCourses
        ans = []

        def dfs(u):
            visited[u] = 1
            for v in adj_list[u]:
                if visited[v] == 0:
                    if not dfs(v):
                        return False
                elif visited[v] == 1:
                    return False
            visited[u] = 2
            ans.append(u)
            return True

        for i in range(numCourses):
            if visited[i] == 0:
                if not dfs(i):
                    return []
        ans.reverse()
        return ans
