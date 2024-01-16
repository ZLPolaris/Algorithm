from typing import List


class Solution:
    def duplicateZeros(self, arr: List[int]) -> None:
        """
        Do not return anything, modify arr in-place instead.
        """
        count = 0
        n = len(arr)
        for item in arr:
            if item == 0:
                count += 1
                pass
            pass
        i = n - 1
        while i >= 0:
            if arr[i] == 0:
                if i + count < n:
                    arr[i + count] = 0
                    pass
                count -= 1
                pass
            if i + count < n:
                arr[i + count] = arr[i]
                pass
            i -= 1
            pass
        print(arr)
        pass
