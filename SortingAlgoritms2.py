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


def bubsort(arr):
    n = len(arr)

    for i in range(n):
        swapped = False
        for j in range(0, n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                swapped = True
        if not swapped:
            break
    print("Sorted Array Using Bubble Sort:")
    print(arr)

l1 = [63, 32, 11, 98, 61, 55, 3, 84, 78]
l2 = [25, 64, 11, 2, 99, 101, 35, 77]
selsort(l1)
bubsort(l2)
