// package LinkedList;
import  java.util.*;

public class Palindrom {
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
        }
    }
    Node head;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Palindrom p=new Palindrom();
        int n =sc.nextInt();
        for(int i=0;i<n;i++){
            int d=sc.nextInt();
            p.insert(d);
        }
       System.out.println(p.palin()); 

    }
    private boolean  palin() {
        ArrayList<Node> list=new ArrayList<>();
        Node temp=head;
        while(temp!=null){
            list.add(temp);
            temp=temp.next;
        }
        int n=list.size();
        int i=0,j=n-1;
        while(i<j){
            if(list.get(i).val!=(list.get(j).val)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    private void insert(int d) {
       Node newNode =new Node(d);
       if(head==null){
        head=newNode;
        return;
       }
       Node temp=head;
       while(temp.next!=null){
        temp=temp.next;
       }
       temp.next=newNode;
       System.out.println("Node is inserted");

    }
}
