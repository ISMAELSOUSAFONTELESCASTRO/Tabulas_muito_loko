package entities;
import dices.*;
import java.util.Random;

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
	private boolean ardy_pssd;
	
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
		this.dice_result = TrowDice(this.type);
	}
	
	public void walk() {
		this.house += this.dice_result;
	}
	
	
	
	public void setTypeToRandom() {
		Random rdm = new Random();
		char[] types = {'n', 'l', 'm'};
		int index = rdm.nextInt(3);
		this.type = types[index];	
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

	public boolean setSurprise(boolean surprise) {
		this.surprise = surprise;
		return surprise;
	}

	public boolean isLuck() {
		return luck;
	}

	public boolean setLuck(boolean luck) {
		this.luck = luck;
		return luck;
	}

	public boolean isChooseToInit() {
		return choose_to_init;
	}

	public boolean setChooseToInit(boolean choose_to_init) {
		this.choose_to_init = choose_to_init;
		return choose_to_init;
	}

	public boolean isMagic() {
		return magic;
	}

	public boolean setMagic(boolean magic) {
		this.magic = magic;
		return magic;
	}


	
	
	
}
