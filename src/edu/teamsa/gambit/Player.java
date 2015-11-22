package edu.teamsa.gambit;

public class Player {
	
	Hand currentHand = new Hand();
	Player(){
		//todo determine if we need a constructor here.
	}
	
	public void hit(Deck deck){
		//todo hit logic
	}
	
	public void stay(){
		//todo stay logic
	}
	
	public void blackJack(){
		//todo blackjack logic
	}
	
	private boolean evalHand(Hand hand){
		//todo evalHand logic
		for(Card card : this.currentHand){
			//todo something with each card. I think.
		}
	}
	
	/**
	 * The checkAces method will check the current players hand (user or dealer) for any aces value 11, and if the hand total
	 * value is greater than 21, will set those  aces to value 1. it implements a nested if statement within a for each loop. 
	 * the loop will run through each card in the players hand, then check if the current hand value is greater than 21.
	 * checking at this point is important for cases where a hand contains multiple aces at value 11. if the total is greater than 
	 * 21 it will set the current card's value to 1. the loop will then go to the next card, check the hand value (which should
	 * now be less than 21) and continue normally. 
	 */
	private void checkAces(){
		for(Card card : this.currentHand){
			if(this.currentHand.getCurrentValue() > 21){
				if(card.getCardValue == 11){
					card.setCardValue(1);
				}
			}
		}
	}
}
