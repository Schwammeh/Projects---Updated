package salary;

import java.util.*;

public class Salary {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        input for hourly pay rate, regular hours and overtime hours
        */
        System.out.println("===============SALARY===============");
        
        System.out.print("Hourly pay rate: ");
        double payRate = sc.nextDouble();
        
        System.out.print("Regular Hours: ");
        int hours = sc.nextInt();
        
        System.out.print("Overtime Hours: ");
        int over = sc.nextInt();
        
        System.out.println("Salary is: " + overTime(payRate,hours,over));
    }
    //overtime pay = hours * pay + (over * 1.5)
    public static double overTime(double pay, int hours, int over){
        double overPay = hours * pay + (over * 1.5);
        return overPay;
    }
    
}
