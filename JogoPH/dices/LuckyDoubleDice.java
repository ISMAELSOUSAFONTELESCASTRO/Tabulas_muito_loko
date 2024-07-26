package dices;
import visual.*;

public class LuckyDoubleDice extends DoubleDice {
    /*Iniciando esta classe filha*/
    public LuckyDoubleDice(){
        super();
    }

    @Override public int ThrowDices(){
        int sum = ThrowDice(1) + ThrowDice(2);
        if (sum < 7) {
            sum += 6;
            if(sum != 12) {
                if (sum % 2 == 0) {
                    dice1 = (sum / 2) + 1;
                    dice2 = (sum / 2) - 1;
                } else {
                    dice1 = ((sum + 1) / 2);
                    dice2 = ((sum + 1) / 2) - 1;
                }
            }
            else{
                dice1 = 6;
                dice2 = 6;
            }
        }
        Visual.addDados(dice1, dice2);
        return sum;
    }
}
