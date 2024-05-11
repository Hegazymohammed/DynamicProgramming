package leetCode30DaysChallenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>list=new ArrayList<>();
        int length=nums.length;
        for(int i=0;i<length-2;++i){
            int target=nums[i];
            if(i>0&& nums[i-1]==target)
                 continue;
                int left=i+1;
                int right=length-1;
                while(left<right){
                    int sum=nums[left]+nums[right]+target;
                    if(sum==0) {
                        list.add(List.of(nums[left], nums[right], target));
                        while(left<right&&nums[left]==nums[left-1])left++;
                        left++;
                        while(left<right&&nums[right]==nums[right-1])right--;
                        right--;
                    }

                    else if(sum<0)
                         left++;
                    else right--;
                }

        }
        return  list;
    }



    public static void main(String[] args) {
        int array[]={1,-1,-1,0};
        Leetcode15 sol=new Leetcode15();
        System.out.println(sol.threeSum(array));
    }
}
