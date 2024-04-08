package leetCode30DaysChallenges;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1700 {
    public  static int countStudents(int[] students, int[] sandwiches) {
         int result=students.length;
         Map<Integer,Integer> map=new HashMap<>();
          for(Integer student:students){
                if(!map.containsKey(student))
                    map.put (student,0);
                map.put( student,map.get(student)+1  );
          }

          for(int sandwish :sandwiches){
              int value=map.getOrDefault(sandwish,0);
              if(value>0){
                  map.put(sandwish,value-1);
                  result-=1;
              }
                  else
                      return result;
          }
          return result;
    }

    public static void main(String[] args) {


    }
}
