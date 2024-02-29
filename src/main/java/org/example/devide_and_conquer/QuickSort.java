package org.example.devide_and_conquer;



public class QuickSort {

    public void quickSort(int[]array,int start,int end){
        if(start>=end)
            return;
        int pivot=makePivot(array,start,end);
        quickSort(array,start,pivot-1);
        quickSort(array,pivot+1,end);
    }

    private int makePivot(int[] array, int start, int end) {
            int middle=(start+end)/2;
            int pivot=array[middle];
            int count=0;
        for (int i = start; i < end; i++)
                if(array[i]>pivot)
                    count++;

        int pvoitIndex=start+count;
        int temp=pivot;
        pivot=array[pvoitIndex];
        array[pvoitIndex]=temp;
        for (int s = start, e = end; s < pvoitIndex && e > pvoitIndex; s += 1, e -= 1) {
            while (array[s] < pivot)	// Find first value > pivot
                s += 1;		// tip loop must break worst at pivot_idx

            while (array[e] > pivot)	// Find last value <= pivot
                e -= 1;

            if (s < pvoitIndex && e > pvoitIndex)
                swap (array,s,e);
        }
        return pvoitIndex;
    }

    void swap(int array[],int s,int end){
            int temp=array[s];
            array[s]=array[end];
            array[end]=temp;
    }
}
