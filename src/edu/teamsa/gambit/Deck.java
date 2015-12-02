package edu.teamsa.gambit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;

public class Deck {
	
	List<Card> deck = new ArrayList<Card>();
	
	public void createDeck(){
		Suit suit = Suit.CLUB;
		deck.add(new Card(suit,FaceValue.ACE,new ImageIcon(Deck.class.getResource("filename.jpg"))));
	}
	
	public Card getTopCard(){
		return null;
	}
	
	public void shuffle(){
		Collections.shuffle(deck);
	}

}
