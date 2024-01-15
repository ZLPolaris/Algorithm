from typing import List


class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        n = len(graph)
        flag = [0] * n

        def dfs(u: int) -> bool:
            print(u)
            for v in graph[u]:
                if flag[v] == 0:
                    flag[v] = 1 if flag[u] == 2 else 2
                    if not dfs(v):
                        return False
                    pass
                elif flag[v] == flag[u]:
                    print(v, u)
                    return False
                pass
            return True
            pass

        for i in range(n):
            if flag[i] == 0:
                flag[i] = 1
                print(flag)
                if not dfs(i):
                    return False
            pass
        return True
