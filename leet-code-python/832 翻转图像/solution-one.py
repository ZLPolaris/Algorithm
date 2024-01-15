from typing import List


class Solution:
    def flipAndInvertImage(self, image: List[List[int]]) -> List[List[int]]:
        n = len(image)
        for row in range(0, n):
            left = 0
            right = n - 1
            while left < right:
                if image[row][left] == image[row][right]:
                    image[row][left] ^= 1
                    image[row][right] ^= 1
                    pass
                left += 1
                right -= 1
                pass
            if left == right:
                image[row][left] ^= 1
            pass
        return image
