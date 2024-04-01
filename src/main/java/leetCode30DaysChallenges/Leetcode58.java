package leetCode30DaysChallenges;

public class Leetcode58 {
    public int lengthOfLastWord(String s) {
        String[]result=s.trim().split(" ");
        return result[result.length-1].length();
    }
}
