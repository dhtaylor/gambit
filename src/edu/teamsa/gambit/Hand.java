package edu.teamsa.gambit;
/**
 * @author Team Something Awesomes
 * Class Hand creates an object representing the cards in the player/users hand
 */
import java.util.Collection;

public class Hand 
{
	
	public Collection<Card> cards;
	public int currentValue;
	//public int aceCount;
	/**
	 * Hand constructor intialized the value of currentValue by adding the cardValue of cardOne and cardTwo
	 * @param cardOne
	 * @param cardTwo
	 */
	public Hand(Card cardOne, Card cardTwo)
	{
		this.currentValue = cardOne.getCardValue() + cardTwo.getCardValue();
		
	}
	
	public void setCurrentValue(int value)
	{
		this.currentValue = value;
	}
	
	public int getCurrentValue()
	{
		return currentValue;
	}

	@Override
	public String toString() 
	{
		return "Hand [cards=" + cards + "]";
	}
	

}
