import java.util.*;
public class Reverse6 {
    public ListNode reverse(ListNode head,int left,int right){
if (left == right) {
            return head;
        }

        // skip the first left-1 nodes
        ListNode current = head;
        ListNode prev = null;
        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;

        // reverse between left and right
        ListNode next = current.next;
        for (int i = 0; current != null && i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = current;
        return head;
    }
}
class Main7{
     public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ListNode head= new ListNode(sc.nextInt());
        ListNode temp=head;
        for(int i=1;i<n;i++){
            temp.next=new ListNode(sc.nextInt());
            temp=temp.next;
        }
        int l=sc.nextInt();
        int r=sc.nextInt();
       Reverse6 r1= new Reverse6();
        r1.reverse(head, l, r);
        printList(head);


    }
}









class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }
ListNode(int val){
    this.val=val;
}
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    
}