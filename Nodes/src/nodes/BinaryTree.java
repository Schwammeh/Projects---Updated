package nodes;

public class BinaryTree {
    Node root;
    //Insertion of the value
    private Node insert(Node current,int value){
        //if root is null then the value is now a root
        if(current == null){
            return new Node(value);
        }
        //this is where insertion is
        //this is for the left case
        if(value < current.value){
            current.left = insert(current.left,value);
            if(height(current.left) - height(current.right) == 2){
                if(value < current.left.value)
                    current = rotationLeft(current);
                
                else
                    current = doubleRotationLeft(current);
            }
        }
        //this is for the right case
        else if(value > current.value){
            current.right = insert(current.right,value);
            if(height(current.right) - height(current.left) == 2){
                if(value > current.right.value)
                    current = rotationRight(current);
                else
                    current = doubleRotationRight(current);
            }
        }
        else{
            return current;
        }
        return current;
    }
    //method to be called for the insertion
    public void add(int value){
        root = insert(root,value);
    }
    //node deletion logic
    private Node remove(Node current,int value){
        //if the value is not there
        if(current == null){
            return null;
        }
        //if the value is present or found
        if(value == current.value){
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }
 
            if (current.left == null) {
                return current.right;
            }
            //this will help for finding the replacement for the node
            int smallestValue = findSmallestVal(current.right);
            current.value = smallestValue;
            current.right = remove(current.right, smallestValue);
            return current;
        }
        //will find for the node
        if(value < current.value){
            current.left = remove(current.left,value);
            return current;
        }
        current.right = remove(current.right,value);
        return current;       
    }
    //this will find the smallest value
    private int findSmallestVal(Node root){
        return root.left == null ?  root.value : findSmallestVal(root.left);
        
    }
    //method to be called to main method for deletion
    public void delete(int value) {
        root = remove(root, value);
    }
    //will try and get the height
    private int height(Node t){
        return t == null ? -1 : t.height;
    }
    //gets the max Node
    private int max(int lhs, int rhs){
        return lhs > rhs ? lhs : rhs;
    }
    //this is the balancing method for left child
    private Node rotationLeft(Node k2){
        Node k1 = k2.left;
        k2.left = k1.right;
        k2.height = max(height(k2.left),height(k2.right))+1;
        k1.height = max(height(k1.left),k2.height)+1;
        return k1;
    }
    //balancing for the right child
    private Node rotationRight(Node k1){
        Node k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max(height(k1.left),height(k1.right))+1;
        k2.height = max(height(k2.right),k1.height)+1;
        return k2;
    }
    //double rotation right balancing
    private Node doubleRotationRight(Node k1){
        k1.right = rotationLeft(k1.right);
        return rotationRight(k1);
    }
    //double rotation left balancing
    private Node doubleRotationLeft(Node k3){
        k3.left = rotationRight(k3.left);
        return rotationLeft(k3);
    }
    //this will count the nodes
    private int countNodes(Node r){
        if(r == null)
            return 0;
        else{
            int l = 1;
            l += countNodes(r.left);
            l += countNodes(r.right);
            return 1;
        }
    }
}
