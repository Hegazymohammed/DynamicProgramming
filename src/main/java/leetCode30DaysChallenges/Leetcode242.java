package leetCode30DaysChallenges;

public class Leetcode242 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return true;
        int ch []=new int[27];
        //O(l2)
        int length=s.length();
        for(int i=0;i<length;++i)
            ch[s.charAt(i)-'a']++;

        for(int index1=0;index1<length;++index1){

            int counter=0;
            for(int index2=index1+1;index2<length;++index2){
                if(t.charAt(index2)==t.charAt(index1))counter++;

            }
            if(counter!=ch[t.charAt(index1)-'a'])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode242 sol=new Leetcode242();
        System.out.println(sol.isAnagram("anagram","nagaram"));
    }
}
