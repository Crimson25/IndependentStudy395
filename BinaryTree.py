import time

time_tracker = []


class TreeNode:
    def __init__(node, data):
        node.data = data
        node.left = None
        node.right = None

    def add(node, data):
        if node is None:
            node = TreeNode(data)
        elif data < node.data:
            if node.left is None:
                node.left = TreeNode(data)
            else:
                node.left.add(data)
        else:
            if node.right is None:
                node.right = TreeNode(data)
            else:
                node.right.add(data)

    def delete(node, temp, data):
        if data < node.data:
            temp = node
            node.left.delete(temp, data)
        elif data > node.data:
            temp = node
            node.right.delete(temp, data)

        else:
            if node.left is None and node.right is None:
                if temp.left == node:
                    temp.left = None
                else:
                    temp.right = None
                node = None

            elif node.right is None:
                if temp.left == node:
                    temp.left = node.left
                else:
                    temp.right = node.left
                node = None

            elif node.left is None:
                if temp.left == node:
                    temp.left = node.right
                else:
                    temp.right = node.right
                node = None

            else:
                temp = node.right
                while temp.left is not None:
                    temp = temp.left
                node.data = temp.data
                node.right.delete(temp, temp.data)

    def Inorder(node, Root):
        if Root is None:
            return
        node.Inorder(Root.left)
        print(Root.data, end=' ')
        node.Inorder(Root.right)


def average_insert(numOfMeans, numOfInstr, Root):
    sum = 0
    for i in range(numOfMeans):
        start = time.time()
        for j in range(numOfInstr):
            Root.add(j)
        end = time.time()
        time_tracker.insert(0, end - start)
    for k in range(len(time_tracker)):
        sum = sum + time_tracker[k]
    aver = sum / len(time_tracker)
    print(time_tracker)
    print('The average time for Binary Tree insert: ' + str(aver))


def average_delete(numOfMeans, numOfInstr, Root):
    sum = 0
    for i in range(numOfMeans):
        start = time.time()
        for j in range(numOfInstr):
            Root.delete(Root, j)
        end = time.time()
        time_tracker.insert(0, end - start)
    for k in range(len(time_tracker)):
        sum = sum + time_tracker[k]
    aver = sum / len(time_tracker)
    print(time_tracker)
    print('The average time for Binary Tree Delete: ' + str(aver))


Root6 = TreeNode(50)
average_insert(50, 100, Root6)
average_delete(50, 100, Root6)

