package org.example.devide_and_conquer;

import java.util.Arrays;

public class MergeSort {
    int temp[];
    public void mergeSort(int start, int end,int array[]){
                if(start>=end)
                    return ;
                int middle=(start+end)/2;
                mergeSort(start,middle, array);
                mergeSort(middle+1,end,array );
                merge(start,end,middle,array);

    }

    void mergeSort(int []array){
        temp=new int[array.length];
        mergeSort(0,array.length-1,array);
    }

    void merge(int start,int end,int mid,int array[]){
        for(int i=start,j=mid+1,k=start;k<=end;k++){
                if(i>mid)
                    temp[k]=array[j++];
               else  if(j>end)
                    temp[k]=array[i++];
               else  if(array[i]>array[j])
                    temp[k]=array[j++];
               else
                    temp[k]=array[i++];
        }

        for (int i = start; i <=end; i++)
                array[i]=temp[i];

    }

    public static void main(String[] args) {
        int array[]={4,5445,20,3,1,2};
        MergeSort sort=new MergeSort();
        sort.mergeSort(array);
        System.out.println(  Arrays.toString(array));
    }
}
