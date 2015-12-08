package edu.teamsa.gambit;

public class Dealer extends Player {

	private int limit = 17;
	private boolean hardLimit = false;

	public Deck getDeck()
	{
		Deck deck = new Deck();
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
