from typing import List


class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        n = len(nums)
        nums.sort()
        res = []
        for first in range(n - 3):
            if first > 0 and nums[first] == nums[first - 1]:
                continue
                pass
            for second in range(first + 1, n - 2):
                if second > first + 1 and nums[second] == nums[second - 1]:
                    continue
                    pass
                third = second + 1
                fourth = n - 1
                while third < fourth:
                    singleSum = nums[third] + nums[fourth] + nums[first] + nums[second]
                    if singleSum > target:
                        fourth -= 1
                        while third < fourth and nums[fourth] == nums[fourth + 1]:
                            fourth -= 1
                            pass
                        pass
                    elif singleSum < target:
                        third += 1
                        while third < fourth and nums[third] == nums[third - 1]:
                            third += 1
                            pass
                        pass
                    else:
                        res.append([nums[first], nums[second], nums[third], nums[fourth]])
                        fourth -= 1
                        while third < fourth and nums[fourth] == nums[fourth + 1]:
                            fourth -= 1
                            pass
                        pass
                        third += 1
                        while third < fourth and nums[third] == nums[third - 1]:
                            third += 1
                            pass
                        pass
                    pass
                pass
            pass
        return res
