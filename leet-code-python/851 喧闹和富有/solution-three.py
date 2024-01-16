import collections
from typing import List


class Solution:
    def loudAndRich(self, richer: List[List[int]], quiet: List[int]) -> List[int]:
        n = len(quiet)
        answer = [-1] * n
        adj_list = collections.defaultdict(list)
        for rich in richer:
            adj_list[rich[1]].append(rich[0])
            pass

        def dfs(u: int):
            if answer[u] != -1:
                return
            answer[u] = u
            for v in adj_list[u]:
                dfs(v)
                if quiet[answer[u]] > quiet[answer[v]]:
                    answer[u] = answer[v]
                    pass
                pass
            pass

        for i in range(n):
            dfs(i)
        return answer
        pass
