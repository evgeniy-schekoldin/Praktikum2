import java.util.Scanner;

public class Praktikum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        Buh buh = new Buh();

        printMenu();
        while (true) {
            print("Команда: ");
            userInput = scanner.nextInt();
            if (userInput == 0) {
                break;
            } else if (userInput == 1) {
                buh.readMonthReports();
            } else if (userInput == 2) {
                buh.readYearReport();
            } else if (userInput == 3) {
                buh.checkReport();
            } else if (userInput == 4) {
                buh.printMonthReports();
            } else if (userInput == 5) {
                buh.printYearReports();
            }
            printMenu();
        }
    }

    private static void printMenu() {
        print("---");
        print("1. Считать файлы месячных отчетов");
        print("2. Считать файл годового отчета");
        print("3. Сверить месячные отчеты с годовым");
        print("4. Печать отчета по месяцам");
        print("5. Печать годового отчета");
        print("0. Выход");
    }

    public static void print(String message) {
        System.out.println(message);
    }

}
