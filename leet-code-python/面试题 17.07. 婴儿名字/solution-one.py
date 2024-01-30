from typing import List


class UnionFind:
    def __init__(self):
        self.root = {}
        self.weight = {}

    def add(self, node, w):
        if node not in self.root:
            self.root[node] = node
            self.weight[node] = w

    def find(self, node):
        father = self.root[node]
        if node != father and father != self.root[father]:
            self.root[node] = self.find(father)
            self.weight[father] -= self.weight[node]
        return self.root[node]

    def union(self, node1, node2):
        self.add(node1, 0)
        self.add(node2, 0)
        f1 = self.find(node1)
        f2 = self.find(node2)
        if f1 == f2:
            return False
        if f1 <= f2:
            self.root[f2] = f1
            self.weight[f1] += self.weight[f2]
        else:
            self.root[f1] = f2
            self.weight[f2] += self.weight[f1]
        return True


class Solution:
    def trulyMostPopular(self, names: List[str], synonyms: List[str]) -> List[str]:
        uf = UnionFind()
        for name in names:
            left = name.find("(")
            uf.add(name[: left], int(name[left + 1: -1]))
        for synonym in synonyms:
            split_index = synonym.find(",")
            uf.union(synonym[1:split_index], synonym[split_index + 1:-1])
        test = set()
        res = []
        for data in uf.root:
            f = uf.find(data)
            if f not in test:
                test.add(f)
                res.append(f + "(" + str(uf.weight[f]) + ")")
        return res
