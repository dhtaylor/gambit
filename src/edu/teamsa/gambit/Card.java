package edu.teamsa.gambit;

import javax.swing.ImageIcon;

public class Card {

	public Suit suit;
	public FaceValue faceValue;
	public int cardValue;
	public ImageIcon front;
	public ImageIcon back = new ImageIcon("/gambit/images/back.jpg");
	
	Card(Suit suit, FaceValue faceValue, ImageIcon front){
		this.suit = suit;
		this.faceValue = faceValue;
		this.cardValue = faceValue.getCardValue();
		this.front = front;
	}
	
	public void setCardValue(int value){
		this.cardValue = value;
	}
	
	public ImageIcon getFront() {
		return front;
	}

	public void setFront(ImageIcon front) {
		this.front = front;
	}

	public ImageIcon getBack() {
		return back;
	}

	public void setBack(ImageIcon back) {
		this.back = back;
	}

	public int getCardValue(){
		return cardValue;
	}
	
	public Suit getSuit(){
		return this.suit;
	}

	@Override
	public String toString() {
		return "Card: " + faceValue + " of " + suit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((faceValue == null) ? 0 : faceValue.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (faceValue != other.faceValue)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}
}
