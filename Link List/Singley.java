import java.util.Scanner;


// Node class
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class NeoPatLinkedListClean {
      Node head;

    // General insert method
    void insert(int data, int position) {
        Node newNode = new Node(data);

        if (position <= 1 || head == null) { // insert at beginning
            newNode.next = head;
            head = newNode;
            System.out.println(data + " inserted at beginning.");
            return;
        }

        Node temp = head;
        int i = 1;
        while (temp.next != null && i < position - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println(data + " inserted at position " + (i + 1));
    }

    // Delete a node
    void delete(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.data == data) {
            head = head.next;
            System.out.println(data + " deleted.");
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != data)
            temp = temp.next;

        if (temp.next == null) {
            System.out.println(data + " not found.");
            return;
        }

        temp.next = temp.next.next;
        System.out.println(data + " deleted.");
    }

    // Search a node
    void search(int data) {
        Node temp = head;
        int pos = 1;
        while (temp != null) {
            if (temp.data == data) {
                System.out.println(data + " found at position " + pos);
                return;
            }
            temp = temp.next;
            pos++;
        }
        System.out.println(data + " not found.");
    }

    // Display list
    void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Count nodes
    void count() {
        Node temp = head;
        int c = 0;
        while (temp != null) {
            c++;
            temp = temp.next;
        }
        System.out.println("Total nodes: " + c);
    }

    // Reverse list
    void reverse() {
        Node prev = null, current = head, next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        System.out.println("List reversed.");
    }
}

// Main class
public class Singley {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Singley list = new Singley();
        int choice, data, pos;

        do {
            System.out.println("\n--- Singly Linked List ---");
            System.out.println("1. Insert a node");
            System.out.println("2. Delete a node");
            System.out.println("3. Search a node");
            System.out.println("4. Display list");
            System.out.println("5. Count nodes");
            System.out.println("6. Reverse list");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert: ");
                    data = sc.nextInt();
                    System.out.print("Enter position (1 for beginning): ");
                    pos = sc.nextInt();
                    list.insert(data, pos);
                    break;
                case 2:
                    System.out.print("Enter data to delete: ");
                    data = sc.nextInt();
                    list.delete(data);
                    break;
                case 3:
                    System.out.print("Enter data to search: ");
                    data = sc.nextInt();
                    list.search(data);
                    break;
                case 4:
                    list.display();
                    break;
                case 5:
                    list.count();
                    break;
                case 6:
                    list.reverse();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 7);

        sc.close();
    }

}
