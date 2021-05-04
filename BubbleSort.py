import random
import time

l1 = []
time_tracker = []


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


def average(numOfMeans, numOfInst, arrayLength):
    sum = 0
    for i in range(arrayLength):
        rand = random.randint(1, 1000)
        l1.insert(0, rand)
    for i in range(numOfMeans):
        start = time.time()
        for j in range(numOfInst):
            bubsort(l1)
        end = time.time()
        time_tracker.insert(0, end - start)
    for k in range(len(time_tracker)):
        sum = sum + time_tracker[k]
    aver = sum / len(time_tracker)
    print(time_tracker)
    print('The average time for Bubble Sort: ' + str(aver))


average(50, 2500, 20)
