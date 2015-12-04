package edu.teamsa.gambit;

public class SandBox {
	
	public static void main(String[] args){
		Deck myDeck = new Deck();
		Player myPlayer = new Player();
		
		myDeck.createDeck();
		myDeck.shuffle();
		for(int i = 0; i < 52 ; i ++){
			myPlayer.hit(myDeck);
			System.out.println(myPlayer.getHandCard(i));
			System.out.println("Hand Value: " + myPlayer.getHandValue());
			myPlayer.checkAces();
			System.out.println("Ace Handling: " + myPlayer.getHandValue());
		}
		
	}

}
