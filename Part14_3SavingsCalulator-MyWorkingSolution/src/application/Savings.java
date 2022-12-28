package application;
import java.util.HashMap;
import java.util.Map;
public class Savings {
    private double savingsAmount;
    private double interestRate;
    private Map<Integer, Double> savingsOverTime;
    private Map<Integer, Double> savingsWithInterestOverTime;
    public Savings() {
        this.savingsAmount = 25.0;
        this.interestRate = 0.0;
        this.savingsOverTime = new HashMap<>();
        this.savingsWithInterestOverTime = new HashMap<>();

        this.calculateSavings();
        this.calculateSavingsWithInterest();
    }

    public double getSavingsAmount() {
        return savingsAmount;
    }

    public void setSavingsAmount(double savingsAmount) {
        this.savingsAmount = savingsAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public Map<Integer, Double> getSavingsOverTime() {
        return savingsOverTime;
    }

    public Map<Integer, Double> getSavingsWithInterestOverTime() {
        return savingsWithInterestOverTime;
    }

    public void calculateSavings() {
        for (int i = 0; i < 31; i++) {
            double savingsPerYear = (this.savingsAmount * 12) * i;
            savingsOverTime.put(i, savingsPerYear);
        }
    }
    public void calculateSavingsWithInterest() {
        double runningInterest = 0;
        double interestRate = (this.interestRate / 100) + 1;
        for (int i = 0; i < 31; i++) {
            double currentYearSavings = (this.savingsAmount * 12) * i;
            double compoundTotal = currentYearSavings + runningInterest;
            double interestAdded = compoundTotal * (this.interestRate / 100);
            double actualYearSavings = compoundTotal + interestAdded;
            runningInterest += interestAdded;
            savingsWithInterestOverTime.put(i, actualYearSavings);
        }
    }
}
