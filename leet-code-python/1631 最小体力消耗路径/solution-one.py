from typing import List


class UnionFind:

    def __init__(self, datas=None):
        if datas is None:
            datas = []
        self.parent = {}
        self.size = {}
        for data in datas:
            self.parent[data] = data
            self.size[data] = 1

    def find(self, node):
        if node not in self.parent:
            return None
        father = self.parent[node]
        if node != father and father != self.parent[father]:
            self.size[father] -= 1
            self.parent[node] = self.find(father)
        return self.parent[node]

    def union(self, node1, node2):
        if node1 not in self.parent or node2 not in self.parent:
            return
        f1 = self.find(node1)
        f2 = self.find(node2)
        if f1 == f2:
            return
        s1 = self.size[f1]
        s2 = self.size[f2]
        if s1 >= s2:
            self.parent[f2] = f1
            self.size[f1] = s1 + s2
        else:
            self.parent[f1] = f2
            self.size[f2] = s1 + s2

    def isInOneSet(self, node1, node2):
        return self.find(node1) == self.find(node2)


# 采用 kruskal
class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        m = len(heights)
        n = len(heights[0])
        data_list = list()
        for i in range(1, n):
            data_list.append((i, i - 1, abs(heights[0][i] - heights[0][i - 1])))
        for i in range(1, m):
            data_list.append((i * n, i * n - n, abs(heights[i][0] - heights[i - 1][0])))

        for i in range(1, m):
            for j in range(1, n):
                data_list.append((i * n + j, i * n + j - 1, abs(heights[i][j] - heights[i][j - 1])))
                data_list.append((i * n + j, (i - 1) * n + j, abs(heights[i][j] - heights[i - 1][j])))

        data_list.sort(key=lambda x: x[2])
        u_list = [i for i in range(m * n)]
        uf = UnionFind(u_list)
        target = m * n - 1
        print(data_list)
        for edge in data_list:
            uf.union(edge[0], edge[1])
            if uf.isInOneSet(0, target):
                print(edge[0], edge[1])
                return edge[2]
        return 0
