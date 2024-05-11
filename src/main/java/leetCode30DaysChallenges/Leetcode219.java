package leetCode30DaysChallenges;

import java.util.Set;
import java.util.TreeSet;

public class Leetcode219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set=new TreeSet<>( );
        //o(nLog(n))
        for(int i=0;i<nums.length;++i){
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if(set.size()>k)
                set.remove(nums[i-k]);


        }
        return false;
    }

      int longestOnes(int []array,int k){
         int len=0;
          for (int start = 0,end=0,zero=0; end<array.length;end++) {
                if(array[end]==0){
                    zero++;
                    while (zero>k){
                        if(array[start]==0)
                            zero-=1;
                        start+=1;
                    }
                }
                len=Math.max(len,end-start+1);
          }
          return len;
      }


    public static void main(String[] args) {

        System.out.println(containsNearbyDuplicate(new int[]{1,2,1},0));
    }
}
