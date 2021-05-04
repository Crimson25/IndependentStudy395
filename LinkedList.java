import java.util.Random;

public class LinkedList {
  
  Node head;
  
  static class Node{
    int data;
    Node next;
    
    Node(int d){
      data = d;
      next = null;
    }
  }
  
  public static LinkedList insert(LinkedList list, int d) {
    Node n1 = new Node(d);
    n1.next = null;
    
    if(list.head == null) {
      list.head = n1;
    }
    else {
      Node last = list.head;
      while(last.next != null) {
        last = last.next;
      }
      last.next = n1;
    }
    return list;
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
  
  public static void printList(LinkedList l) {
    Node current = l.head;
    System.out.println("LinkedList: ");
    
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }
    System.out.println();
  }
  
  public static LinkedList remove(LinkedList list, int k) {
    Node current = list.head; 
    Node prev = null;
    
    if(current != null && current.data == k) {
      list.head = current.next;
      return list;
    }
    
    while (current != null && current.data != k) {
      prev = current;
      current = current.next;
    }
    
    if (current != null) {
      prev.next = current.next;
    }
    
    if (current == null) {
     System.out.println(k + "Not Found"); 
    }
    return list;
  }
  
  public void averageTimeInsert(int numOfMeans, int numOfInstruc, LinkedList list) {
    long[] timeTracker = new long[numOfMeans];
    for(int j = 0; j < numOfMeans; j++) {
      long startTime = System.nanoTime();
      for(int i = 0; i < numOfInstruc; i++) {
        list = insert(list,i);
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
    System.out.println("The average time for insert in the linked list to run is " + average / 1000000000 + " seconds");
  }
  
  public void averageTimeRemove(int numOfMeans, int numOfInstruc, LinkedList list) {
    long[] timeTracker = new long[numOfMeans];
    for(int j = 0; j < numOfMeans; j++) {
      long startTime = System.nanoTime();
      for(int i = 0; i < numOfInstruc; i++) {
        list = remove(list,i);
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
    System.out.println("The average time for remove in the linked list to run is " + average / 1000000000 + " seconds");
  }


public static void main(String[] args) {
  LinkedList ll = new LinkedList();
    ll.averageTimeInsert(50, 2000, ll);
    ll.averageTimeRemove(50, 2000, ll);
  }
}