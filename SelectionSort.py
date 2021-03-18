import sys

def selsort(nums):
    for i in range(len(nums)):
        min_idx = i
        for j in range(i + 1, len(nums)):
            if nums[min_idx] > nums[j]:
                min_idx = j
            nums[i], nums[min_idx] = nums[min_idx], nums[i]

    print("Sorted Array Using Selection Sort:")
    print(nums)

l1 = [63, 32, 11, 98, 61, 55, 3, 84, 78]
selsort(l1)

