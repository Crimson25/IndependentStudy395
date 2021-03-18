import java.util.ArrayList;
import java.util.Collections;

public class Sorters {
  
  public void selsort(int[] n) { 
    for(int i = 0; i < n.length; i++) { 
      for(int j = i + 1; j < n.length; j++) { 
         int min = i; 
         if(n[min] > n[j]) { 
           min = j; 
           } 
         int temp = n[min]; 
         n[min] = n[i]; 
         n[i] = temp; 
        } 
      } 
    } 

  public void bubbleSort(int[] n) {
    int x = n.length;
    for (int i = 0; i < x - 1; i++) {
      for(int j = 0; j < x - i -1; j++) {
        if (n[j] > n[j+1]) {
          int temp = n[j];
          n[j] = n[j+1];
          n[j+1] = temp;
        } 
      }
    }
  }
  
  
  public void bucketSort(float[] arr, int n) {
    if(n <= 0)
      return;
    
    ArrayList<Float>[] bucket = new ArrayList[n];
    
    for(int i = 0; i < n; i++) {
      bucket[i] = new ArrayList<Float>();
    }
    for (int i = 0; i < n; i++) {
     int bucketIndex = (int) arr[i] * n;
     bucket[bucketIndex].add(arr[i]);
    }
    
   for (int i = 0; i < n; i++) {
     Collections.sort((bucket[i]));
   }
   
   int index = 0;
   for(int i = 0; i < n; i++) {
     for (int j = 0, size = bucket[i].size(); j < size; j++) {
       arr[index++] = bucket[i].get(j);
     }
   }
   
  }
  
    public void printArray(int[] n) { 
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

    public void printArray(float[] n) { 
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
     

    public static void main(String[]agrs) { 
    Sorters ob = new Sorters(); 
    int[] arr = new int[] {55,32,21,99,87,62,35,2,14}; 
    ob.selsort(arr); 
    System.out.println("Sortred Array Using Selection Sort:"); 
    ob.printArray(arr); 
    
    int[] arr2 = new int[] {62,31,22,99,87,2,14,55,57};
    ob.bubbleSort(arr2);
    System.out.println("Sortred Array Using Bubble Sort:"); 
    ob.printArray(arr2); 
    
    float[] arr3 = {(float) .42, (float) .21, (float) .55, (float) .88, (float) .67, (float) .05, (float) .37};
    ob.bucketSort(arr3, arr3.length);
    System.out.println("Sortred Array Using Bucket Sort:");
    ob.printArray(arr3);
    }     
}
