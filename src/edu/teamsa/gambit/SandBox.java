package edu.teamsa.gambit;

public class SandBox {
	
	public static void main(String[] args){
		Deck myDeck = new Deck();
		Player myPlayer = new Player();
		
		myDeck.createDeck();
		myDeck.shuffle();
		for(int i = 0; i < 5 ; i ++){
			myPlayer.hit(myDeck);
			System.out.println();
			System.out.println(myPlayer.getHandValue());
		}
		
	}

}
