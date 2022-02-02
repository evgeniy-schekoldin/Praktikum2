public class Test {

    String[][] test;

    Test(int lines) {
        test = new String[lines][4];
    }

    void addLines(int line, String itemName, String isExpense, String quantity, String sumOfOne) {
        test[line][0] = itemName;
        test[line][1] = isExpense;
        test[line][2] = quantity;
        test[line][3] = sumOfOne;
    }

    void printArray() { // для проверки что все корректно занеслось в наш 2D-массив
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i][0] + ", ");
            Praktikum.print(test[i][1] + ", ");
            Praktikum.print(test[i][2] + ", ");
            Praktikum.print(test[i][3]);
            Praktikum.print("");
        }
        Praktikum.print("");
    }

}
