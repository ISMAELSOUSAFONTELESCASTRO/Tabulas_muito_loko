package dices;
import visual.*;

public class MisfortuneDoubleDice extends DoubleDice {
    /*Iniciando esta classe filha*/
    public MisfortuneDoubleDice(){
        super();
    }

    @Override public int ThrowDices(){
        int sum = ThrowDice(1) + ThrowDice(2);
        if (sum > 6) {
            sum -= 6;
            if(sum != 1) {
                if (sum % 2 == 0) {
                    dice1 = (sum / 2) + 1;
                    dice2 = (sum / 2) - 1;
                } else {
                    dice1 = ((sum + 1) / 2);
                    dice2 = ((sum + 1) / 2) - 1;
                }
            }
            else{
                dice1 = 1;
                dice2 = 2;
                sum = 3;
            }
        }
        Visual.addDados(dice1, dice2);
        return sum;
    }
}
