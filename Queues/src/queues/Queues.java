package queues;

import java.util.Scanner;

public class Queues {

    public static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int count = 0;
        int choice = 0;
        System.out.print("Enter the size of the Queue: ");
        int in = sc.nextInt();
        
        Object[] queue = new Object[in];
        
        while(choice != 3){
        System.out.println("Options:\n"
                          + "[1]INSERT\n"
                          + "[2]DELETE\n"
                          + "[3]EXIT");
        
        System.out.print("Choice: ");
        choice = sc.nextShort();
        
            switch(choice){
                case 1:
                    if(count >= queue.length){
                            System.out.println("Queue is full");
                    }
                    
                    else{
                        System.out.print("Push a number: ");
                        int input = sc.nextInt();
                        queue[count] = input;
                        System.out.println("REAR: " + count);
                        System.out.println("QUEUE: ");
                            for(int i = count;i >= 0;i--){
                                System.out.print(queue[i] + ",");
                            }     
                        count++;
                        System.out.println("");
                    }      
                    break;
                case 2:
                    if(count <= 0){
                        System.out.println("Empty queue");
                    }
                    else{
                        count--;
                        System.out.println("REAR: " + count);
                        System.out.println("QUEUE: ");
                            for(int i = count;i > 0;i--){
                                System.out.print(queue[i] + ",");
                            }                       
                    }
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Queue: ");
                    for(int i = count;i > 0;i--){
                        System.out.print(queue[i] + ",");
                    }
                    System.exit(0);
                    break;
            }
        }
    }
    
}
