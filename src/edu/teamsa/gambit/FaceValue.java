package edu.teamsa.gambit;
/** 
 * @author Team Something Awesomes - Dandy Taylor, Steve Young, Ryan Thatcher, Brittany Hofstetter
 * 12/10/2015
 * 
 * Team Assignment Project
 * 
 *	Enum FaceValue sets the integer value for the cards in the deck
 */
public enum FaceValue {

	ACE(11), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), 
	EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10);
	
	public int cardValue;
	
	/** Sets the card value
	 * @param value - value of the card
	 */
	private FaceValue(int value)
	{
		this.cardValue = value;
	}
	
	/**
	 * Getter for returning the value of the card
	 * @return value of the card
	 */
	public int getCardValue()
	{
		return cardValue;
	}
	
}
