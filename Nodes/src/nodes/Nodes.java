/*
The missing part of the code is balancing during the deletion and 
displaying the output.
*/

package nodes;

import java.util.Scanner;

public class Nodes {

    public static Scanner sc;
    public static BinaryTree tree;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        tree = new BinaryTree();
        short choice = 0;
        while(choice != 3 || choice <= 3){
            System.out.println("[1]Insert\n"
                              +"[2]Delete\n"
                              +"[3]Exit");
            System.out.print(">>");
            choice = sc.nextShort();
           switch(choice){
               case 1:
                   System.out.print("Insert a number: ");
                   int value = sc.nextInt();
                   tree.add(value);
                   break;
               case 2:
                   System.out.print("Delete a number:");
                   value = sc.nextInt();
                   tree.delete(value);
                   break;
               case 3:
                   System.exit(0);
                   break;
           }
           System.out.println("[1]Insert/n" 
                              +"[2]Delete/n"
                              +"[3]Exit");
            System.out.print(">>");
            choice = sc.nextShort();
        }
        
    }
    
}
