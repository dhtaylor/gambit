package edu.teamsa.gambit;

public class Card {

	public Suit suit;
	public FaceValue faceValue;
	public int cardValue;
	
	private Card(Suit suit, FaceValue faceValue){
		this.suit = suit;
		this.faceValue = faceValue;
		this.cardValue = faceValue.getCardValue();
	}
	
	private void setValue(int value){
		this.cardValue = value;
	}
	
	private int getCardValue(){
		return cardValue;
	}
}
