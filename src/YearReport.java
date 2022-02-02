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

    /* Для удобного сравнения годового отчета с месячными (да и для вывода статистики) создали два HashMap, в одном будем хранить траты, а в другом доходы.
    * В последующем будем получать траты и доходы за определенный месяц по ключу-строке номера месяца */
    void sortExpensesIncomes() {
        for (String[] line : fileLine) {
            if (Boolean.parseBoolean(line[2])) {
                expenses.put(line[0], Integer.valueOf(line[1]));
            } else {
                incomes.put(line[0], Integer.valueOf(line[1]));
            }
        }
    }

    void getProfit() {
        Buh buh = new Buh(); // для использования функции получения названия месяца по номеру (почему-то не смог объявить ее в данном классе вне метода).
        for (String month : incomes.keySet()) {
            int profit = incomes.get(month) - expenses.get(month);
            Praktikum.print("Прибыль за месяц " + buh.getMonthName(month).toLowerCase() + " = " + profit);
        }
    }

    void getAverageIncome() {
        int averageIncome = 0;
        for (String month : incomes.keySet()) {
            averageIncome = averageIncome + incomes.get(month);
        }
        Praktikum.print("Средние доходы за год: " + averageIncome / incomes.size());
    }

    void getAverageExpense() {
        int averageExpense = 0;
        for (String month : expenses.keySet()) {
            averageExpense = averageExpense + expenses.get(month);
        }
        Praktikum.print("Средние расходы за год: " + averageExpense / expenses.size());
    }

    Integer getMonthIncomes(String month) {
        return incomes.get(month);
    }
    Integer getMonthExpenses(String month) {
        return expenses.get(month);
    }

}
