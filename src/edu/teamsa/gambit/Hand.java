package edu.teamsa.gambit;
/**
 * 
 * @author Team Something Awesomes - Dandy Taylor, Steve Young, Ryan Thatcher, Brittany Hofstetter
 * 12/10/2015
 * 
 * Team Assignment Project
 * 
 * Class Hand creates an object representing the cards in the player/users hand
 */
import java.util.Collection;

/**
 * Method for processing the User's and Dealer's hands
 * @author Team Something Awesomes
 *
 */
public class Hand 
{
	
	public Collection<Card> cards;
	public int currentValue;
	//public int aceCount;
	/**
	 * Hand constructor intializes the value of currentValue by adding the cardValue of cardOne and cardTwo
	 * @param cardOne	The Card representing one of the cards to add
	 * @param cardTwo	The Card representing the second of the cards to add
	 * 
	 */
	public Hand(Card cardOne, Card cardTwo)
	{
		this.currentValue = cardOne.getCardValue() + cardTwo.getCardValue();
		
	}
	
	/**
	 * Sets the Current Value of the hand
	 * @param value - the hand value to be set
	 */
	public void setCurrentValue(int value)
	{
		this.currentValue = value;
	}
	
	/**
	 * Gets the Current Value of the hand
	 * @return - currentValue - Current Value of the hand
	 */
	public int getCurrentValue()
	{
		return currentValue;
	}

	/**
	 * To String method to return a string of "Hand [cards = cards in the hand]
	 */
	@Override
	public String toString() 
	{
		return "Hand [cards=" + cards + "]";
	}
	

}
