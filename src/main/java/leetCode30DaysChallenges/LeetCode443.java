package leetCode30DaysChallenges;

import java.util.Arrays;

public class LeetCode443 {


        public int compress(char[] chars) {
            int i = 0, res = 0;
            while (i < chars.length) {
                int groupLength = 1;
                while (i + groupLength < chars.length && chars[i + groupLength] == chars[i]) {
                    groupLength++;
                }
                chars[res++] = chars[i];
                if (groupLength > 1) {
                    for (char c : Integer.toString(groupLength).toCharArray()) {
                        chars[res++] = c;
                    }
                }
                i += groupLength;
            }
            return res;
        }


    public static void main(String[] args) {
        LeetCode443 sol=new LeetCode443();
        char[]chars=new char[]{'a','a','a','b','b','a','a'};
        System.out.println(sol.compress(chars));
        System.out.println(Arrays.toString(chars));

    }

}
