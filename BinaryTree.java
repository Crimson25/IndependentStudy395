public class BinaryTree{
  
  class Node { 
    int key; 
    Node left, right; 

    public Node(int data){ 
        key = data; 
        left = right = null; 
    } 
} 

  Node root; 

  BinaryTree(){ 
    root = null; 
  } 
  
  void deleteKey(int key) { 
    root = delete_Recursive(root, key); 
  } 

  Node delete_Recursive(Node root, int key)  { 
   
    if (root == null)  return root; 

    if (key < root.key)      
        root.left = delete_Recursive(root.left, key); 
    else if (key > root.key)  
        root.right = delete_Recursive(root.right, key); 
    else  { 
        
        if (root.left == null) 
            return root.right; 
        else if (root.right == null) 
            return root.left; 

        root.key = minValue(root.right); 

        root.right = delete_Recursive(root.right, root.key); 
    } 
    return root; 
  } 

  int minValue(Node root)  { 
    int minval = root.key; 
    while (root.left != null)  { 
        minval = root.left.key; 
        root = root.left; 
    } 
    return minval; 
  } 

  void insert(int key)  { 
    root = insert_Recursive(root, key); 
  } 

  Node insert_Recursive(Node root, int key) { 
      
    if (root == null) { 
        root = new Node(key); 
        return root; 
    } 
    if (key < root.key)     
        root.left = insert_Recursive(root.left, key); 
    else if (key > root.key)    
        root.right = insert_Recursive(root.right, key); 
      
    return root; 
  } 

  void inorder() { 
    inorder_Recursive(root); 
  } 


  void inorder_Recursive(Node root) { 
    if (root != null) { 
        inorder_Recursive(root.left); 
        System.out.print(root.key + " "); 
        inorder_Recursive(root.right); 
    } 
  } 
 
  boolean search(int key)  { 
    root = search_Recursive(root, key); 
    if (root != null)
        return true;
    else
        return false;
  } 

  Node search_Recursive(Node root, int key)  { 
    if (root == null || root.key == key) 
        return root; 
    if (root.key > key) 
        return search_Recursive(root.left, key); 
    return search_Recursive(root.right, key); 
  } 
  
  public void printArray(long[] n) { 
    System.out.print("["); 
    for(int i = 0; i < n.length; i++) { 
      if (i < n.length-1) { 
        System.out.print(n[i] + ", "); 
        } 
    else { 
    System.out.print(n[i]); 
       } 
      } 
    System.out.println("]"); 
    } 
 
  public void averageTimeInsert(int numOfMeans, int numOfInstruc) {
    long[] timeTracker = new long[numOfMeans];
    for(int j = 0; j < numOfMeans; j++) {
      long startTime = System.nanoTime();
      for(int i = 0; i < numOfInstruc; i++) {
        insert(i);
      }
    long stopTime = System.nanoTime();
    timeTracker[j] = stopTime - startTime; 
    }
    long sum = 0;
    float average = 0;
    for (int k = 0; k < timeTracker.length; k++) {
      sum += timeTracker[k];
    }
    average = (float) (sum / timeTracker.length);
    printArray(timeTracker);
    System.out.println("The average time for insert in the binary to run is " + average / 1000000000 + " seconds");
  }
  
  public void averageTimeRemove(int numOfMeans, int numOfInstruc) {
    long[] timeTracker = new long[numOfMeans];
    for(int j = 0; j < numOfMeans; j++) {
      long startTime = System.nanoTime();
      for(int i = 0; i < numOfInstruc; i++) {
        deleteKey(i);
      }
    long stopTime = System.nanoTime();
    timeTracker[j] = stopTime - startTime; 
    }
    long sum = 0;
    float average = 0;
    for (int k = 0; k < timeTracker.length; k++) {
      sum += timeTracker[k];
    }
    average = (float) (sum / timeTracker.length);
    printArray(timeTracker);
    System.out.println("The average time for remove in the binary tree to run is " + average / 1000000000 + " seconds");
  }
  
  public static void main(String[] args)  { 
    BinaryTree bst = new BinaryTree(); 
   bst.averageTimeInsert(50, 100);
   bst.averageTimeRemove(50, 100);
 } 
}