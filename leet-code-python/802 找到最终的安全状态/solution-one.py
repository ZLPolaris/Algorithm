import collections
from typing import List


class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        reverseAdjList = collections.defaultdict(list)
        n = len(graph)
        out_degree = [0] * n
        for i in range(n):
            out_degree[i] += len(graph[i])
            for j in graph[i]:
                reverseAdjList[j].append(i)
                pass
            pass
        q = [i for i in range(n) if out_degree[i] == 0]
        res = []
        while q:
            cur = q.pop(0)
            res.append(cur)
            for i in reverseAdjList[cur]:
                out_degree[i] -= 1
                if out_degree[i] == 0:
                    q.append(i)
                    pass
                pass
        res.sort()
        return res
        pass
