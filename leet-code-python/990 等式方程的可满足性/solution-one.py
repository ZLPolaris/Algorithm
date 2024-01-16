from typing import List


class UnionFind:
    parent = {}
    size = {}

    def __init__(self, datas=None):
        if datas is None:
            datas = []
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
        s1 = self.size[node1]
        s2 = self.size[node2]
        if s1 >= s2:
            self.parent[f2] = f1
            self.size[f1] = s1 + s2
        else:
            self.parent[f1] = f2
            self.size[f2] = s1 + s2

    def add(self, node):
        if node not in self.parent:
            self.parent[node] = node
            self.size[node] = 1

    def isInOneSet(self, node1, node2):
        if node1 == node2:
            return True
        if node1 not in self.parent or node2 not in self.parent:
            return False
        return self.find(node1) == self.find(node2)

    def clear(self):
        self.parent.clear()
        self.size.clear()


class Solution:
    def equationsPossible(self, equations: List[str]) -> bool:
        uf = UnionFind()
        uf.clear()
        for equation in equations:
            if equation[1:-1] == "==":
                uf.add(equation[0])
                uf.add(equation[-1])
                uf.union(equation[0], equation[-1])
        for equation in equations:
            if equation[1:-1] == "!=":
                if uf.isInOneSet(equation[0], equation[-1]):
                    print(equation[0], equation[-1])
                    return False
        return True
        pass
