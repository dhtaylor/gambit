package edu.teamsa.gambit;

import javax.swing.ImageIcon;

public class Card {

	public Suit suit;
	public FaceValue faceValue;
	public int cardValue;
	public ImageIcon front;
	public ImageIcon back = new ImageIcon(Card.class.getResource("back.jpg"));
	
	Card(Suit suit, FaceValue faceValue, ImageIcon front){
		this.suit = suit;
		this.faceValue = faceValue;
		this.cardValue = faceValue.getCardValue();
		this.front = front;
	}
	
	private void setCardValue(int value){
		this.cardValue = value;
	}
	
	private int getCardValue(){
		return cardValue;
	}
}
