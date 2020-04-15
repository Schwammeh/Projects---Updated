package mergesort;

import java.util.*;

public class MergeSort {

    public static void main(String[] args) {
        
        Random rand = new Random();
        int m = 100;
        int[] seq = new int[m];
        
        for(int i = 0;i < m;i++){
            seq[i] = Math.abs(rand.nextInt(100)+1);
        }
        
        System.out.println("Initial array: ");
        printArray(seq);
        
        System.out.print("\nAscending");
        seq = mergeSort(seq);
        System.out.println("");
        printArray(seq);
        
        System.out.print("\nDescending");
        seq = mergeSortDes(seq);
        System.out.println("");
        printArray(seq);
        
    }
    public static void printArray(int[] array){
        for(int i: array){
            System.out.println(i + " ");
        }
        System.out.println("");
    }
    
    private static int[] mergeSort(int[] array){
        if(array.length <= 1){
            
            return array;
        }
        
        int midpoint = array.length/2;
        
        int[] left = new int[midpoint];
        int[] right;
        
        if(array.length % 2 == 0){
            right = new int[midpoint];
        }
        else{
            right = new int[midpoint + 1];
        }
        
        for(int i = 0;i < midpoint;i++){          
            left[i] = array[i];
        }
        for(int j = 0;j < right.length;j++){
            right[j] = array[midpoint + j];
        }
        int[] result = new int[array.length];
        int[] result2 =new int[array.length];
        
        left = mergeSort(left);
        right = mergeSort(right);
        
        result = merge(left,right);
        
        return result;
    
    }
    private static int[] merge(int[] left,int[] right){
        
        int[] result = new int[left.length + right.length];
        int leftPointer,rightPointer,resultPointer;
        leftPointer = rightPointer = resultPointer = 0;
        
        while(leftPointer < left.length || rightPointer < right.length){
            
            if(leftPointer < left.length && rightPointer < right.length){
                
                if(left[leftPointer] < right[rightPointer]){
                    
                    result[resultPointer++] = left[leftPointer++];
                    
                }
                else{
                    
                    result[resultPointer++] = right[rightPointer++];
                    
                }
                
            }
            else if(leftPointer < left.length){
                result[resultPointer++] = left[leftPointer++];
            }
            else if(rightPointer < right.length){
                result[resultPointer++] = right[rightPointer++];
            }
            
        }
        return result;     
    }
    
    private static int[] mergeSortDes(int[] array){
        if(array.length <= 1){
            
            return array;
        }
        
        int midpoint = array.length/2;
        
        int[] right = new int[midpoint];
        int[] left;
        
        if(array.length % 2 == 0){
            left = new int[midpoint];
        }
        else{
            left = new int[midpoint + 1];
        }
        
        for(int i = 0;i < midpoint;i++){          
            right[i] = array[i];
        }
        for(int j = 0;j < left.length;j++){
            left[j] = array[midpoint + j];
        }
        int[] result = new int[array.length];
        
        left = mergeSortDes(left);
        right = mergeSortDes(right);
        
        result = mergeDes(right,left);
        
        return result;
    
    }
        private static int[] mergeDes(int[] left,int[] right){
        
        int[] result = new int[left.length + right.length];
        int leftPointer,rightPointer,resultPointer;
        leftPointer = rightPointer = resultPointer = 0;
        
        while(leftPointer < left.length || rightPointer < right.length){
            
            if(leftPointer < left.length && rightPointer < right.length){
                
                if(left[leftPointer] > right[rightPointer]){
                    
                    result[resultPointer++] = left[leftPointer++];
                    
                }
                else{
                    
                    result[resultPointer++] = right[rightPointer++];
                    
                }
                
            }
            else if(leftPointer < left.length){
                result[resultPointer++] = left[leftPointer++];
            }
            else if(rightPointer < right.length){
                result[resultPointer++] = right[rightPointer++];
            }
            
        }
        return result;     
    }
 
}