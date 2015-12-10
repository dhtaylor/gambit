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
		deck.add(new Card(suit,FaceValue.KING,new ImageIcon(Deck.class.getResource("/images/king_club.jpg"))));
		deck.add(new Card(suit,FaceValue.QUEEN,new ImageIcon(Deck.class.getResource("/images/queen_club.jpg"))));
		deck.add(new Card(suit,FaceValue.JACK,new ImageIcon(Deck.class.getResource("/images/jack_club.jpg"))));
		deck.add(new Card(suit,FaceValue.TEN,new ImageIcon(Deck.class.getResource("/images/10_club.jpg"))));
		deck.add(new Card(suit,FaceValue.NINE,new ImageIcon(Deck.class.getResource("/images/9_club.jpg"))));
		deck.add(new Card(suit,FaceValue.EIGHT,new ImageIcon(Deck.class.getResource("/images/8_club.jpg"))));
		deck.add(new Card(suit,FaceValue.SEVEN,new ImageIcon(Deck.class.getResource("/images/7_club.jpg"))));
		deck.add(new Card(suit,FaceValue.SIX,new ImageIcon(Deck.class.getResource("/images/6_club.jpg"))));
		deck.add(new Card(suit,FaceValue.FIVE,new ImageIcon(Deck.class.getResource("/images/5_club.jpg"))));
		deck.add(new Card(suit,FaceValue.FOUR,new ImageIcon(Deck.class.getResource("/images/4_club.jpg"))));
		deck.add(new Card(suit,FaceValue.THREE,new ImageIcon(Deck.class.getResource("/images/3_club.jpg"))));
		deck.add(new Card(suit,FaceValue.TWO,new ImageIcon(Deck.class.getResource("/images/2_club.jpg"))));
		deck.add(new Card(suit,FaceValue.ACE,new ImageIcon(Deck.class.getResource("/images/A_club.jpg"))));
		suit = Suit.DIAMOND;
		deck.add(new Card(suit,FaceValue.KING,new ImageIcon(Deck.class.getResource("/images/king_diamond.jpg"))));
		deck.add(new Card(suit,FaceValue.QUEEN,new ImageIcon(Deck.class.getResource("/images/queen_diamond.jpg"))));
		deck.add(new Card(suit,FaceValue.JACK,new ImageIcon(Deck.class.getResource("/images/jack_diamond.jpg"))));
		deck.add(new Card(suit,FaceValue.TEN,new ImageIcon(Deck.class.getResource("/images/10_diamond.jpg"))));
		deck.add(new Card(suit,FaceValue.NINE,new ImageIcon(Deck.class.getResource("/images/9_diamond.jpg"))));
		deck.add(new Card(suit,FaceValue.EIGHT,new ImageIcon(Deck.class.getResource("/images/8_diamond.jpg"))));
		deck.add(new Card(suit,FaceValue.SEVEN,new ImageIcon(Deck.class.getResource("/images/7_diamond.jpg"))));
		deck.add(new Card(suit,FaceValue.SIX,new ImageIcon(Deck.class.getResource("/images/6_diamond.jpg"))));
		deck.add(new Card(suit,FaceValue.FIVE,new ImageIcon(Deck.class.getResource("/images/5_diamond.jpg"))));
		deck.add(new Card(suit,FaceValue.FOUR,new ImageIcon(Deck.class.getResource("/images/4_diamond.jpg"))));
		deck.add(new Card(suit,FaceValue.THREE,new ImageIcon(Deck.class.getResource("/images/3_diamond.jpg"))));
		deck.add(new Card(suit,FaceValue.TWO,new ImageIcon(Deck.class.getResource("/images/2_diamond.jpg"))));
		deck.add(new Card(suit,FaceValue.ACE,new ImageIcon(Deck.class.getResource("/images/A_diamond.jpg"))));
		suit = Suit.HEART;
		deck.add(new Card(suit,FaceValue.KING,new ImageIcon(Deck.class.getResource("/images/king_heart.jpg"))));
		deck.add(new Card(suit,FaceValue.QUEEN,new ImageIcon(Deck.class.getResource("/images/queen_heart.jpg"))));
		deck.add(new Card(suit,FaceValue.JACK,new ImageIcon(Deck.class.getResource("/images/jack_heart.jpg"))));
		deck.add(new Card(suit,FaceValue.TEN,new ImageIcon(Deck.class.getResource("/images/10_heart.jpg"))));
		deck.add(new Card(suit,FaceValue.NINE,new ImageIcon(Deck.class.getResource("/images/9_heart.jpg"))));
		deck.add(new Card(suit,FaceValue.EIGHT,new ImageIcon(Deck.class.getResource("/images/8_heart.jpg"))));
		deck.add(new Card(suit,FaceValue.SEVEN,new ImageIcon(Deck.class.getResource("/images/7_heart.jpg"))));
		deck.add(new Card(suit,FaceValue.SIX,new ImageIcon(Deck.class.getResource("/images/6_heart.jpg"))));
		deck.add(new Card(suit,FaceValue.FIVE,new ImageIcon(Deck.class.getResource("/images/5_heart.jpg"))));
		deck.add(new Card(suit,FaceValue.FOUR,new ImageIcon(Deck.class.getResource("/images/4_heart.jpg"))));
		deck.add(new Card(suit,FaceValue.THREE,new ImageIcon(Deck.class.getResource("/images/3_heart.jpg"))));
		deck.add(new Card(suit,FaceValue.TWO,new ImageIcon(Deck.class.getResource("/images/2_heart.jpg"))));
		deck.add(new Card(suit,FaceValue.ACE,new ImageIcon(Deck.class.getResource("/images/A_heart.jpg"))));
		suit = Suit.SPADE;
		deck.add(new Card(suit,FaceValue.KING,new ImageIcon(Deck.class.getResource("/images/king_spade.jpg"))));
		deck.add(new Card(suit,FaceValue.QUEEN,new ImageIcon(Deck.class.getResource("/images/queen_spade.jpg"))));
		deck.add(new Card(suit,FaceValue.JACK,new ImageIcon(Deck.class.getResource("/images/jack_spade.jpg"))));
		deck.add(new Card(suit,FaceValue.TEN,new ImageIcon(Deck.class.getResource("/images/10_spade.jpg"))));
		deck.add(new Card(suit,FaceValue.NINE,new ImageIcon(Deck.class.getResource("/images/9_spade.jpg"))));
		deck.add(new Card(suit,FaceValue.EIGHT,new ImageIcon(Deck.class.getResource("/images/8_spade.jpg"))));
		deck.add(new Card(suit,FaceValue.SEVEN,new ImageIcon(Deck.class.getResource("/images/7_spade.jpg"))));
		deck.add(new Card(suit,FaceValue.SIX,new ImageIcon(Deck.class.getResource("/images/6_spade.jpg"))));
		deck.add(new Card(suit,FaceValue.FIVE,new ImageIcon(Deck.class.getResource("/images/5_spade.jpg"))));
		deck.add(new Card(suit,FaceValue.FOUR,new ImageIcon(Deck.class.getResource("/images/4_spade.jpg"))));
		deck.add(new Card(suit,FaceValue.THREE,new ImageIcon(Deck.class.getResource("/images/3_spade.jpg"))));
		deck.add(new Card(suit,FaceValue.TWO,new ImageIcon(Deck.class.getResource("/images/2_spade.jpg"))));
		deck.add(new Card(suit,FaceValue.ACE,new ImageIcon(Deck.class.getResource("/images/A_spade.jpg"))));
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
	
	/**
	 * addCard is a testing method which allows us to add specific cards to the deck. 
	 * @param c the card to add to the deck.
	 */
	public void addCard(Card c){
		deck.add(c);
	}
	public Card getCard(int index){
		return deck.get(index);
	}

	public int size(){
		return this.deck.size() - this.deckIndex;
	}
	
}
