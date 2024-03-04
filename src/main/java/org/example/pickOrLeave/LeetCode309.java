package org.example.pickOrLeave;

import java.util.Arrays;

public class LeetCode309 {
    enum State{
        NOTHING(0),
        BUY(1),
        SELL(2);


        private int value;
        State(int value){
            this.value=value;
        }
        public int value(){
            return value;
        }
    }
    class Solution {

        int array[];
        int memo[][][]=new int[5001][2][3];
        public int maxProfit(int[] prices) {
            this.array=prices;
            Arrays.stream(memo)
                    .flatMap(Arrays::stream)
                    .forEach(subArray -> Arrays.fill(subArray, -1));
            return trade(0,State.NOTHING,State.NOTHING);
        }

        private int trade(int index,State state,State lastTransaction){
            if(index==array.length)
                return 0;

            int doNothing=trade(index+1,state,lastTransaction);
            int buy=0,sell=0;

            if(State.SELL.equals(state))
                sell=array[index]+trade(index+1,State.NOTHING,State.SELL);

            else if(!State.SELL.equals(state))
                buy=-array[index]+trade(index+1,State.SELL,State.BUY);

            return memo[index][state.value()][lastTransaction.value()]=Math.max(sell,Math.max(buy,doNothing));

        }
    }
}
