from typing import List


class UnionFind:
    parent = {}
    weight = {}
    size = {}

    def __init__(self, datas):
        for data in datas:
            self.parent[data] = data
            self.size[data] = 1
            self.weight[data] = 1

    def find(self, node):
        if node not in self.parent:
            return None
        father = self.parent[node]
        if node != father:
            if father != self.parent[father]:
                self.size[father] -= 1
                self.weight[node] = self.weight[father] * self.weight[node]
                self.parent[node] = self.find(father)
        return self.parent[node]

    def getWeight(self, node1, node2):
        f1 = self.find(node1)
        f2 = self.find(node2)
        if f1 is None or f2 is None or f1 != f2:
            return -1.0
        else:
            return self.weight[node1] / self.weight[node2]

    def union(self, node1, node2, w):
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
            self.weight[f2] = self.weight[node1] / (self.weight[node2] * w)
        else:
            self.parent[f1] = f2
            self.size[f2] = s1 + s2
            self.weight[f1] = self.weight[node2] * w / self.weight[node1]

    # 添加功能
    def add(self, data):
        if data not in self.parent:
            self.parent[data] = data
            self.weight[data] = 1
            self.size[data] = 1

    def clear(self):
        self.parent.clear()
        self.size.clear()
        self.weight.clear()


class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        uf = UnionFind([])
        n = len(equations)
        for i in range(n):
            uf.add(equations[i][0])
            uf.add(equations[i][1])
            uf.union(equations[i][0], equations[i][1], values[i])
        res = []
        for query in queries:
            res.append(uf.getWeight(query[0], query[1]))
        uf.clear()
        return res
