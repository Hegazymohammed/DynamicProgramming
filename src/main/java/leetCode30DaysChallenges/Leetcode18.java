package leetCode30DaysChallenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        long targe = (long) target;
        int length = nums.length;
        for (int first = 0; first < length - 3; ++first) {
            if (first > 0 && nums[first] == nums[first - 1])
                continue;
            for (int second = first + 1; second < length - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1])
                    continue;
                int left = second + 1;
                int right = length - 1;
                while (left < right) {
                    long sum = (long) nums[left] + nums[right] + nums[first] + nums[second];

                    if (sum > targe)
                        right--;
                    else if (sum < targe)
                        left++;
                    else {
                        list.add(List.of(nums[first], nums[second], nums[left], nums[right]));
                        left++;
                        while (left < right && nums[left] == nums[left - 1])
                            left++;
                        right--;
                        while (left < right && nums[right] == nums[right + 1])
                            right--;

                    }
                    ;

                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int array[]={1000000000,1000000000,1000000000,1000000000};
        Leetcode18 sol=new Leetcode18();
        System.out.println(sol.fourSum(array,-294967296));
    }
}
