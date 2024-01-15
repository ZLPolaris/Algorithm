from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n = len(nums)
        i = 0
        j = 1
        while j < n:
            if nums[j] > nums[i]:
                if j - 1 != i:
                    nums[i + 1] = nums[j]
                i += 1
                pass
            j += 1
            pass
        return i + 1
