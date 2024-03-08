package leetCode30DaysChallenges;

import java.util.Stack;

public class LeetCode151 {
    public String reverseWords(String s) {

        String[] str = s.trim().split("\\s+");


        StringBuilder out =new StringBuilder("");

        for (int i = str.length - 1; i > 0; i--) {

            out.append(str[i]).append(" ");
        }

        return out + str[0];
    }

    public static void main(String[] args) {
        LeetCode151 sol=new LeetCode151();
        System.out.println(sol.reverseWords(" hello world"));
        System.out.println(Integer.MAX_VALUE);
         }
}