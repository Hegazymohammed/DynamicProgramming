package org.example.devide_and_conquer;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MergeSort {
    int temp[];
    private void mergeSort(int start, int end,int array[]){
               if(start>=end)
                    return ;
               int middle= (end+start)/2;
               mergeSort(start,middle,array);
               mergeSort(middle+1,end,array);
               sort(start,middle,end,array);

    }

    private void sort(int start,int middle ,int end,int array[]){
        for (int i=start,j=middle+1,k=start;  k<=end ; k++) {
                    if(i>middle)
                        temp[k]=array[j++];
                    else if(j>end)
                        temp[k]=array[i++];
                    else if(array[i]>array[j])
                        temp[k]=array[j++];
                    else
                        temp[k]=array[i++];
        }
        for (int i = start; i <=end ; i++)
            array[i]=temp[i];

    }

    public void mergeSort(int array[]){
         temp= IntStream.generate(()->0).limit(array.length).toArray();
        mergeSort(0,array.length-1,array);
    }
    public static void main(String[] args) {
        int array[]={4,5445,20,3,1,2};
        MergeSort sort=new MergeSort();
        sort.mergeSort(array);
        System.out.println(  Arrays.toString(array));
    }
}
