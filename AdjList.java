import java.util.ArrayList;
import java.util.List;

public class AdjList {
    int vertices;
   SinglyLinkedlist adjList[];

   AdjList(int vertices){
    this.vertices=vertices;
    adjList= new SinglyLinkedlist[vertices];


    for(int i=0 ; i<vertices;i++){
        adjList[i]=new SinglyLinkedlist();

    }

   }
   void addEdge(int u, int v ){
    adjList[u].addNode(v);
    adjList[v].addNode(u);
   }
List<Integer>getAdjNodes(int i){
    List<Integer> adjnodes = new ArrayList<>();
      SinglyLinkedlist.Node current=adjList[i].head;
       while (current!=null) {
       adjnodes.add(current.data);
        current=current.next;
       }
    return adjnodes;
}
   void printGraph(){
    for(int i=0 ; i<vertices;i++){
        System.out.println(i+"is connected to");
       SinglyLinkedlist.Node current=adjList[i].head;
       while (current!=null) {
        System.out.print(current.data+",");
        current=current.next;

        
       }
       System.out.println("");
       
    }
   }

   void depthFirstSearch(int source){
    boolean visited []= new boolean[vertices];
    dfs(source,visited);
   }
   void dfs(int rootnode, boolean[] visited){
    System.out.println(rootnode);
    visited[rootnode]=true;
    SinglyLinkedlist.Node current =adjList[rootnode].head;
    while (current!=null) {
        if(!visited[current.data]){
            dfs(current.data,visited);
        }
        current=current.next;
        
    }
   }
    public static void main(String[] args) {
        AdjList a= new AdjList(5);
        a.addEdge(0,1);
         a.addEdge(0,2);
          a.addEdge(0,4);
           a.addEdge(1,3);
             a.addEdge(2,3);
               a.addEdge(3,4); 
               a.printGraph();
    }
}


