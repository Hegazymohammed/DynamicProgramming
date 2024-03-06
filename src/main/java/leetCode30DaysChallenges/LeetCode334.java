package leetCode30DaysChallenges;

import java.util.Arrays;

public class LeetCode334 {

    int array[];
    int memo[] ;
    public boolean increasingTriplet(int[] nums) {
        this.array=nums;
        int length=nums.length;
        memo=new int[length] ;
        Arrays.fill(memo,-1);
        int max=0;
        for(int i=0;i<length;++i){
            int cur=lis(i);
            max=Math.max(max, cur);
            if(max>=3)
                return true;

        }
        return false;
    }

    private int  lis(int index  ){
        if(index==array.length)
            return 0;

        int result=memo[index] ;
        if(result!=-1)
            return result;

        for(int i=index+1;i<array.length;++i)
            if(array[index]<array[i])
                result= Math.max(lis(i ),result);
        result+=1;
        return memo[index]=result;


    }

    public static void main(String[] args) {
        LeetCode334 sol=new LeetCode334();
        System.out.println(sol.increasingTriplet(new int[]{2,1,5,0,4,6}));
    }
}
