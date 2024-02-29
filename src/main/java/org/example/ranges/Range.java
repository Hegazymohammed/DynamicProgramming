package org.example.ranges;



public class Range {
    private int []cost;
    private int []quantity;
    public int  bestSplit(int start){
            if(start>=quantity.length )
                return 0;

            int sum=0;
            int result=Integer.MAX_VALUE;
        for (int i  = start; i <quantity.length ; i++) {
                sum+= quantity[i];
                int totalCost=cost[i]*(sum+10);
                result=Math.min(totalCost,bestSplit(i+1));
        }
        return result;
    }
}
