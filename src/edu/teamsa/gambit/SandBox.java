package edu.teamsa.gambit;

import javax.swing.ImageIcon;

public class SandBox {
	
	public static void main(String[] args){
		Deck myDeck = new Deck();
		Player myPlayer = new Player();
		
		myDeck.createDeck();
		myDeck.shuffle();
		myDeck.addCard(new Card(Suit.SPADE,FaceValue.ACE,new ImageIcon("images/A_club.jpg")));
		myDeck.addCard(new Card(Suit.SPADE,FaceValue.ACE,new ImageIcon("images/A_club.jpg")));
		myDeck.addCard(new Card(Suit.SPADE,FaceValue.ACE,new ImageIcon("images/A_club.jpg")));
		myDeck.addCard(new Card(Suit.SPADE,FaceValue.ACE,new ImageIcon("images/A_club.jpg")));
				
		for(int i = 0; i < 56 ; i ++){
			myPlayer.hit(myDeck);
			System.out.println(myPlayer.getHandCard(myPlayer.currentHand.size()-1));
			System.out.println("Hand Value: " + myPlayer.getHandValue());
			myPlayer.checkAces();
			System.out.println("Ace Handling: " + myPlayer.getHandValue());
			if(myPlayer.getHandValue() > 21){
				myPlayer.clearHand();
				System.out.println("---------------\nBUST!\n--------------- ");
			}
			else if(myPlayer.getHandValue()==21){
				myPlayer.clearHand();
				System.out.println("---------------\nWinner! \n--------------- ");
			}
			System.out.println();
			
		}
		
	}

}
