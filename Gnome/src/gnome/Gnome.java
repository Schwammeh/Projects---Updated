package gnome;

import java.util.*;

public class Gnome {

    public static void main(String[] args) {
        
        int[] pots = {10,5,45,9,32,50,60,78,95,15};
        int j = 2;
        int i = 1;
        System.out.println("*****GNOME SORT*****");
        System.out.println("Original Sort");
        System.out.println(Arrays.toString(pots));
        for(i = 1;i < pots.length;){
            if(pots[i-1] <= pots[i]){
                i = j;
                j++;
            }
            else{
                int tmp = pots[i-1];
                pots[i-1] = pots[i];
                pots[i--] = tmp;
                //i = (i == 0) ?  j++ : i;
                if(i == 0){
                     i = j++;
                }
                else{
                    i = i;
                }
            }
        }
        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(pots));
    }
    
}
