import collections
from typing import List

# 思路不正确 会超时

class Solution:
    def loudAndRich(self, richer: List[List[int]], quiet: List[int]) -> List[int]:
        n = len(quiet)
        pre_u = collections.defaultdict(list)
        in_degree = [0] * n
        adjList = collections.defaultdict(list)
        for rich in richer:
            in_degree[rich[1]] += 1
            adjList[rich[0]].append(rich[1])
            pass
        q = [i for i in range(n) if in_degree[i] == 0]
        while q:
            cur = q.pop(0)
            for v in adjList[cur]:
                pre_u[v].append(cur)
                pre_u[v].extend(pre_u[cur])
                in_degree[v] -= 1
                if in_degree[v] == 0:
                    q.append(v)
                    pass
                pass
            pass
        print(pre_u)
        answer = [i for i in range(n)]
        for i in range(n):
            for j in pre_u[i]:
                if quiet[j] < quiet[answer[i]]:
                    answer[i] = j
                    pass
                pass
            pass
        print(answer)
        return answer
