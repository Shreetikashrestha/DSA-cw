public class SinglyLinkedlist {
 
        public static class Node{
            int data;
            Node next;


            Node(int data){
                this.data=data;
                this.next=null;
            }
        }
        //address rakhna ...first time null
        Node head=null;
        Node tail=null;
        //data rakhna
        void addNode(int data){
            Node newnode=new Node(data);
            if(head==null){
                head=tail=newnode;//if null cha vane take the address of newnoode
            }
            else{
                tail.next=newnode;
                tail=newnode;
            //     Node current=head;
            //     while(current.next!=null){
            //         current=current.next;
            //     }
            //     current.next=newnode;

            // }
           
                
        }

        
    }
     void insertHeadFirst(int data){
         Node newnode=new Node(data);
            if(head==null){
                head=tail=newnode;//if null cha vane take the address of newnoode
            }
            else{
                //first tira insert garna
                newnode.next=head;
                head=newnode;
     }
}
    void printList(){
        Node current =head;
        while(current!=null){
            System.out.println(current.data);
            current=current.next;

        }


}
}

