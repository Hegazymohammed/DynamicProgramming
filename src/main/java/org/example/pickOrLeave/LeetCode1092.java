package org.example.pickOrLeave;

import java.util.Arrays;
import java.util.List;

public class LeetCode1092 {
    private String str1;
    private String str2;
    StringBuilder sub=new StringBuilder();
    private int memo[][]=new int[1001][1001];

    public String shortestCommonSupersequence(String str1, String str2) {
        //first i need to find the longest sub sequence the two strings
        //then return the common sub sequence
        //compare the subsequence with the minimum str
        //add the difference in stringBuilder
        //return result
        this.str1=str1;
        this.str2=str2;
        for(int[]row:memo)
            Arrays.fill(row,-1);
          lcs(0,0);
          return sub.toString();
    }

    private int  lcs(int index1,int index2){
        if(index1==str1.length()||index2==str2.length())
            return 0;
         if(memo[index1][index2]!=-1)
            return memo[index1][index2];
        if(str1.charAt(index1)==str2.charAt(index2)){
            sub.append(str1.charAt(index1));
            return memo[index1][index2]=1+lcs(index1+1,index2+1);
        }

        int choice1=lcs(index1,index2+1);
        int choice2=lcs(index1+1,index2 );
        return memo[index1][index2]=Math.min(choice1,choice2);

    }

    public static void main(String[] args) {
        LeetCode1092 sol=new LeetCode1092();
        System.out.println(sol.shortestCommonSupersequence("abac","cab"));
        System.out.println(sol.sub.toString());
         int[]numbers={1,2,3,4,5};

        int value=Arrays.stream(numbers).reduce(Integer::sum).getAsInt();
    }
}