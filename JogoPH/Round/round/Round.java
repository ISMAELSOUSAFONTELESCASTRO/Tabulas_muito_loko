package Round;
import Entities.*;

public class Round {
	
	
	/*constants - indica as casas especiais*/
	private int[] dont_play_houses = {10,25,38};
	private int[] surprise_house = {13};
	private int[] luck_houses = {5,15,30};
	private int[] choose_to_init_houses = {17,27};
	private int[] magic_houses = {20,35};
	
	/*attributes*/
	private Persons player;//onde os jogadores ficarão armazenados
	
	/*constructor*/
	public Round(Persons person) {
		this.player = person;	
	}

	public Round(){

    };
	
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
	
	public void makeRound(Board b) {//Eu fiz umas pequenas alterações para as peças andarem
        int y = 0;
	player.rollDice();//anda
        b.removePerson(player.getColor(), player.getHouse());
	player.walk();
        if(player.getHouse() >= 39){
            int x = player.getHouse() - 39;
            b.addPerson(player.getColor(), 39);
            b.printBoard();
            System.out.println("+" + x);
            y++;
        }
	int house = player.getHouse();
        if(y == 0){
            b.addPerson(player.getColor(), house);
        }
	player.setDont_play(IsIn(house, this.dont_play_houses));
	player.setSurprise(IsIn(house, this.surprise_house)); 
	player.setLuck(IsIn(house, this.luck_houses));
	player.setMagic(IsIn(house, this.magic_houses));
	player.setChooseToInit(IsIn(house, this.choose_to_init_houses));
	}
	
	
	
	
	
}
