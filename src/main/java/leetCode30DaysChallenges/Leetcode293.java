package leetCode30DaysChallenges;

import java.util.*;

public class Leetcode293 {
    public static int[] maxSlidingWindow(int[] nums, int k) {


            // assume nums is not null
            if (nums.length == 0 || k == 0) {
                return new int[0];
            }
            int n = nums.length;
            int[] result = new int[n - k + 1]; // number of windows

            PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> (o2 - o1)); // stores values

            for (int i = 0; i < n; ++i) {
                int start = i - k;
                if (start >= 0) {
                    maxPQ.remove(nums[start]); // remove the out-of-bound value
                }
                maxPQ.offer(nums[i]);
                if (maxPQ.size() == k) {
                    result[i - k + 1] = maxPQ.peek();
                }
            }
            return result;

    }

    public static void main(String[] args) {
        int array[]={1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(array,3)));
    }
}