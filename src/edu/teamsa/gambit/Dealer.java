package edu.teamsa.gambit;
/**
 *
 * @author Team Something Awesomes - Dandy Taylor, Steve Young, Ryan Thatcher, Brittany Hofstetter
 * 12/10/2015
 * 
 * Team Assignment Project
 */
import javax.swing.ImageIcon;

/**
 * Contains methods for manipulating the deck and dealer's processing of "Soft" hands
 * Extends the Player class
 * @author Team Something Awesomes
 *
 */
public class Dealer extends Player {

	private int limit = 17;
	private boolean hardLimit = false;
/**
 * getDeck method creates an instance of Class Deck, shuffles the cards by running the shuffle method, and returns the new deck
 * @return
 */
	public Deck getDeck()
	{
		Deck deck = new Deck();
		
		deck.createDeck();
		deck.shuffle();

		return deck;
	}
	
	/**
	 * The value at which the dealer will stop hitting (hard 17 or above)
	 * @return limit - the limit set for dealer to stop hitting
	 */
	public int getLimit()
	{
		return this.limit;
	}
	
	/**
	 * Boolean to see if the hard limit has been reached in the dealer's hand (17 or above)
	 * @return - true if above hard limit and false if below hard limit
	 */
	public boolean isHardLimit()
	{
		return this.hardLimit;
	}
	
	/**
	 * Sets the hard limit amount
	 * @param b - value of the hard limit to be set
	 */
	public void setHardLimit(boolean b)
	{
		this.hardLimit = b;
	}
	
	/**
	 * checks for a "soft 17" condition in the dealer's hand and below 17 
	 * @return chkSoft - true if below 17 and false if above 17 with an Ace in the hand
	 */
	public boolean checkSoft()
	{
		boolean chkSoft = false;
		if (this.getHandValue() == this.getLimit())
		{
			for(Card card : this.currentHand)
			{
				if(card.getCardValue()==11)
				{
					chkSoft = true;
				}
			}
		}
		
		return chkSoft;

	}
}
