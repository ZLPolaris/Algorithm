from typing import List


class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        n = len(intervals)
        intervals.sort(key=lambda interval: interval[1])
        number = 1
        right = intervals[0][1]
        for i in range(1, n):
            if intervals[i][0] >= right:
                right = intervals[i][1]
                number += 1
                pass
            pass
        return n - number

    pass


solution = Solution()
solution.eraseOverlapIntervals([[1, 2], [2, 3], [3, 4], [1, 3]])
