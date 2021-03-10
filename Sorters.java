
public class Sorters {
  
  public void selsort(int[] n) { 
    for(int i = 0; i < n.length; i++) { 
      for(int j = i+1; j < n.length; j++) { 
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
    System.out.print("]"); 
    } 

     

    public static void main(String[]agrs) { 
    Sorters ob = new Sorters(); 
    int[] arr = new int[] {55,32,21,99,87,62,35,2,14}; 
    ob.selsort(arr); 
    System.out.println("Sortred Array Using Selection Sort:"); 
    ob.printArray(arr); 
    }     
}
