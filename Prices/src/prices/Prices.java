package prices;

import java.util.*;
import java.text.DecimalFormat;

public class Prices {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Prices p = new Prices();
        DecimalFormat df = new DecimalFormat("#.00");
        double sum = 0;
        double[] prices = new double[20];
        System.out.println("Side note: The decimal format is at #.00");
        for(int i = 0;i < prices.length;i++){
            System.out.print("Input a price: ");
            prices[i] = sc.nextDouble();
        }
        for(int i = 0;i < prices.length;i++){
            System.out.print(prices[i] + " ,");
        }

        System.out.println("");
        System.out.println("Sum of the prices: " + df.format(p.sum(prices)));
        
        System.out.println("");
        System.out.println("Prices less than 5.00");
        for(int i = 0;i < prices.length;i++){
            if(prices[i] < 5.00){                
                System.out.print(prices[i] + " ,");
            }
        }
        System.out.println("");
        System.out.println("Average of prices: " + df.format(p.mean(sum,prices)));
        
        System.out.println("");
        System.out.println("Prices higher than the average");
        for(int i = 0;i < prices.length;i++){
            if(prices[i] > p.mean(sum, prices)){
                System.out.print(prices[i] + " ,");
            }
        }
    }
    public double sum(double[] arr){
        double sum = 0;
        for(int i = 0;i < arr.length;i++){
            sum = arr[i] + sum;
        }
        return sum;
    }
    public double mean(double sum,double[] arr){
        double mean = sum/arr.length;
        return mean;
    }
    
}
