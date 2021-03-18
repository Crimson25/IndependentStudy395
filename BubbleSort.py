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

l2 = [25, 64, 11, 2, 99, 101, 35, 77]
bubsort(l2)
