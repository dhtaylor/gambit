package edu.teamsa.gambit;

import java.util.ArrayList;
import java.util.List;

/**
 * **
 * @author Team Something Awesomes - Dandy Taylor, Steve Young, Ryan Thatcher, Brittany Hofstetter
 * 12/10/2015
 * 
 * Team Assignment Project
 * 
 * The super class for dealer and user
 * Contains methods for manipulating the player's and dealer's hands
 *
 */
public class Player 
{
	
	/**  Creates a list of Cards called currentHand */
	List<Card> currentHand = new ArrayList<Card>();
		
	/**
	 * Hit method to add another card to the hand
	 * @param deck - the current deck
	 * @return - card - returns a card to be added to the hand
	 */
	public Card hit(Deck deck)
	{
		Card card = deck.getTopCard();
		currentHand.add(card);
		return card;
	}
			
	/**
	 * Method for returning the value of the current hand
	 * @return - handValue - the value of the current hand
	 */
	public int getHandValue()
	{
		int handValue = 0;
		for(Card c : currentHand){
			handValue = handValue + c.getCardValue();
		}
		return handValue;
	}
	
	/** Gets a card from the current hand
	 *@param handIndex	This is an int that represents the index of the card to be retrieved
	 * @return Returns a Card object requested
	 * 
	 */
	public Card getHandCard(int handIndex)
	{
		return currentHand.get(handIndex);
	}
	
	/** Method to clear the current hand after the hands are finished */
	public void clearHand()
	{
		currentHand.removeAll(currentHand);
	}
	
	/**
	 * The checkAces method will check the current players hand (user or dealer) for any aces value 11, and if the hand total
	 * value is greater than 21, will set those  aces to value 1. it implements a nested if statement within a for each loop. 
	 * the loop will run through each card in the players hand, then check if the current hand value is greater than 21.
	 * checking at this point is important for cases where a hand contains multiple aces at value 11. if the total is greater than 
	 * 21 it will set the current card's value to 1. the loop will then go to the next card, check the hand value (which should
	 * now be less than 21) and continue normally.
	 * 
	 * @param limit	This is an it representing the hand value that you want to stay on.
	 * 
	 */
	public void checkAces(int limit)
	{
		for(Card card : currentHand)
		{
			if(this.getHandValue() > limit)
			{
				if(card.getCardValue() == 11)
					card.setCardValue(1);
			}
			
		}
		
	}

	/**
	 * This method overloads the main checkAces method and passes in a limit of 21,
	 * which we want as the default behavior for the user.
	 * 
	 */
	public void checkAces()
	{
		checkAces(21);
	}

}
