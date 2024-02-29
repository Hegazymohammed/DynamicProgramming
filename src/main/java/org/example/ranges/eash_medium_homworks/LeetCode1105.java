package org.example.ranges.eash_medium_homworks;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class LeetCode1105 {


    int memory[] ;
    int shelfWidth;
    int[][]books;
    private final int MAX_VALUE=1001;
    public int minHeightShelves(int[][] books, int shelfWidth) {
            memory=new int[MAX_VALUE] ;

                Arrays.fill(memory,-1);
            this.books=books;
            this.shelfWidth=shelfWidth;
            return rangeProplem(0   );
    }
    private int  rangeProplem(int index){
            if(index>=books.length)
                return 0;
            int result=getFromMemory(index);
            if(result!=-1)
                return result;

             result=Integer.MAX_VALUE;
             int width=0,height=0;
        for (int k = index; k < (int) books.length; k++) {
             width += books[k][0];
            height = max( height, books[k][1]);

            if ( width > shelfWidth)
                break;
            result = min(result,  height +rangeProplem(k + 1));
            setInMemory(index,result);
        }
        return result;

    }

    private void setInMemory(int row ,int result){
          memory[row] =result;
    }

    private int getFromMemory( int column){
        return memory [column];
    }


    private static String hashWithSHA512(String input){
        StringBuilder builder=new StringBuilder();
        try{
            MessageDigest md=MessageDigest.getInstance("SHA-512");
            System.out.println(md );
            byte[]digested=md.digest(input.getBytes());
            System.out.println(digested.length);
            for (int i = 0; i < digested.length; i++) {
                builder.append(Integer.toHexString(0xff& digested[i]));
            }
        }
        catch (NoSuchAlgorithmException exception){
            exception.printStackTrace();
        }
       return  builder.toString();
    }
    public static void main(String[] args) {
        System.out.println(hashWithSHA512("hegazy"));
    }
}
