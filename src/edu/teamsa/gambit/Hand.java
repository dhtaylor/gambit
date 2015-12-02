package edu.teamsa.gambit;

import java.util.Collection;

public class Hand {
	
	public Collection<Card> cards;
	public int currentValue;
	//public int aceCount;
	
	public Hand(Card cardOne, Card cardTwo){
		this.currentValue = cardOne.getCardValue() + cardTwo.getCardValue();
		
	}
	
	public void setCurrentValue(int value){
		this.currentValue = value;
	}
	
	public int getCurrentValue(){
		return currentValue;
	}

}
