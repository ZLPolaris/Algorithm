import collections
from typing import List


# 使用bfs
class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        colors = [0] * n

        def bfs(source):
            queue = collections.deque()
            queue.append(source)
            colors[source] = 1
            while queue:
                v = queue.popleft()
                for i in range(n):
                    if colors[i] == 0 and isConnected[v][i]:
                        colors[i] = 1
                        queue.append(i)

        res = 0
        for i in range(n):
            if colors[i] == 0:
                bfs(i)
                res += 1
        return res
