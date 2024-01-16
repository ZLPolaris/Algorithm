from typing import List


class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        left = 0
        right = n - 1
        i = 0
        while i <= right:
            if nums[i] == 0:
                if i != left:
                    nums[left], nums[i] = nums[i], nums[left]
                    pass
                else:
                    i += 1
                left += 1
                pass
            elif nums[i] == 2:
                nums[right], nums[i] = nums[i], nums[right]
                right -= 1
                pass
            else:
                i += 1
                pass
            print(i, left, right)
            print(nums)
            pass
        pass

    pass


nums = [2, 0, 2, 1, 1, 0]
s = Solution()
s.sortColors(nums)
print(nums)
