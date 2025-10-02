
import java.util.*;

public class Cyclelength {
    public int hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Cycle detected → find its length
                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0; // no cycle
    }
}

class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Number of nodes
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println(0);
            return;
        }

        // Step 2: Create linked list
        ListNode head = new ListNode(sc.nextInt());
        ListNode temp = head;
        ListNode cycle = null;

        ListNode[] nodes = new ListNode[n];
        nodes[0] = head;

        for (int i = 1; i < n; i++) {
            nodes[i] = new ListNode(sc.nextInt());
            temp.next = nodes[i];
            temp = temp.next;
        }

        // Step 3: Read position for cycle
        int pos = sc.nextInt();
        if (pos != -1) {
            temp.next = nodes[pos]; // connect last node to pos-th node
        }

        // Step 4: Get cycle length
        Cyclelength sol = new Cyclelength();
        int result = sol.hasCycle(head);
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

