package SplitWise.example.SplitWise.StrategyPattern;

import SplitWise.example.SplitWise.models.Expense;
import SplitWise.example.SplitWise.models.SettleMentTranscation;

import java.util.List;

public interface SettlementStretegy {
    List<SettleMentTranscation> CalculateMinTranscation(List<Expense> expenses);
}
