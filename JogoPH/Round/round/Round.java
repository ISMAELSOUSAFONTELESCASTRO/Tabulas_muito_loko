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
	
	public void applyStatusEffects(Persons[] persons) {
		if(player.isDont_play() == true) {
			//he does not play for one round
		}
		else if(player.isChooseToInit() == true) {
			//choose a player to go to start
		}
		else if(player.isMagic() == true) {
			
			/*achando o menor*/
			int smaller_value = 42;
			int lower_index = 0;
			for (int i = 0; i < persons.length; i++) {
				if (persons[i].getHouse() < smaller_value) {
	              smaller_value = persons[i].getHouse();
	                lower_index = i; // Atualiza a posição do menor valor encontrado
	            }
	        }
			
			player.setHouse(persons[lower_index].getHouse());//take the place of the last one
			persons[lower_index].setHouse(player.getHouse());
			
		}
		else if(player.isLuck() == true) {
			player.setHouse(player.getHouse() + 3);//walk 3 more houses
		}
	
	
	
}
