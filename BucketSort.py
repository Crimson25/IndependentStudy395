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


input_list = [1.20, 0.22, 0.43, 0.36, 0.39, 0.27]
sorted_list = bucket_sort(input_list)
print('Sorted Using Bucket Sort:')
print(sorted_list)
