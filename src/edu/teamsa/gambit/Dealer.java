package edu.teamsa.gambit;

import javax.swing.ImageIcon;

public class Dealer extends Player {

	private int limit = 17;
	private boolean hardLimit = false;

	public Deck getDeck()
	{
		Deck deck = new Deck();

//		Card cardK = new Card(Suit.SPADE,FaceValue.KING,new ImageIcon("images/king_spade.jpg"));
//		Card cardQ = new Card(Suit.SPADE,FaceValue.QUEEN,new ImageIcon("images/queen_spade.jpg"));
//		Card cardJ = new Card(Suit.SPADE,FaceValue.JACK,new ImageIcon("images/jack_spade.jpg"));
//		Card card10 = new Card(Suit.SPADE,FaceValue.TEN,new ImageIcon("images/10_spade.jpg"));
//		Card card9 = new Card(Suit.SPADE,FaceValue.NINE,new ImageIcon("images/9_spade.jpg"));
//		Card card8 = new Card(Suit.SPADE,FaceValue.EIGHT,new ImageIcon("images/8_spade.jpg"));
//		Card card7 = new Card(Suit.SPADE,FaceValue.SEVEN,new ImageIcon("images/7_spade.jpg"));
//		Card card6 = new Card(Suit.SPADE,FaceValue.SIX,new ImageIcon("images/6_spade.jpg"));
//		Card card5 = new Card(Suit.SPADE,FaceValue.FIVE,new ImageIcon("images/5_spade.jpg"));
//		Card card4 = new Card(Suit.SPADE,FaceValue.FOUR,new ImageIcon("images/4_spade.jpg"));
//		Card card3 = new Card(Suit.SPADE,FaceValue.THREE,new ImageIcon("images/3_spade.jpg"));
//		Card card2 = new Card(Suit.SPADE,FaceValue.TWO,new ImageIcon("images/2_spade.jpg"));
//		Card card1 = new Card(Suit.SPADE,FaceValue.ACE,new ImageIcon("images/A_spade.jpg"));
//		
//		deck.addCard(card1);
//		deck.addCard(card9);
//		deck.addCard(cardK);
//		deck.addCard(card2);
//		deck.addCard(card3);
//		deck.addCard(card4);
//		deck.addCard(card5);
		
		deck.createDeck();
		deck.shuffle();

		return deck;
	}
	
	public int getLimit()
	{
		return this.limit;
	}
	
	public boolean isHardLimit()
	{
		return this.hardLimit;
	}
	
	public void setHardLimit(boolean b)
	{
		this.hardLimit = b;
	}
	
	public void createTestCards(){

	}
}
