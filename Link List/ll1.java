

public class ll1 {
    private  Node head;
    private Node tail;

    public void insert(int val){
        Node  node=new Node(val);
        node.next=head;
        head=node;
        if(tail==null){
            tail=head;
        }
    }

    public void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        
    }


}

class Main{
      public static void main(String[] args) {
        ll1 l=new ll1();
        l.insert(4);
        l.insert(5);
        l.insert(6);
        l.print();

    }
}






class Node{
    int val;
    Node next;

    public Node(int val) {
        this.val=val;
    }

    public Node(int val,Node next) {
        this.val=val;
        this.next=next;
    }
    
}
