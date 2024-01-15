class UnionFind:
    def __init__(self):
        self.root = {}

    def find(self, node):
        if node in self.root:
            father = self.root[node]
            if node != father and father != self.root[father]:
                self.root[node] = self.find(father)
            return self.root[node]
        else:
            return node

    def union(self, node1, node2):
        father1 = self.find(node1)
        father2 = self.find(node2)
        if father1 == father2:
            return
        if father1 > father2:
            self.root[father1] = father2
        else:
            self.root[father2] = father1

    def add(self, node):
        if node not in self.root:
            self.root[node] = node


class Solution:
    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:
        uf = UnionFind()
        for one, two in zip(s1, s2):
            uf.add(one)
            uf.add(two)
            uf.union(one, two)
        ans = ""
        print(uf.root)
        for s in baseStr:
            ans += uf.find(s)
        return ans
