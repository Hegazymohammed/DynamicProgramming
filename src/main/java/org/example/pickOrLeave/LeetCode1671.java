package org.example.pickOrLeave;

import java.util.Arrays;

public class LeetCode1671 {
    int array[];
    int []lis;
    int []lds;
    public int minimumMountainRemovals(int[] nums) {
        int length=nums.length;
        array=nums;
        lis=new int[length];
        lds=new int[length];
        Arrays.fill(lis,-1 );
        Arrays.fill(lds,-1);
        int longest_incerasing_decreasing = 0;
        // Tip, better call the function as it handles base cases

        for (int i = 0; i < length; i++) {
            if (lisIncreasing(i) == 0 || lisDecreasing(i) == 0)
                continue;	// mountain must have 3+ values
            int cur = lisIncreasing(i) + lisDecreasing(i) ;
            longest_incerasing_decreasing = Math.max(longest_incerasing_decreasing, cur);
        }
        return length - longest_incerasing_decreasing;
    }


    private int lisIncreasing(int index){
        if(index==array.length)
            return 0;
        int result=lis[index];

        if(result!=-1)
            return result;

        result=0;

        for(int i=index+1;i<array.length;++i)
            if(array[index]<array[i])
                result=Math.max(lisIncreasing(i),result);

        result+=1;
        lis[index]=result;
        return result;

    }
    private int lisDecreasing(int index){
        if(index==-1)
            return 0;
        int result=lds[index];
        if(result!=-1)
            return result;
        result=0;
        for(int i=index-1;i>=0;--i)
            if(array[index]<array[i])
                result=Math.max(lisDecreasing(i),result);

        result+=1;
        lds[index]=result;
        return result;
    }


    public static void main(String[] args) {
        LeetCode1671 sol=new LeetCode1671();
        int array[]={2,1,1,5,6,2,3,1};
      //  int array[]={1,2,1};
        System.out.println(sol.minimumMountainRemovals(array));
    }
}