from typing import Optional


class Node:
    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
        pass


class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if node is None:
            return None
        graphNode = {1: Node(node.val)}
        s = [node]
        while s:
            ele = s.pop()
            for neighbor in ele.neighbors:
                if neighbor.val not in graphNode.keys():
                    graphNode[neighbor.val] = Node(neighbor.val)
                    s.append(neighbor)
                    pass
                graphNode[ele.val].neighbors.append(graphNode[neighbor.val])
                pass
            pass
        return graphNode[1]
        pass
