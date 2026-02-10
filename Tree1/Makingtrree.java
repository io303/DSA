import java.util.*;
class Node{
    int data;
    Node left,right;

    Node(int d){
        this.data=d;
        left=right=null;
    }
}
public class Makingtrree {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int arr[]=new int[n];
    
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();

        }
        Node root =buildtree(n,arr);

        print(root);
    }
    // gfygugbubggbv

    private static void print(Node root) {
        if(root==null) return;
        print(root.left);
        System.out.print(root.data+" ");
        print(root.right);

    }

    private static Node buildtree(int n, int[] arr) {
      if(n==0) return null;
      Node root=new Node(arr[0]);
      Queue<Node> q=new LinkedList<>();
      q.add(root);
      int i=1;
      while(!q.isEmpty()&& i<n){
        Node curr=q.poll();

        if(i<n){
            curr.left=new Node(arr[i++]);
            q.add(curr.left);
        }
        if(i<n){
            curr.right=new Node(arr[i++]);
            q.add(curr.right);
        }
      }
      return root;
    }
}
