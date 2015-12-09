package edu.teamsa.gambit;

import javax.swing.ImageIcon;

public class Dealer extends Player {

	private int limit = 17;
	private boolean hardLimit = false;

	public Deck getDeck()
	{
		Deck deck = new Deck();
		

//		deck.addCard(new Card(Suit.HEART,FaceValue.TWO,new ImageIcon("images/2_spade.jpg")));
//		deck.addCard(new Card(Suit.HEART,FaceValue.ACE,new ImageIcon("images/A_spade.jpg")));
//		deck.addCard(new Card(Suit.HEART,FaceValue.ACE,new ImageIcon("images/A_spade.jpg")));
//		deck.addCard(new Card(Suit.HEART,FaceValue.TEN,new ImageIcon("images/10_spade.jpg")));
//		deck.addCard(new Card(Suit.HEART,FaceValue.TWO,new ImageIcon("images/2_heart.jpg")));
		
		deck.createDeck();
		deck.shuffle();

		return deck;
	}
	
	public boolean checkTooFewCards(Deck d)
	{
		return (d.size() <= 8) ? true : false;
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
	
}
