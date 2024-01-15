from typing import List


# 使用并查集

class UnionFindSet(object):
    """并查集"""

    def __init__(self, data_list):
        """初始化两个字典，一个保存节点的父节点，另外一个保存父节点的大小
        初始化的时候，将节点的父节点设为自身，size设为1"""
        self.father_dict = {}
        self.size_dict = {}
        for node in data_list:
            self.father_dict[node] = node
            self.size_dict[node] = 1

    def find(self, node):
        """使用递归的方式来查找父节点

        在查找父节点的时候，顺便把当前节点移动到父节点上面
        这个操作算是一个优化
        """
        if node not in self.father_dict:
            return None
        father = self.father_dict[node]
        if node != father:
            if father != self.father_dict[father]:  # 在降低树高优化时，确保父节点大小字典正确
                self.size_dict[father] -= 1
            father = self.find(father)
        self.father_dict[node] = father
        return father

    def is_same_set(self, node_a, node_b):
        """查看两个节点是不是在一个集合里面"""
        return self.find(node_a) == self.find(node_b)

    def union(self, node_a, node_b):
        """将两个集合合并在一起"""
        if node_a is None or node_b is None:
            return

        a_head = self.find(node_a)
        b_head = self.find(node_b)

        if a_head != b_head:
            a_set_size = self.size_dict[a_head]
            b_set_size = self.size_dict[b_head]
            if a_set_size >= b_set_size:
                self.father_dict[b_head] = a_head
                self.size_dict[a_head] = a_set_size + b_set_size
            else:
                self.father_dict[a_head] = b_head
                self.size_dict[b_head] = a_set_size + b_set_size

    def getMaxSize(self):
        max_size = 0
        for key, value in self.size_dict.items():
            if value > max_size:
                max_size = value
        return max_size


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        uf = UnionFindSet(nums)
        for num in nums:
            while uf.find(num + 1) is not None:
                uf.union(num, num + 1)
                num += 1
        return uf.getMaxSize()
