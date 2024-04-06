package leetCode30DaysChallenges;

import java.util.Stack;

public class LeetCode1544 {
    public static String makeGood(String s) {
    Stack<Character> stack=new Stack<Character>( );

    for(int i=0;i<s.length();++i){
        char ch=s.charAt(i);
        if(stack.isEmpty())
            stack.push(ch);
        else if(Math.abs(stack.peek()-ch)==32)
            stack.pop();
        else
            stack.push(ch);
    }

    StringBuilder result=new StringBuilder();
    while(!stack.isEmpty())result.append(stack.pop());

    return result.reverse().toString();
}
private void print(){
    System.out.println("hello world");
}

public int print(int x){
    System.out.println(x);
        return 0;
}

        public static void main(String[] args) {
            System.out.println(LeetCode1544.makeGood("leEeetcode"));
        }
}