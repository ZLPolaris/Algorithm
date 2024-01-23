from typing import List


class UnionFind:
    def __init__(self):
        self.root = {}
        self.weight = {}
        pass

    def add(self, node):
        if node not in self.root:
            self.root[node] = node
            self.weight[node] = 1
        pass

    def find(self, node):
        father = self.root[node]
        if node != father and father != self.root[father]:
            self.root[node] = self.find(father)
            self.weight[node] = self.weight[node] * self.weight[father]
        return self.root[node]

    def union(self, node1, node2, w):
        self.add(node1)
        self.add(node2)
        f1 = self.find(node1)
        f2 = self.find(node2)
        if f1 == f2:
            return
        self.root[f2] = f1
        self.weight[f2] = self.weight[node1] * w / self.weight[node2]

    def calculate(self, node1, node2):
        if node1 not in self.root or node2 not in self.root:
            return float(-1)

        f1 = self.find(node1)
        f2 = self.find(node2)
        if f1 != f2:
            return float(-1)
        return self.weight[node2] / self.weight[node1]
        pass


class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        uf = UnionFind()
        for k, v in enumerate(equations):
            uf.union(v[0], v[1], values[k])
        res = []
        for query in queries:
            res.append(uf.calculate(query[0], query[1]))
        return res
