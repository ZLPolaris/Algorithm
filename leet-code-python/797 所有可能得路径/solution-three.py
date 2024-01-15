import collections
from typing import List


class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        res = []
        path = [0]
        q = collections.deque()
        q.append(path)
        m = len(graph)
        while q:
            n = len(q)
            for i in range(n):
                cur = q.popleft()
                print(cur)
                for v in graph[cur[len(cur) - 1]]:
                    tmp = cur.copy()
                    tmp.append(v)
                    if v == m - 1:
                        res.append(tmp)
                        pass
                    else:
                        q.append(tmp)
                        pass
                    pass
                pass
            pass
        return res
