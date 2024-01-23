from typing import List


class UnionFind:
    def __init__(self):
        self.root = {}

    def add(self, node):
        if node not in self.root:
            self.root[node] = node

    def find(self, node):
        father = self.root[node]
        while father != self.root[father]:
            father = self.root[father]
        return father

    def union(self, node1, node2):
        self.add(node1)
        self.add(node2)
        f1 = self.find(node1)
        f2 = self.find(node2)
        if f2 != node2:
            return 1
        if f1 == f2:
            return 2

        self.root[node2] = node1
        return 0


class Solution:
    def findRedundantDirectedConnection(self, edges: List[List[int]]) -> List[int]:
        uf = UnionFind()
        possible_problem_edge = []
        for edge in edges:
            result = uf.union(edge[0], edge[1])
            if result == 1:
                possible_problem_edge.append((1, edge))
            elif result == 2:
                possible_problem_edge.append((2, edge))
        if len(possible_problem_edge) == 1:
            return possible_problem_edge[0][1]
        else:
            if possible_problem_edge[0][0] == 1:
                return [uf.root[possible_problem_edge[0][1][1]], possible_problem_edge[0][1][1]]
            else:
                return [uf.root[possible_problem_edge[1][1][1]], possible_problem_edge[1][1][1]]
