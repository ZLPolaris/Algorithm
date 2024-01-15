from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        nums.sort()
        res = []
        for first in range(n - 2):
            if first > 0 and nums[first] == nums[first - 1]:
                continue
                pass
            left = first + 1
            right = n - 1
            while left < right:
                if nums[first] + nums[left] + nums[right] > 0:
                    right -= 1
                    while left < right and nums[right] == nums[right + 1]:
                        right -= 1
                        pass
                    pass
                elif nums[first] + nums[left] + nums[right] < 0:
                    left += 1
                    while left < right and nums[left] == nums[left - 1]:
                        left += 1
                    pass
                else:
                    res.append([nums[first], nums[left], nums[right]])
                    right -= 1
                    while left < right and nums[right] == nums[right + 1]:
                        right -= 1
                        pass
                    left += 1
                    while left < right and  nums[left] == nums[left - 1]:
                        left += 1
                    pass
                pass
            pass
        return res

    pass


s = Solution()
nums = [0, 0, 0]
print(s.threeSum(nums))
