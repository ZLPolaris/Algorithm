from typing import List


class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        listSum = sum(matchsticks)
        if listSum % 4 != 0:
            return False

        pass

