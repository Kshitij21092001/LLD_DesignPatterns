package Splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimplifyDebtAlgorithm {
    //transaction 2D array has 3 elements
    //From, to, amount
    public int minTransfers(int [][] transactions){
        Map<Integer,Integer> memberVsBalanceMap=new HashMap<>();

        for(int[] transaction:transactions){
            int from=transaction[0];
            int to=transaction[1];
            int amount=transaction[2];
            memberVsBalanceMap.put(from,memberVsBalanceMap.getOrDefault(from,0)-amount);
            memberVsBalanceMap.put(to,memberVsBalanceMap.getOrDefault(to,0)+amount);
        }

        List<Integer> balance=new ArrayList<>();
        for(int amount:memberVsBalanceMap.values()){
            if(amount!=0){
                balance.add(amount);
            }
        }

        return dfs(balance,0);
    }

    private int dfs(List<Integer> balance,int currentIndex){
        if(balance.isEmpty() || currentIndex>=balance.size()){
            return 0;
        }

        if(balance.get(currentIndex)==0){
            return dfs(balance,currentIndex+1);
        }

        int currentVal=balance.get(currentIndex);
        int minTransaction=Integer.MAX_VALUE;

        for(int i=currentIndex+1;i<balance.size();i++){
            int nextValue=balance.get(i);
            if(currentVal*nextValue<0){
                balance.set(i,currentVal+nextValue);
                minTransaction=Math.min(minTransaction,dfs(balance,currentIndex+1));
                balance.set(i,nextValue);
            }

            if(currentVal+nextValue==0){
                break;
            }
        }
        return minTransaction;
    }
}
