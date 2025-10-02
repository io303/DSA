import java.util.*;

public class Main2 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(0);  // 👈 use 0 instead of empty constructor
        ListNode temp = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        temp.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        ListNode list1 = null, t1 = null;
        for (int i = 0; i < n1; i++) {
            int x = sc.nextInt();
            if (list1 == null) {
                list1 = new ListNode(x);
                t1 = list1;
            } else {
                t1.next = new ListNode(x);
                t1 = t1.next;
            }
        }

        int n2 = sc.nextInt();
        ListNode list2 = null, t2 = null;
        for (int i = 0; i < n2; i++) {
            int x = sc.nextInt();
            if (list2 == null) {
                list2 = new ListNode(x);
                t2 = list2;
            } else {
                t2.next = new ListNode(x);
                t2 = t2.next;
            }
        }

        ListNode res = mergeTwoLists(list1, list2);
        printList(res);
    }
}





class ListNode {
    int val;
    ListNode next;

    ListNode() {}   // 👈 important
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

 