package nodes;
//Sets up for the Binary Tree
//this will just make the value into a node
public class Node<T> {
    Node right;
    Node left;
    int value;
    int height;
    
    Node(int value){
        this.value = value;
        right = null;
        left = null;
        height = 0;
    }
}
