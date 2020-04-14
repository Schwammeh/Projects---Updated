package bubblesort;

import java.util.*;

public class BubbleSort {

    public static void main(String[] args) {
        
        System.out.println("Bubble sorting");
        
        Random rand = new Random();
        int m = 100;
        int[] sequ = new int[m];
        
        for(int i = 0;i < m;i++){
            sequ[i] = Math.abs(rand.nextInt(100)+1);
        }
        
        System.out.println("\nOriginal");
        printSeq(sequ);
        System.out.println("\nAscending");
        printSeq(sort(sequ,false));
        System.out.println("\nDescending");
        printSeq(sortDes(sequ,false));
    }
    public static int[] sort(int[] seq,boolean fixed){
        while(fixed == false){
            fixed = true;
            for(int i = 0;i < seq.length;i++){
                for(int j = 0;j < seq.length-1;j++){
                    if(seq[j] > seq[j+1]){
                        seq[j] = seq[j] + seq[j+1];
                        seq[j+1] = seq[j] - seq[j+1];
                        seq[j] = seq[j] - seq[j+1];
                        fixed = false;
                    }
                }
            }
        }
        return seq;
    }
    public static int[] sortDes(int[] seq,boolean fixed){
        while(fixed == false){
            fixed = true;
            for(int i = 0;i < seq.length;i++){
                for(int j = 0;j < seq.length-1;j++){
                    if(seq[j] < seq[j+1]){
                        seq[j] = seq[j] + seq[j+1];
                        seq[j+1] = seq[j] - seq[j+1];
                        seq[j] = seq[j] - seq[j+1];
                        fixed = false;
                    }
                }
            }
        }
        return seq;
        }
    public static void printSeq(int[] sorted_sequence){
        for(int i = 0;i < sorted_sequence.length;i++){
            System.out.println(sorted_sequence[i] + "");
        }
    }
}
