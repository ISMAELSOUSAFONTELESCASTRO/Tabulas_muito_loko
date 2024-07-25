package dices;
import java.util.Random; //bibliotéca de números aleatórios
import visual.*;

public class DoubleDice {
    protected Random rdm; //objetico que cria números aleatórios
    protected int dice1;
    protected int dice2;

    /*Iniciando Dado Duplo*/
    public DoubleDice(){
        this.rdm = new Random();
        this.dice1 = 0;
        this.dice2 = 0;
    }

    public int ThrowDice(int dice) {
        if(dice == 1) {
            dice1 = rdm.nextInt(6) + 1;
            return dice1;
        }
        else if(dice == 2) {
            dice2 = rdm.nextInt(6) + 1;
            return dice2;
        }
        else {
            return 0;
        }
    }

    /*Jogando os dados*/
    public int ThrowDices(){
        int sum = ThrowDice(1) + ThrowDice(2); //Dados Normais, vão de 2 a 12
        Visual.addDados(dice1, dice2);
        return sum;
    }

    public boolean DicesAreEqual() {
        if(dice1 == dice2 && dice1 != 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
