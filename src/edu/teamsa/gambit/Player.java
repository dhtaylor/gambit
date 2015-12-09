package edu.teamsa.gambit;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	List<Card> currentHand = new ArrayList<Card>();
		
	public Card hit(Deck deck){
		Card card = deck.getTopCard();
		currentHand.add(card);
		return card;
	}
			
	public int getHandValue(){
		int handValue = 0;
		for(Card c : currentHand){
			handValue = handValue + c.getCardValue();
		}
		return handValue;
	}
	
	public Card getHandCard(int handIndex){
		return currentHand.get(handIndex);
	}
	
	public void clearHand(){
		currentHand.removeAll(currentHand);
	}
	
	/**
	 * The checkAces method will check the current players hand (user or dealer) for any aces value 11, and if the hand total
	 * value is greater than 21, will set those  aces to value 1. it implements a nested if statement within a for each loop. 
	 * the loop will run through each card in the players hand, then check if the current hand value is greater than 21.
	 * checking at this point is important for cases where a hand contains multiple aces at value 11. if the total is greater than 
	 * 21 it will set the current card's value to 1. the loop will then go to the next card, check the hand value (which should
	 * now be less than 21) and continue normally. 
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
