from typing import List


class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        p0 = 0
        p1 = 0
        i = 0
        while i < n:
            if nums[i] == 1:
                if i != p1:
                    nums[i], nums[p1] = nums[p1], nums[i]
                    pass
                p1 += 1
            elif nums[i] == 0:
                nums[p0], nums[i] = nums[i], nums[p0]
                if p0 < p1:
                    nums[p1], nums[i] = nums[i], nums[p1]
                    pass
                p0 += 1
                p1 += 1
            i += 1
            pass
        pass

