package round;
import entities.*;
import visual.*;

public class Round {
    
    /*constants - indica as casas especiais*/
    private int[] dont_play_houses = {9,24,37};
    private int[] surprise_house = {12};
    private int[] luck_houses = {4,14,29};
    private int[] choose_to_init_houses = {16,26};
    private int[] magic_houses = {19,34};

    /*attributes*/
    private Persons player;//onde os jogadores ficarão armazenados

    /*constructor*/
    public Round(Persons person) {
        this.player = person;
    }
    // public Round() {};

    /*gets and sets*/
    public Persons getPerson() {
        return player;
    }
    public void setPerson(Persons person) {
        this.player = person;
    }

    /*methods*/

    private boolean IsIn(int number, int[] arr) {
        for(int element : arr) {
            if(number == element) {
                return true;
            }
        }
        return false;
    }

    public void makeRound() {//onde o jogador fará sua jogada.
        player.rollDice();//joga dado
        player.walk();//anda
        int house = player.getHouse();
        player.setDont_play(IsIn(house, this.dont_play_houses));
        player.setSurprise(IsIn(house, this.surprise_house));
        player.setLuck(IsIn(house, this.luck_houses));
        player.setMagic(IsIn(house, this.magic_houses));
        player.setChooseToInit(IsIn(house, this.choose_to_init_houses));
    }

    public void applyStatusEffects(Persons[] persons) {
        if(player.isChooseToInit()) {
            int choice = Visual.voltarUmAoInicio();
            persons[choice].setHouse(0);
            player.setChooseToInit(false);
        }
        else if(player.isMagic()) {
            /*achando o menor*/
            int smaller_value = 42;
            int pessoaAtras = 0;
            for (int i = 0; i < Visual.getValor(); i++) {
                if (persons[i].getHouse() < smaller_value) {
                    smaller_value = persons[i].getHouse();
                    pessoaAtras = i; // Atualiza a posição do menor valor encontrado
                }
            }
            if(pessoaAtras != player.getHouse()) {
                int atras = persons[pessoaAtras].getHouse();
                int frente = player.getHouse();
                Visual.trocar(player.getColor(), persons[pessoaAtras].getColor(), frente, atras);
                persons[pessoaAtras].setHouse(frente);
                player.setHouse(atras);
            }
            player.setMagic(false);
        }
        else if(player.isLuck()) {
            if(player.getType() != 'm') {
                player.setHouse(player.getHouse() + 3);//walk 3 more houses
                Visual.andar(player.getColor(), player.getHouse(), 3);
                player.setLuck(false);
            }
            else{
                player.setLuck(false);
            }
        }
        else if(player.isSurprise()) {
            player.setTypeToRandom();
            player.setSurprise(false);
        }
    }
}
