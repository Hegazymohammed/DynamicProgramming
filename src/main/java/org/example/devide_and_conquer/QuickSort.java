package org.example.devide_and_conquer;


import java.util.Arrays;

public class QuickSort {

    private void quickSort(int[]array,int start,int end){
        if(start>=end)
            return;
        int pivot=makePivot(array,start,end);
        quickSort(array,start,pivot-1);
        quickSort(array,pivot+1,end);
    }

    private int makePivot(int array[],int start,int end){
          int middle=start+(end-start)/2;
          int count=0;
        for (int i = start; i <=end ; i++) {
                if(array[i]<array[middle])
                     count++;
        }
        int pivotIndex=count+start;
        swap(array, pivotIndex ,  middle);

        for(int s=start,e=end;s<middle&&e>middle;){
            int pivot=array[pivotIndex];
            while (array[s]<pivot)s++;
            while(array[e]>pivot)e--;
            swap(array,s,e);
        }
        return pivotIndex;
    }

    private void swap(int []array ,int first,int second){
            int temp=array[first];
            array[first]=array[second];
            array[second]=temp;
    }

    public void quickSort(int array[]){
        quickSort(array,0,array.length-1);
    }

    public static void main(String[] args) {
        int array[]={5,2,4,3,-1,2};
         QuickSort sort=new QuickSort();
         sort.quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
