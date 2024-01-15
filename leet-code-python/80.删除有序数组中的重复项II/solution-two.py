from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n = len(nums)
        i = 2
        j = 2
        while j < n:
            if nums[j] > nums[i - 2]:
                if j != i:
                    nums[j], nums[i] = nums[i], nums[j]
                    pass
                i += 1
                pass
            j += 1
            pass
        return i
