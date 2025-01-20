public class AVLTree {
    public static class Node {
    int data;
    Node left;
    Node right;
    int height;
    Node(int data){
        this.left=this.right=null;
        this.height=1;
        this.data=data;
    }

    
        
    }
    Node createBST(Node root, int data){
        if(root==null){
            return new Node(10);
            
        }
        if(data<root.data){
            root.left=createBST(root.left, data);
        }
        else if (data>root.data){
            root.right =createBST(root.right, data);
        }
        else{
            return root;
        }
        root.height=1+Math.max(getHeight(root.left), getHeight(root.right));
        int balancefactor=getBalanceFactor(root);
    }
    int getHeight(Node root){
        if (root==null){
            return -1;

        }
        return root.height;
    }
    int getBalanceFactor(Node root ){
        if(root==null){
            return 0;
        }
        return getHeight(root.left)-getHeight(root.right);
    }
}
