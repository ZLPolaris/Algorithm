import collections
from typing import List


class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        adjList = collections.defaultdict(list)
        for edge in edges:
            adjList[edge[0]].append(edge[1])
            adjList[edge[1]].append(edge[0])
            pass
        return self.getLongestPath(n, adjList)

        pass

    # 获取无向图的一条最长通路（长度偶数，点为奇数可能有多条）
    def getLongestPath(self, n: int, adjList: collections.defaultdict) -> List[int]:
        parents = [-1] * n

        def bfs(start: int) -> int:
            q = collections.deque()
            q.append(start)
            visited = [False] * n
            visited[start] = True # 互相邻居必须使用visited
            ele = start
            while q:
                ele = q.popleft()
                for neighbor in adjList[ele]:
                    if not visited[neighbor]:
                        visited[neighbor] = True
                        q.append(neighbor)
                        parents[neighbor] = ele
                    pass
                pass
            return ele

        x = bfs(0)
        y = bfs(x)
        parents[x] = -1
        path = []
        while y != -1:
            path.append(y)
            y = parents[y]
            pass
        m = len(path)
        print(path)
        if m % 2 == 0:
            return [path[m // 2], path[m // 2 - 1]]
        else:
            return [path[m // 2]]
