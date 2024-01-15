import collections
from typing import List


class Solution:
    def loudAndRich(self, richer: List[List[int]], quiet: List[int]) -> List[int]:
        n = len(quiet)
        adj_list = collections.defaultdict(list)
        in_degree = [0] * n
        for rich in richer:
            in_degree[rich[1]] += 1
            adj_list[rich[0]].append(rich[1])
            pass
        answer = [i for i in range(n)]
        q = [i for i in range(n) if in_degree[i] == 0]
        while q:
            cur = q.pop(0)

            for v in adj_list[cur]:
                if quiet[answer[cur]] < quiet[answer[v]]:
                    answer[v] = answer[cur]
                    pass
                in_degree[v] -= 1
                if in_degree[v] == 0:
                    q.append(v)
                    pass
                pass
            pass
        return answer
        pass
