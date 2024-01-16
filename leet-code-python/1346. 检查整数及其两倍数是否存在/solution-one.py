from typing import List


class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        if arr.count(0) >= 2:
            return True
        maps = set(arr)
        for item in arr:
            if item == 0:
                continue
            if item * 2 in maps:
                return True
            pass
        return False
