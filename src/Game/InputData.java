package Game;

import java.util.Scanner;

public class InputData {

    static double moneyBet;
    static int winNum;
    static double gain;
    static double resParseDouble;

    static Scanner sc = new Scanner(System.in);
    static Calc calc;

    static Protect protect = new Protect();

    public static void dataEntry() {
        moneyBet = setBet();

        if (moneyBet != 0) {
            calc = new Calc(moneyBet);
            takeWinNumer();
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void takeWinNumer() {

        System.out.println("Витягнути випадковий білет?(1-Так/0-Вихід)");
        String dataIn = sc.nextLine().trim();
        int num = 0;
        boolean numNoNum = protect.checkNumber(dataIn);

        if (numNoNum) {
            num = (int) resParseDouble;


            switch (num) {

                case 0:
                    sc.close();
                    break;
                case 1: {
                    winNum = (int) (Math.random() * 10);

                    gain = calc.calcGain(winNum);

                    if (gain != 0) {

                        System.out.printf("Ви витягнули білет №%d. Ваш виграш = %.2f грн. " +
                                "%nБажаєте зробити ще одну ставку?(1-Так/0-Ні) ", winNum, gain);


                        addBet();
                        /*dataIn = sc.nextLine().trim();
                        //double res = 0;
                        numNoNum = protect.checkNumber(dataIn);
                        if (numNoNum) {
                            //res = Double.parseDouble(dataIn);
                            if (resParseDouble == 0) sc.close();
                            else if (resParseDouble == 1) dataEntry();
                        }*/
                    } else {
                        System.out.println("\nВи програли! \nБажаєте зробити ще одну ставку?(1-Так/0-Ні)");
                        addBet();
                    }
                    break;
                }
            }
        } else
            scanerClose();
    }

    //------------------------------------------------------------------------------------------------------------------
    private static double setBet() {
        //ouble bet = 0;

        System.out.println("\n*** 0 - Вихід ***\nВведіть свою ставку:");
        String textIn = sc.nextLine().trim();

        boolean numNoNum = protect.checkNumber(textIn);

        if (numNoNum) {
            //bet = Double.parseDouble(textIn);
            //bet = resParseDouble;
            if (resParseDouble == 0) sc.close();
        } else
            scanerClose();


        return resParseDouble;
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void scanerClose() {
        System.out.println("\nВвели не число!");
        sc.close();
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void addBet() {
        String dataIn = sc.nextLine().trim();

        if (protect.checkNumber(dataIn)) {
            if (resParseDouble == 0) sc.close();
            else if (resParseDouble == 1) dataEntry();
        }

    }
    //------------------------------------------------------------------------------------------------------------------
}
