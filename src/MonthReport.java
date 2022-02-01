import java.util.ArrayList;

public class MonthReport {
    String monthNum;
    ArrayList<String[]> fileLine = new ArrayList<>();

    void addString(String itemName, String isExpense, String quantity, String sumOfOne) {
        String[] line = new String[4];
        line[0] = itemName;
        line[1] = isExpense;
        line[2] = quantity;
        line[3] = sumOfOne.trim();
        fileLine.add(line);
    }

    void printMostProfitItem() {
        int maxProfit = 0;
        String profitItem = "";
        for (String[] line : fileLine) {
            if (Boolean.parseBoolean(line[1])) {
                int profit = Integer.parseInt(line[3]) * Integer.parseInt(line[2]);
                if (maxProfit < profit) {
                    maxProfit = profit;
                    profitItem = line[0];
                }
            }
        }
        System.out.println("Максимальный прибыльный товар: " + profitItem);
    }

    void printMaxExpense() {
        int maxExpense = 0;
        for (String[] line : fileLine) {
            if (Boolean.parseBoolean(line[1])) {
                int expense = Integer.parseInt(line[3]) * Integer.parseInt(line[2]);
                if (maxExpense < expense) {
                    maxExpense = expense;
                }
            }
        }
        System.out.println("Максимальная трата в месяце " + maxExpense);
    }


    Integer getExpenses() {
        int monthExpenses = 0;
        for (String[] line : fileLine) {
            if (Boolean.parseBoolean(line[1])) {
                monthExpenses = monthExpenses + Integer.parseInt(line[3]) * Integer.parseInt(line[2]);
            }
        }
        return monthExpenses;

    }

    Integer getIncomes() {
        int monthIncomes = 0;
        for (String[] line : fileLine) {
            if (!Boolean.parseBoolean(line[1])) {
                monthIncomes = monthIncomes + Integer.parseInt(line[3]) * Integer.parseInt(line[2]);
            }
        }
        return monthIncomes;
    }

}
