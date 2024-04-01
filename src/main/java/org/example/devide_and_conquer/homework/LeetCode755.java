package org.example.devide_and_conquer.homework;




public class LeetCode755 {
    private int globalInversion=0;
    public boolean isIdealPermutation(int[] nums)
    {
        //get the local inversion nums[i]>nums[i+1]
        int localInversion=0;
        for (int i = 0; i < nums.length-1; i++)
                if(nums[i]>nums[i+1])localInversion++;
         quickSort(0,nums.length-1,nums);
         return globalInversion==localInversion;
    }

    private void quickSort(int start,int end,int array[] ){
            if(start>=end)
                    return;
            int pivot=makePivot(array,start,end );
            quickSort(start,pivot-1,array );
            quickSort(pivot+1,end,array);

    }

    private int makePivot(int[] array, int start, int end){
        int middle=start+(end-start)/2;
        int count=0;
        for (int i = start; i <=end ; i++) {
            if(array[i]<array[middle])
                count++;
        }
        int pivotIndex=count+start;
        swap(  pivotIndex ,middle,array);

        for(int s=start,e=end;s<middle&&e>middle;){
            int pivot=array[pivotIndex];
            while (array[s]<pivot)s++;
            while(array[e]>pivot){e--;globalInversion++;}
            swap( s,e,array);
        }
        return pivotIndex;
    }

    private void swap(int start, int end, int[] array) {
          int temp=array[start];
          array[start]=array[end];
          array[end]=temp;
    }

    public static void main(String[] args) {
        LeetCode755 sol=new LeetCode755();
        System.out.println(sol.isIdealPermutation(new int[]{1,0,2}));
    }
}
