package entities;
import dices.*;
import java.util.Random;
import visual.*;

public class Persons {
    private char type;
    private int house;
    private int dice_result;
    private String color;

    private boolean dont_play;
    private boolean surprise;
    private boolean luck;
    private boolean choose_to_init;
    private boolean magic;

    DoubleDice dice = new DoubleDice();

    public Persons(char t, int h, String c) {
        this.type = t;
        this.house = h;
        this.color = c;

        this.dont_play = false;
        this.surprise = false;
        this.luck = false;
        this.choose_to_init = false;
        this.magic = false;
    }

    public char getType() {
        return type;
    }
    public void setType(char type) {
        this.type = type;
    }
    public int getHouse() {
        return house;
    }
    public void setHouse(int house) {
        this.house = house;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int TrowDice(char type) {
        if(type == 'n') {
            dice = new DoubleDice();
        }
        else if(type == 'l') {
            dice = new LuckyDoubleDice();
        }
        else if(type == 'm') {
            dice = new MisfortuneDoubleDice();
        }
        else {
            return 0;
        }
        return dice.ThrowDices();
    }

    public int getDiceResult() {
        return dice_result;
    }
    public void rollDice() {
        dice_result = 0;
        do {
            dice_result += TrowDice(type);
        }while(dice.DicesAreEqual());
    }

    public void walk() {
        Visual.andar(color, house, getDiceResult());
        house += dice_result;
        if(house > 39){
            house = 39;
        }
        Visual.checarVitoria(house, color);
    }

    public void setTypeToRandom() {
        Random rdm = new Random();
        char[] types = {'n', 'l', 'm'};
        int index = rdm.nextInt(3);
        type = types[index];
    }

    public boolean isDont_play() {
        return dont_play;
    }

    public void setDont_play(boolean dont_play) {
        this.dont_play = dont_play;
    }

    public boolean isSurprise() {
        return surprise;
    }

    public void setSurprise(boolean surprise) {
        this.surprise = surprise;
    }

    public boolean isLuck() {
        return luck;
    }

    public void setLuck(boolean luck) {
        this.luck = luck;
    }

    public boolean isChooseToInit() {
        return choose_to_init;
    }

    public void setChooseToInit(boolean choose_to_init) {
        this.choose_to_init = choose_to_init;
    }

    public boolean isMagic() {
        return magic;
    }

    public void setMagic(boolean magic) {
        this.magic = magic;
    }
}
