package org.example.editDistance;

public class IntegerBreak {

   static int productSum(int n){
        if(n==1)
                return 1;
        int result=n;
        for(int i=1;i<n;++i){
            result=Math.max(result,i*productSum(n-i));
            System.out.println(i+" "+result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(productSum(5));
    }
}
