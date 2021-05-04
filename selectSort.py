import random
import time


l1 = []
time_tracker = []


def sort(nums):
    for i in range(len(nums)):
        min_idx = i
        for j in range(i + 1, len(nums)):
            if nums[min_idx] > nums[j]:
                min_idx = j
            nums[i], nums[min_idx] = nums[min_idx], nums[i]


def average(numOfMeans, numOfInst, arrayLength):
    sum = 0
    for i in range(arrayLength):
        rand = random.randint(1, 1000)
        l1.insert(0, rand)
    for i in range(numOfMeans):
        start = time.time()
        for j in range(numOfInst):
            sort(l1)
        end = time.time()
        time_tracker.insert(0, end - start)
    for k in range(len(time_tracker)):
        sum = sum + time_tracker[k]
    aver = sum / len(time_tracker)
    print(time_tracker)
    print('The average time for Selection Sort: ' + str(aver))


average(50, 2500, 20)
