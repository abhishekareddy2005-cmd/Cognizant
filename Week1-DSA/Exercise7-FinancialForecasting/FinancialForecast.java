public class FinancialForecast {
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if(years == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;
        double growthRate = 0.05; 
        int years = 10;

        double futureValue = calculateFutureValue(presentValue, growthRate, years);

        System.out.println("Present Value: $" + presentValue);
        System.out.println("Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Years: " + years);
        System.out.printf("Future Value after %d years: $%.2f%n", years, futureValue);

        System.out.println("\n--- Analysis ---");
        System.out.println("Time Complexity: O(n) where n is number of years");
        System.out.println("Each recursive call reduces years by 1 until it hits 0");
        System.out.println("Optimization: Can use memoization to store previous results");
        System.out.println("or simply use iterative approach to avoid stack overflow for large n");
    }
}
