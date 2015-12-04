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

	@Override
	public String toString() {
		return "Card [suit=" + suit + ", faceValue=" + faceValue + ", cardValue=" + cardValue + ", front=" + front
				+ ", back=" + back + "]";
	}
}
