import bisect
from typing import List


class Solution:
    def longestObstacleCourseAtEachPosition(self, obstacles: List[int]) -> List[int]:
        if not obstacles or len(obstacles) == 0:
            return []
        n = len(obstacles)
        res = [1] * n
        save = [obstacles[0]]
        for i in range(1, n):
            if obstacles[i] >= save[-1]:
                save.append(obstacles[i])
                res[i] = len(save)
                pass
            else:
                index = bisect.bisect_right(save, obstacles[i])
                save[index] = obstacles[i]
                res[i] = index + 1
                pass
            pass
        return res
    pass


s = Solution()
print(s.longestObstacleCourseAtEachPosition([1, 2, 3, 2]))
