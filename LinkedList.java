
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


public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list = insert(list,1);
    list = insert(list, 2);
    list = insert(list, 3);
    list = insert(list, 4);
    list = insert(list, 5);
    list = insert(list, 6);
    list = insert(list, 7);
    list = insert(list, 8);
    
    printList(list);
    
    list = remove(list, 3);
    
    printList(list);
  }
}