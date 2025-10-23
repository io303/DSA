

public class Stack {
    int data[];
    private static final int DEFAULT_SIZE=10;
    int ptr=-1;

    public Stack(int size) {
     this.data=new int[size];
    }
    void push(int val){
        if(isFull()){
            System.out.println("overflow");
            return;
        }
        ptr++;
        data[ptr]=val;
    }
    int pop(){
        if(isEmpty()){
            return -1;
        }
        int removed=data[ptr];
        ptr--;
        System.out.println("rr");
        return removed;
    }
    boolean isFull(){
        return ptr==data.length-1;
    }
    boolean isEmpty(){
        return ptr==-1;
    }
    void display(){
        for(int i=0;i<ptr;i++){
            System.out.println(data[i]);
        }
    }
    public static void main(String[] args) {
        Stack st=new Stack(5);
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.display();
       st.pop();
    }
}
