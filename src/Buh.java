import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Buh {

    ArrayList<MonthReport> monthReports = new ArrayList<>();
    YearReport yearReport = new YearReport();

    private String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    void readMonthReports() {
        for (int i = 1; i < 4; i++) {
            String s = readFileContentsOrNull("m.20210" + i + ".csv");
            String[] lines = s.split("\\n");
            MonthReport month = new MonthReport();
            month.monthNum = "0" + i;
            for (int line = 1; line < lines.length; line++) {
                String[] lineContents = lines[line].split(",");
                month.addString(lineContents[0], lineContents[1], lineContents[2], lineContents[3]);
            }
            monthReports.add(month);
        }
    }

    void readYearReport() {
        String s = readFileContentsOrNull("y.2021.csv");
        String[] lines = s.split("\\n");
        for (int line = 1; line < lines.length; line++) {
            String[] lineContents = lines[line].split(",");
            yearReport.addString(lineContents[0], lineContents[1], lineContents[2]);
        }
        yearReport.sortExpensesIncomes();
    }

    void checkReport() {
        for (MonthReport month : monthReports) {
            if (yearReport.getMonthIncomes(month.monthNum) != null) {
                int monthReportIncomes = month.getIncomes();
                int yearReportIncomes = yearReport.getMonthIncomes(month.monthNum);
                if (monthReportIncomes != yearReportIncomes) {
                    System.out.println("В отчете за " + getMonthName(month.monthNum).toLowerCase() + " данные не сходятся с годовым отчетом.");
                }
            }
        }
    }

    void printMonthReports() {
        for (MonthReport month : monthReports) {
            System.out.println(getMonthName(month.monthNum) + ": ");
            month.printMostProfitItem();
            month.printMaxExpense();
        }
    }

    void printYearReports() {
        yearReport.getProfit();
        yearReport.getAverageIncome();
        yearReport.getAverageExpense();
    }

    String getMonthName(String key) {
        switch (key) {
            case "01":
                return "Январь";
            case "02":
                return "Февраль";
            case "03":
                return "Март";
            default:
                return null;
        }
    }

}
