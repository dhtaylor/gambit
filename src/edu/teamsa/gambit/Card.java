package edu.teamsa.gambit;
/**
 * @author Team Something Awesomes
 * Class Card creates the object card and initializes the values for suit, face value, card value, 
 * and the image for the front and back of the card. It has methods setCardValue, getFront, setFront,
 * getBack, setBack, getCardValue, toString, getSuite, hashCode, flip, equals
 */

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Card extends JLabel
{

	public Suit suit;
	public FaceValue faceValue;
	public int cardValue;
	public ImageIcon front;
	public ImageIcon back = new ImageIcon(Card.class.getResource("/images/back.jpg"));
	
	Card(Suit suit, FaceValue faceValue, ImageIcon front){
		this.suit = suit;
		this.faceValue = faceValue;
		this.cardValue = faceValue.getCardValue();
		this.front = front;
		this.setIcon(this.back);
	}
	/**
	 *setCardValue takes in an integer and sets the value for the card
	 * @param value
	 */
	public void setCardValue(int value){
		this.cardValue = value;
	}
	/**
	 * getFront returns the ImageIcon for the front of the card
	 * @return
	 */
	public ImageIcon getFront() {
		return front;
	}

	public void setFront(ImageIcon front) {
		this.front = front;
	}
	/**
	 * getBack returns the ImageIcon for the back of the card
	 * @return
	 */
	public ImageIcon getBack() {
		return back;
	}

	public void setBack(ImageIcon back) {
		this.back = back;
	}

	public int getCardValue(){
		return cardValue;
	}
	/**
	 * getSuit returns the value for the Suite of the card from the Enum Suite
	 * @return
	 */
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
	/**
	 * flip method toggles between the front image of the card and the back image with each implementation
	 */
	public void flip()
	{
		String iconImage = this.getIcon().toString();
		String backImage = this.back.toString();
		
		if (iconImage.equals(backImage))
			this.setIcon(this.front);
		else
			this.setIcon(this.back);

	}
}
