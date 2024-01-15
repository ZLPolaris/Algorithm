from typing import List


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        isSelected = [False for _ in range(numCourses)]
        pointer = self.buildPointer(numCourses, prerequisites)
        for _ in range(numCourses):
            index = self.findDelete(pointer, isSelected)
            if index == -1:
                return False
            isSelected[index] = True
            self.delNode(pointer, isSelected, index)
            pass
        return True
        pass

    def buildPointer(self, numCourses: int, prerequisites: List[List[int]]) -> List[List[int]]:
        pointer = [[] for _ in range(numCourses)]
        for item in prerequisites:
            pointer[item[1]].append(item[0])
            pass
        return pointer

    def findDelete(self, pointer: List[List[int]], isSelected: List[bool]) -> int:
        index = -1
        n = len(pointer)
        for i in range(n):
            if not isSelected[i] and len(pointer[i]) == 0:
                index = i
                return index
            pass
        return index

    def delNode(self, pointer: List[List[int]], isSelected: List[bool], target: int):
        n = len(pointer)
        for i in range(n):
            if not isSelected[i] and target in pointer[i]:
                pointer[i].remove(target)
                pass
            pass
