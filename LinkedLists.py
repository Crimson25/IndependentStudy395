import time

time_tracker = []


class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None

    def print_list(self):
        temp = self.head
        while temp:
            if temp.next is None:
                print(temp.data)
                temp = temp.next
            else:
                print(temp.data, " -> ", end=" ")
                temp = temp.next

    def push(self, new_data):
        new_node = Node(new_data)
        new_node.next = self.head
        self.head = new_node

    def deleteNode(self, key):
        temp = self.head
        if temp is not None:
            if temp.data == key:
                self.head = temp.next
                temp = None
                return
        while temp is not None:
            if temp.data == key:
                break
            prev = temp
            temp = temp.next
        if temp is None:
            return
        prev.next = temp.next
        temp = None


def average_insert(numOfMeans, numOfInstr, l1):
    sum = 0
    for i in range(numOfMeans):
        start = time.time()
        for j in range(numOfInstr):
            l1.push(j)
        end = time.time()
        time_tracker.insert(0, end - start)
    for k in range(len(time_tracker)):
        sum = sum + time_tracker[k]
    aver = sum / len(time_tracker)
    print(time_tracker)
    print('The average time for Linked List insert: ' + str(aver))


def average_delete(numOfMeans, numOfInstr, l1):
    sum = 0
    for i in range(numOfMeans):
        start = time.time()
        for j in range(numOfInstr):
            l1.deleteNode(j)
        end = time.time()
        time_tracker.insert(0, end - start)
    for k in range(len(time_tracker)):
        sum = sum + time_tracker[k]
    aver = sum / len(time_tracker)
    print(time_tracker)
    print('The average time for Linked List Delete: ' + str(aver))


ll1 = LinkedList()
average_insert(50, 2000, ll1)
average_delete(50, 2000, ll1)
