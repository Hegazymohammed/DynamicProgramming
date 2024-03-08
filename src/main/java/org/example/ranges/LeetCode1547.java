package org.example.ranges;

import java.util.Arrays;

public class LeetCode1547 {
    int memo[][];
    int array[];

    public int minCost(int n, int[] cuts) {
         array=new int[cuts.length+2];
         int number=0;
         array[number++]=0;
         array[number++]=n;
         for(int value:cuts)
             array[number++]=value;
         Arrays.sort(array);
         int length=array.length;
         memo=new int[length+1][length+1];
        Arrays.stream(memo).forEach(row-> Arrays.fill(row,-1));

        Arrays.sort(array);
        return cut(0,array.length-1);

    }


    private int cut(int start,int end){

        if(start+1==end)
            return 0;
        int result=memo[start][end];
        if(-1!=result)
            return result;
        result=Integer.MAX_VALUE;

        for (int split = start + 1; split < end; split++) {
            int left = cut(start, split);
            int right = cut(split, end);
            int cut_cost = array[end] -array[start];
            result = Math.min(result, left + right + cut_cost);
        }

        memo[start][end]=result;
        return result;
    }

    public static void main(String[] args) {
        LeetCode1547 sol=new LeetCode1547();
        System.out.println(sol.minCost(9,new int[]{5,6,1,4,2}));
    }
}
