import java.util.Stack;

public class Leetcode1614 {

        public static int maxDepth(String s) {
            int result=0;
            int max=Integer.MIN_VALUE;  ;
            int depth=0;
            Stack<Character> stack=new Stack<>();
            for(int i=0;i<s.length();++i){
                char ch=s.charAt(i);
                if(ch=='('){
                    stack.push('(');
                    depth=0;
                }
                else if(ch==')'){
                    depth+=1;
                    result=Math.max(result,depth);
                    stack.pop();
                }
            }
            if(!stack.isEmpty())result+=1;
            return result;
        }


        void applayPermutaions(int nums){

        }
    public static void main(String[] args) {
        System.out.println((int)'z'-'a');
    }
}
