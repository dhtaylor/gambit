package edu.teamsa.gambit;

public enum FaceValue {

	ACE(11), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), 
	EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10);
	
	public int cardValue;
	
	private FaceValue(int value){
		this.cardValue = value;
	}
	
	public int getCardValue(){
		return cardValue;
	}
	
}
