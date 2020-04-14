package pizzachoice;

import java.util.*;
import javax.swing.*;

public class PizzaChoice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        short in = 0;
        
        System.out.println("Read in Italian Voice");
        System.out.println("Welcome to the PizzaRia!");
        while(in < 2){
            System.out.println("Whata size of da pizza do you want?\n"
                              +"We gotta:\n"
                              +"[S/s]Small fora $6.99\n"
                              +"[M/m]Medium fora $8.99\n"
                              +"[L/l]Large fora $12.50\n"
                              +"[X/x]Extra Large fora $15.00");
            System.out.print("Choice: ");
            char choice = sc.next().charAt(0);
                switch(choice){
                    case 'S':
                    case 's':
                        System.out.println("You have boughta small for $6.99");
                        break;
                    case 'M':
                    case 'm':
                        System.out.println("You have boughta medium for $8.99");
                        break;
                    case 'L':    
                    case 'l':
                        System.out.println("You have boughta large for $12.50");
                        break;
                    case 'X':
                    case 'x':
                        System.out.println("You have boughta extra large for $15.00");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"That is not a size");
                        break;
                }
            System.out.println("Do you want another order?"
                              +"[1]Yes\t"
                              +"[2]No");   
            in = sc.nextShort();
            System.out.println("===========================================================");
        }
        System.out.println("HAVE A NICE DAY!");
    }
    
}
