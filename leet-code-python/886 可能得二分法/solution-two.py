import collections
from typing import List


class Solution:
    def possibleBipartition(self, n: int, dislikes: List[List[int]]) -> bool:
        adj_list = collections.defaultdict(list)
        for dislike in dislikes:
            adj_list[dislike[0]].append(dislike[1])
            adj_list[dislike[1]].append(dislike[0])
            pass
        visited = [0] * (n + 1)

        def dfs(u: int) -> bool:
            print(u)
            for v in adj_list[u]:
                if visited[v] == 0:
                    visited[v] = 1 if visited[u] == 2 else 2
                    if not dfs(v):
                        return False
                    pass
                elif visited[u] == visited[v]:
                    return False
                pass
            return True

        for i in range(1, n + 1):
            if visited[i] == 0:
                visited[i] = 1
                if not dfs(i):
                    return False
            pass
        return True
