import collections
from typing import List


class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        adj_list = collections.defaultdict(list)
        for data in prerequisites:
            adj_list[data[1]].append(data[0])
        colors = [0] * numCourses
        ans = []

        def dfs(source):
            colors[source] = 1
            stack = [source]
            while stack:
                # 先不弹出
                u = stack[-1]
                flag = True
                for v in adj_list[u]:
                    if colors[v] == 0:
                        colors[v] = 1
                        stack.append(v)
                        flag = False
                        break
                    elif colors[v] == 1:
                        print(u, v)
                        return False
                if flag:
                    colors[u] = 2
                    stack.pop()
                    ans.append(u)
            return True

        for i in range(numCourses):
            if colors[i] == 0:
                if not dfs(i):
                    return []
                print(ans)
        ans.reverse()
        return ans
