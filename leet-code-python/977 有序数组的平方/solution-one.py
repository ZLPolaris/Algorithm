from typing import List


class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = []
        positiveNumer = 0
        while positiveNumer < n and nums[positiveNumer] < 0:
            positiveNumer += 1
            pass

        if positiveNumer < n and nums[positiveNumer] == 0:
            res.append(0)
            negativeNumber = positiveNumer - 1
            positiveNumer += 1
        else:
            negativeNumber = positiveNumer - 1
            pass

        while positiveNumer < n and negativeNumber >= 0:
            if abs(nums[negativeNumber]) < nums[positiveNumer]:
                res.append(nums[negativeNumber] * nums[negativeNumber])
                negativeNumber -= 1
                pass
            else:
                res.append(nums[positiveNumer] * nums[positiveNumer])
                positiveNumer += 1
                pass
            pass
        while positiveNumer < n:
            res.append(nums[positiveNumer] * nums[positiveNumer])
            positiveNumer += 1
            pass
        while negativeNumber >= 0:
            res.append(nums[negativeNumber] * nums[negativeNumber])
            negativeNumber -= 1
            pass
        return res


