public class BinaryTree{
  
  static class Node{
    int key;
    Node left;
    Node right;
    
   public Node(int item) {
     key = item;
     left = null;
     right = null;
    }
  }
  
   Node root;
    
   BinaryTree(int key){
     root = new Node(key);
    }
    
   BinaryTree(){
     root = null;
    }
   
   public static void printTree(BinaryTree t) {
     Node n1 = t.root;
     if(n1 != null) {
       System.out.print("[" + n1.key + ", ");
     }
   }
    
   public static void main(String[] args) {
     BinaryTree tree = new BinaryTree();
     tree.root = new Node(1);
     tree.root.left = new Node(2);
     tree.root.right = new Node(3);
   }
  }