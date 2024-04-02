package leetCode30DaysChallenges;

import java.util.*;

public class LeetCode205 {
    public static boolean isIsomorphic(String s, String t) {
        Map<Character,Character>map =new HashMap<>();


        for (int i = 0; i < s.length()  ; i++) {
            char key=s.charAt(i);
            char value=t.charAt(i);
            if(map.containsKey(key)||map.containsValue(value)) {
                Character validKey=map.get(key);
                if  (validKey==null||map.get(key) != value)
                return false;
            }
            else
                map.put(key,value);


        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc","baba"));

    }
}
