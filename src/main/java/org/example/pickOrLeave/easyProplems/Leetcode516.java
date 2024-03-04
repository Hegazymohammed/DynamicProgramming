package org.example.pickOrLeave.easyProplems;

import java.util.Arrays;

public class Leetcode516 {
    class Solution {
        private int memo[][] = new int[1001][1001];
        private String str;

        public int longestPalindromeSubseq(String s) {
            for (int row[] : memo)
                Arrays.fill(row, -1);
            this.str = s;
            int previous = str.length();

            return lcs(0, str.length() - 1);
        }

        private void setInMemory(int row, int column, int value) {
            memo[row][column] = value;
        }

        private int lcs(int index1, int index2) {
            if (index1 >= str.length() || index2 < 0 || index1 > index2)
                return 0;

            int result = memo[index1][index2];
            if (result != -1)
                return result;

            if (str.charAt(index1) == str.charAt(index2)) {
                if(index1==index2)
                    return 1;
                result = 2 + lcs(index1 + 1, index2 - 1);
                setInMemory(index1, index2, result);
                return result;
            }

            else {
                int choice1 = lcs(index1 + 1, index2);
                int choice2 = lcs(index1, index2 - 1);
                result = Math.max(choice1, choice2);
                setInMemory(index1, index2, result);
            }
            return result;
        }
    }
}
