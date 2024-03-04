package org.example.pickOrLeave.easyProplems;

import java.util.Arrays;

public class LeetCode583 {
    String str1;
    String str2;
    int memo[][] = new int[5001][5001];
    int count=0;
    public int minDistance(String word1, String word2) {
        str1 = word1;
        str2 = word2;
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return lcs(0, 0);
    }

    private int lcs(int index1, int index2) {
        count+=1;
        if (index1 == str1.length())
            return str2.length() - index2;
        if (index2 == str2.length())
            return str1.length() - index1;

        int result = memo[index1][index2];
        if (result != -1)
            return result;
        result = 0;
        if (str1.charAt(index1) != str2.charAt(index2)) {
            int choice1 = 1 + lcs(index1, index2 + 1);
            int choice2 = 1 + lcs(index1 + 1, index2);
            result = Math.min(choice1, choice2);
            setInMemo(index1, index2, result);
            return result;
        } else {
            result = lcs(index1 + 1, index2 + 1);
            setInMemo(index1, index2, result);
            System.out.println(result);
            return result;

        }

    }

    private void setInMemo(int row, int column, int value) {
        memo[row][column] = value;
    }
    public static void main(String[] args) {
        LeetCode583 e=new LeetCode583();
        System.out.println(e.minDistance("teacher","techier"));
        System.out.println(e.count);
    }
}
