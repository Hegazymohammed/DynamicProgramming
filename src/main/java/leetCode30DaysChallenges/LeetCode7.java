package leetCode30DaysChallenges;

public class LeetCode7 {
    class Solution {
        public static int reverse(int x) {
            //have x >=Integer.Max_VALUE
            // x<=Integer.MIN_VALUE
            int sign=x>0?1:-1;
            x=x<0?x*-1:x;
            long number=0;
            long multiply=10;
            while(x>0){
                number=number*multiply+(x%10) ;
                x/=10;

            }
            if(sign==-1)
                return  -1*number>Integer.MIN_VALUE?(int)number*-1:0;

            return   number<Integer.MAX_VALUE?(int)number:0;

        }

    }


}
