public class doublelinkedlist {
    public static class Node{
        int data;
        Node prev;
        Node next;
        Node(int data){
            this.data=data;
            this.next=this.prev=null;
        }
    }
    Node head=null;
    Node tail=null;
    //insert or add rakhda ni hunxa
    void insert (int data){
        Node newnode=new Node(data);
        if(head==null){
            head=tail=newnode;
        }
        else{
            tail.next=newnode;
            newnode.prev=tail;
            tail=newnode;
        }


    }

    void printList(){
        Node current =head;
        while(current!=null){
            System.out.println(current.data);
            current =current.next;
        }
    }
    
}
