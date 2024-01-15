from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n = len(nums)
        i = 1
        j = 1
        count = 1
        while j < n:
            if nums[j] == nums[i - 1] and count != 0:
                if i != j:
                    nums[i], nums[j] = nums[j], nums[i]
                    pass
                i += 1
                count -= 1
                pass
            elif nums[j] > nums[i - 1]:
                if i != j:
                    nums[i], nums[j] = nums[j], nums[i]
                    pass
                i += 1
                count = 1
            j += 1
            pass
        return i
    pass


nums = [0, 0, 1, 1, 1, 1, 2, 3, 3]
s = Solution()
print(s.removeDuplicates(nums))
print(nums)
