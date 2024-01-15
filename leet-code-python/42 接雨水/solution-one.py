from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        maxLastIndex = Solution.findLastMaxIndex(height)
        i = 0
        j = 1
        value = 0
        while j <= maxLastIndex:
            if height[j] < height[i]:
                value += height[i] - height[j]
                pass
            else:
                i = j
            j += 1
            pass
        i = n - 1
        j = n - 2
        print(value)
        while j >= maxLastIndex:
            if height[j] < height[i]:
                value += height[i] - height[j]
                pass
            else:
                i = j
                pass
            j -= 1
            pass
        return value

    @staticmethod
    def findLastMaxIndex(height: List[int]) -> int:
        maxValue = height[0]
        maxIndex = 0
        for i in range(1, len(height)):
            if height[i] >= maxValue:
                maxValue = height[i]
                maxIndex = i
                pass
        return maxIndex

    pass


s = Solution()
print(s.trap([4, 2, 0, 3, 2, 5]))
