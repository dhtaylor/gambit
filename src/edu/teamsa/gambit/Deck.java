package edu.teamsa.gambit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;

public class Deck {
	
	List<Card> deck = new ArrayList<Card>();
	int deckIndex = 0;
	
	/**
	 * createDeck will add all 52 standard card values to the deck ArrayList. This method must be run at least once before 
	 * before the hands are dealt. 
	 */
	public void createDeck(){
		Suit suit = Suit.CLUB;
		deck.add(new Card(suit,FaceValue.KING,new ImageIcon("images/king_club.jpg")));
		deck.add(new Card(suit,FaceValue.QUEEN,new ImageIcon("images/queen_club.jpg")));
		deck.add(new Card(suit,FaceValue.JACK,new ImageIcon("images/jack_club.jpg")));
		deck.add(new Card(suit,FaceValue.TEN,new ImageIcon("images/10_club.jpg")));
		deck.add(new Card(suit,FaceValue.NINE,new ImageIcon("images/9_club.jpg")));
		deck.add(new Card(suit,FaceValue.EIGHT,new ImageIcon("images/8_club.jpg")));
		deck.add(new Card(suit,FaceValue.SEVEN,new ImageIcon("images/7_club.jpg")));
		deck.add(new Card(suit,FaceValue.SIX,new ImageIcon("images/6_club.jpg")));
		deck.add(new Card(suit,FaceValue.FIVE,new ImageIcon("images/5_club.jpg")));
		deck.add(new Card(suit,FaceValue.FOUR,new ImageIcon("images/4_club.jpg")));
		deck.add(new Card(suit,FaceValue.THREE,new ImageIcon("images/3_club.jpg")));
		deck.add(new Card(suit,FaceValue.TWO,new ImageIcon("images/2_club.jpg")));
		deck.add(new Card(suit,FaceValue.ACE,new ImageIcon("images/A_club.jpg")));
		suit = Suit.DIAMOND;
		deck.add(new Card(suit,FaceValue.KING,new ImageIcon("images/king_diamon.jpg")));
		deck.add(new Card(suit,FaceValue.QUEEN,new ImageIcon("images/queen_diamond.jpg")));
		deck.add(new Card(suit,FaceValue.JACK,new ImageIcon("images/jack_diamond.jpg")));
		deck.add(new Card(suit,FaceValue.TEN,new ImageIcon("images/10_diamond.jpg")));
		deck.add(new Card(suit,FaceValue.NINE,new ImageIcon("images/9_diamond.jpg")));
		deck.add(new Card(suit,FaceValue.EIGHT,new ImageIcon("images/8_diamond.jpg")));
		deck.add(new Card(suit,FaceValue.SEVEN,new ImageIcon("images/7_diamond.jpg")));
		deck.add(new Card(suit,FaceValue.SIX,new ImageIcon("images/6_diamond.jpg")));
		deck.add(new Card(suit,FaceValue.FIVE,new ImageIcon("images/5_diamond.jpg")));
		deck.add(new Card(suit,FaceValue.FOUR,new ImageIcon("images/4_diamond.jpg")));
		deck.add(new Card(suit,FaceValue.THREE,new ImageIcon("images/3_diamond.jpg")));
		deck.add(new Card(suit,FaceValue.TWO,new ImageIcon("images/2_diamond.jpg")));
		deck.add(new Card(suit,FaceValue.ACE,new ImageIcon("images/A_diamond.jpg")));
		suit = Suit.HEART;
		deck.add(new Card(suit,FaceValue.KING,new ImageIcon("images/king_heart.jpg")));
		deck.add(new Card(suit,FaceValue.QUEEN,new ImageIcon("images/queen_heart.jpg")));
		deck.add(new Card(suit,FaceValue.JACK,new ImageIcon("images/jack_heart.jpg")));
		deck.add(new Card(suit,FaceValue.TEN,new ImageIcon("images/10_heart.jpg")));
		deck.add(new Card(suit,FaceValue.NINE,new ImageIcon("images/9_heart.jpg")));
		deck.add(new Card(suit,FaceValue.EIGHT,new ImageIcon("images/8_heart.jpg")));
		deck.add(new Card(suit,FaceValue.SEVEN,new ImageIcon("images/7_heart.jpg")));
		deck.add(new Card(suit,FaceValue.SIX,new ImageIcon("images/6_heart.jpg")));
		deck.add(new Card(suit,FaceValue.FIVE,new ImageIcon("images/5_heart.jpg")));
		deck.add(new Card(suit,FaceValue.FOUR,new ImageIcon("images/4_heart.jpg")));
		deck.add(new Card(suit,FaceValue.THREE,new ImageIcon("images/3_heart.jpg")));
		deck.add(new Card(suit,FaceValue.TWO,new ImageIcon("images/2_heart.jpg")));
		deck.add(new Card(suit,FaceValue.ACE,new ImageIcon("images/A_heart.jpg")));
		suit = Suit.SPADE;
		deck.add(new Card(suit,FaceValue.KING,new ImageIcon("images/king_spade.jpg")));
		deck.add(new Card(suit,FaceValue.QUEEN,new ImageIcon("images/queen_spade.jpg")));
		deck.add(new Card(suit,FaceValue.JACK,new ImageIcon("images/jack_spade.jpg")));
		deck.add(new Card(suit,FaceValue.TEN,new ImageIcon("images/10_spade.jpg")));
		deck.add(new Card(suit,FaceValue.NINE,new ImageIcon("images/9_spade.jpg")));
		deck.add(new Card(suit,FaceValue.EIGHT,new ImageIcon("images/8_spade.jpg")));
		deck.add(new Card(suit,FaceValue.SEVEN,new ImageIcon("images/7_spade.jpg")));
		deck.add(new Card(suit,FaceValue.SIX,new ImageIcon("images/6_spade.jpg")));
		deck.add(new Card(suit,FaceValue.FIVE,new ImageIcon("images/5_spade.jpg")));
		deck.add(new Card(suit,FaceValue.FOUR,new ImageIcon("images/4_spade.jpg")));
		deck.add(new Card(suit,FaceValue.THREE,new ImageIcon("images/3_spade.jpg")));
		deck.add(new Card(suit,FaceValue.TWO,new ImageIcon("images/2_spade.jpg")));
		deck.add(new Card(suit,FaceValue.ACE,new ImageIcon("images/A_spade.jpg")));
	}
	
	/**
	 * returns the card at position deckIndex(for deckIndex at the time of call). Increments deckIndex, then returns
	 * deck.get(deckIndex - 1).
	 * @return returns the card at the "top" of the deck. indicated by the deckIndex at the time the method is called. 
	 */
	public Card getTopCard(){
		deckIndex++;
		return deck.get(deckIndex - 1);
	}
	
	public void shuffle(){
		Collections.shuffle(deck);
	}

}
