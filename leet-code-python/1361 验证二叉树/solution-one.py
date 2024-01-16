from typing import List


class UnionFind:
    def __init__(self, n):
        self.count = n
        self.root = {}
        self.size = {}
        for i in range(n):
            self.root[i] = i
            self.size[i] = 1

    def find(self, node):
        father = self.root[node]
        if father != node and self.root[father] != father:
            self.size[father] -= 1
            self.root[node] = self.find(father)
        return self.root[node]

    def union(self, node1, node2):
        father1 = self.root[node1]
        father2 = self.root[node2]
        if father1 == father2:
            return
        s1 = self.size[node1]
        s2 = self.size[node2]
        self.count -= 1
        if s1 >= s2:
            self.root[father2] = father1
            self.size[father1] = s1 + s2
        else:
            self.root[father1] = father2
            self.size[father2] = s1 + s2


class Solution:
    def validateBinaryTreeNodes(self, n: int, leftChild: List[int], rightChild: List[int]) -> bool:
        # 不使用并查集的话，不验证连通性是错误的

        in_degree = [0] * n
        zero_dot = n
        uf = UnionFind(n)
        for index in range(n):
            if leftChild[index] != -1:
                in_degree[leftChild[index]] += 1
                if in_degree[leftChild[index]] > 1:
                    return False
                zero_dot -= 1
                uf.union(index, leftChild[index])
            if rightChild[index] != -1:
                in_degree[rightChild[index]] += 1
                if in_degree[rightChild[index]] > 1:
                    return False
                zero_dot -= 1
                uf.union(index, rightChild[index])
        return uf.count == 1 and zero_dot == 1
