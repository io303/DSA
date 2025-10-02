
import java.util.Scanner;



public class Solution1 {

    // Function to remove duplicates from sorted list
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next; // skip duplicate
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    // Utility function to print list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Main function to run in VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution1 sol = new Solution1();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("Empty list");
            return;
        }

        // Read linked list elements
        System.out.println("Enter sorted elements:");
        ListNode head = new ListNode(sc.nextInt());
        ListNode temp = head;
        for (int i = 1; i < n; i++) {
            temp.next = new ListNode(sc.nextInt());
            temp = temp.next;
        }

        // Solve problem
        ListNode result = sol.deleteDuplicates(head);

        // Print final list
        System.out.println("After removing duplicates:");
        sol.printList(result);
    }
}
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}