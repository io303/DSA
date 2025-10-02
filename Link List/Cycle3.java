import java.util.*;
public class Cycle3 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }
}




class Main3{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        ListNode l1=new ListNode(sc.nextInt());
        ListNode temp=l1;
        ListNode cycle=null;
        int pos=sc.nextInt();
         for(int i=1;i<n;i++){
            ListNode x=new ListNode(sc.nextInt());
            temp.next=x;
            temp=temp.next;
            if(i==pos){
                cycle=x;
            }
         }   

          if (pos != -1) {
            temp.next = cycle;
        }
         Cycle3 sol = new Cycle3();
        boolean result = sol.hasCycle(l1);
        System.out.println(result);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}