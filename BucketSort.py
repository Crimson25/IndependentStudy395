import random
import time

l1 = []
time_tracker = []


def bucket_sort(input):
    maxval = max(input)
    size = maxval / len(input)
    buckets = []

    for x in range(len(input)):
        buckets.append([])

    for i in range(len(input)):
        j = int(input[i] / size)
        if j != len(input):
            buckets[j].append(input[i])
        else:
            buckets[len(input) - 1].append(input[i])

    for z in range(len(input)):
        insertion_sort(buckets[z])

    final = []
    for x in range(len(input)):
        final = final + buckets[x]
    return final


def insertion_sort(bucket):
    for i in range(1, len(bucket)):
        var = bucket[i]
        j = i - 1
        while j >= 0 and var < bucket[j]:
            bucket[j + 1] = bucket[j]
            j = j - 1
        bucket[j + 1] = var


def average(numOfMeans, numOfInst, arrayLength):
    sum = 0
    for i in range(arrayLength):
        rand = random.random()
        l1.insert(0, rand)
    for i in range(numOfMeans):
        start = time.time()
        for j in range(numOfInst):
            bucket_sort(l1)
        end = time.time()
        time_tracker.insert(0, end - start)
    for k in range(len(time_tracker)):
        sum = sum + time_tracker[k]
    aver = sum / len(time_tracker)
    print(time_tracker)
    print('The average time for Bucket Sort: ' + str(aver))


average(50, 2000, 20)
