import java.util.Scanner;

public class Praktikum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        Buh buh = new Buh();

        printMenu();
        while (true) {

            System.out.println("Команда: ");
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
        System.out.println("---");
        System.out.println("1. Считать файлы месячных отчетов");
        System.out.println("2. Считать файл годового отчета");
        System.out.println("3. Сверить месячные отчеты с годовым");
        System.out.println("4. Печать отчета по месяцам");
        System.out.println("5. Печать годового отчета");
        System.out.println("0. Выход");
    }

}
