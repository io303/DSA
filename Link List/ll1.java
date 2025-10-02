

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

public void  insertLast(int val){
    Node node =new Node(val);
    Node temp=head;
    while(temp.next!=null){
        temp=temp.next;
    }
 temp.next=node;

}

public void insertParticular(int val,int index){
    if(index==0){
        insert(val);
        return;
    }
    Node temp=head;
    for(int i=1;i<index;i++){
        temp=temp.next;
    }
    Node node =new Node(val,temp.next);
    temp.next=node;

}

public int deletef(){
    int value=head.val;
    head=head.next;
    return value;

}
public int deletel(){
    Node temp=head;
    if(head==null){
        System.out.println(("not posiible"));
        return -1;
    }
    if(head.next==null){
        int value=head.val;
        head=null;
    return value;
    }
    while(temp.next.next!=null){
        temp=temp.next;
    }
    int value=temp.next.val;
        temp.next=null;
        return value;
}
public int delete(int index){
    if(index==0){
        return deletef();
    }
    Node temp=head;
  
    for(int i=1;temp!=null&&i<index;i++){

        temp=temp.next;
    }
   if(temp==null||temp.next==null){
    return -1;
   }
int va=temp.next.val;
temp.next=temp.next.next;
return va;
}



    public void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.println("END");
        
    }


}

class lMain{
      public static void main(String[] args) {
        ll1 l=new ll1();
        l.insert(4);
        l.insert(5);
        l.insert(6);
        l.print();
        // l.insertLast(7);
        l.insertParticular(8, 1);
        l.print();
    //    System.out.println( l.deletef());
    // System.out.println(l.deletel());
    l.delete(1);
       l.print();
        // l.insert(1);
        l.insertParticular(0, 1);
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
