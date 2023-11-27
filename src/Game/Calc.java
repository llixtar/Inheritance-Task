package Game;

public class Calc extends InputData {
    //static double moneyBet;
    static double deductions;

    public static double calcGain(int winNum) {

        if (winNum == 0)
            return 0;
        else if (winNum > 0 && winNum <= 3) {
            return calcDeductions(125, moneyBet);

        } else if (winNum > 3 && winNum <= 7) {
            deductions = calcDeductions(5, moneyBet);
            return calcDeductions(125, moneyBet) - deductions;

        } else {
            moneyBet = moneyBet * 2;
            deductions = calcDeductions(10, moneyBet);
            return moneyBet - deductions;
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    private static double calcDeductions(int perCent, double moneyBet) {
        return (moneyBet * perCent) / 100;
    }

    //------------------------------------------------------------------------------------------------------------------
    protected Calc(double moneyBet) {
        this.moneyBet = moneyBet;
    }
}
