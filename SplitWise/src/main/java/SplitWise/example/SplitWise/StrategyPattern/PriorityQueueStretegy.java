package SplitWise.example.SplitWise.StrategyPattern;

import SplitWise.example.SplitWise.dto.UserAmount;
import SplitWise.example.SplitWise.models.*;

import java.util.*;

public class PriorityQueueStretegy implements SettlementStretegy{
    @Override
    public List<SettleMentTranscation> CalculateMinTranscation(List<Expense>expenses) {

        HashMap<User,Long>ans=extractExpanse(expenses);

        Comparator<UserAmount>minComparator=Comparator.
                comparingLong(UserAmount::getAmount);
        Comparator<UserAmount>maxComparator=Comparator.
                comparingLong(UserAmount::getAmount).
                reversed();


        PriorityQueue<UserAmount>minHeap=new PriorityQueue<>(minComparator);
        PriorityQueue<UserAmount>maxHeap=new PriorityQueue<>(maxComparator);
        for(Map.Entry<User,Long>entry: ans.entrySet())
        {
            if(entry.getValue()>0)
            {
                maxHeap.add(new UserAmount(entry.getKey(),entry.getValue()));
            }
            else if(entry.getValue()<0)
            {
                minHeap.add(new UserAmount(entry.getKey(), entry.getValue()));
            }
        }

        List<SettleMentTranscation>minTranscation=new ArrayList<>();

        while (maxHeap.size()!=0 && minHeap.size()!=0)
        {
            UserAmount Landor=maxHeap.remove();
            UserAmount barrower=minHeap.remove();
            if(Math.abs(barrower.getAmount())== Landor.getAmount())
            {
                  minTranscation.add(new
                          SettleMentTranscation(barrower.getUser(),
                          Landor.getUser(),barrower.getAmount()));
            }
            else if (Math.abs(barrower.getAmount())<Landor.getAmount()) {

                 Landor.setAmount(Landor.getAmount()+ barrower.getAmount());
                 maxHeap.add(Landor);
                 minTranscation.add(new SettleMentTranscation(barrower.getUser(),Landor.getUser(),
                         barrower.getAmount()));
            }
            else if (Math.abs(barrower.getAmount())>Landor.getAmount()) {
                barrower.setAmount(barrower.getAmount()+ Landor.getAmount());
                minHeap.add(barrower);
                minTranscation.add(new SettleMentTranscation(barrower.getUser(), Landor.getUser(),
                        barrower.getAmount()));
            }


        }
        //barrower=-500 Landor=1000
        //Landor=500  Barrower=1000

     return minTranscation;

    }
    public HashMap<User,Long> extractExpanse(List<Expense>expenses)
    {
        HashMap<User,Long>expenseMap=new HashMap<>();

        for(Expense expense:expenses)
        {
            for(UserExpense userExpense:expense.getUserExpenses())
            {
                if(expenseMap.containsKey(userExpense.getUserName()))
                {
                    if(userExpense.getTypeOfExpense().equals(TypeOfExpense.WHO_PAID))
                    {
                        expenseMap.put(userExpense.getUserName(),
                                expenseMap.get(userExpense.getUserName())+userExpense.getAmount()
                                );
                    }
                    else if(userExpense.getTypeOfExpense().equals(TypeOfExpense.WHO_OWN_PAID))
                    {
                        expenseMap.put(userExpense.getUserName(),
                                expenseMap.get(userExpense.getUserName())-
                                        userExpense.getAmount());
                    }

                }
                else {
                    if(userExpense.getTypeOfExpense().equals(TypeOfExpense.WHO_PAID))
                    {
                        expenseMap.put(userExpense.getUserName(),
                                0+userExpense.getAmount());
                    } else if(userExpense.getTypeOfExpense().equals(TypeOfExpense.WHO_OWN_PAID)) {
                         expenseMap.put(userExpense.getUserName(),0- userExpense.getAmount());
                    }
                }
            }
        }
        return expenseMap;
    }
}
