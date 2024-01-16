from typing import List


class Solution:
    def verifyTreeOrder(self, postorder: List[int]) -> bool:
        def getVerifyTreeOrder(left: int, right: int) -> bool:
            if left >= right:
                return True
            root = postorder[right]
            i = left
            while i < right and postorder[i] <= root:
                i += 1
                pass
            mid = i
            while i < right and postorder[i] >= root:
                i += 1
                pass
            if i == right:
                return getVerifyTreeOrder(left, mid - 1) and getVerifyTreeOrder(mid, right - 1)
            else:
                return False
            pass

        return getVerifyTreeOrder(0, len(postorder) - 1)
