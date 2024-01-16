from typing import List


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        left = 0
        right = 0
        n = len(nums)
        while right < n:
            if nums[right] != 0:
                if right != left:
                    nums[left], nums[right] = nums[right], nums[left]
                    pass
                left += 1
                pass
            right += 1
            pass
        pass

    pass


solution = Solution()
nums = [0]
solution.moveZeroes(nums)
print(nums)
