import java.util.ArrayList;
import java.util.HashMap;

public class YearReport {

    ArrayList<String[]> fileLine = new ArrayList<>();
    HashMap<String, Integer> expenses = new HashMap<>();
    HashMap<String, Integer> incomes = new HashMap<>();

    void addString(String month, String amount, String isExpense) {
        String[] line = new String[3];
        line[0] = month;
        line[1] = amount;
        line[2] = isExpense.trim();
        fileLine.add(line);
    }

    void sortExpensesIncomes() {
        for (String[] line : fileLine) {
            if (Boolean.valueOf(line[2]) == true) {
                expenses.put(line[0], Integer.valueOf(line[1]));
            } else {
                incomes.put(line[0], Integer.valueOf(line[1]));
            }
        }
    }

    void getProfit() {
        for (String month : incomes.keySet()) {
            int profit = incomes.get(month) - expenses.get(month);
            System.out.println("Прибыль за месяц " + month + " = " + profit);
        }
    }

    void getAverageIncome() {
        int averageIncome = 0;
        for (String month : incomes.keySet()) {
            averageIncome = averageIncome + incomes.get(month);
        }
        System.out.println("Средние доходы за год: " + averageIncome / incomes.size());
    }

    void getAverageExpense() {
        int averageExpense = 0;
        for (String month : expenses.keySet()) {
            averageExpense = averageExpense + expenses.get(month);
        }
        System.out.println("Средние расходы за год: " + averageExpense / expenses.size());
    }


    Integer getMonthIncomes(String month) {
        return incomes.get(month);
    }
    Integer getMonthExpenses(String month) {
        return expenses.get(month);
    }

}
