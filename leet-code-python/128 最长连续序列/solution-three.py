from typing import List


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        ans = 0
        nums_dict = dict()
        for num in nums:
            if num not in nums_dict:
                left = nums_dict.get(num - 1, 0)
                right = nums_dict.get(num + 1, 0)
                cur = right + left + 1
                nums_dict[num] = cur
                nums_dict[num - left] = cur
                nums_dict[num + right] = cur
                if ans < cur:
                    ans = cur
        return ans
