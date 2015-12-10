package edu.teamsa.gambit;
/**
 * @author Team Something Awesomes
 * JUnit testing for the class Deck
 */
import static org.junit.Assert.*;

import javax.swing.ImageIcon;

import org.junit.Test;

public class DeckTest {
	Deck testDeck = new Deck();
/**
 * testGetTopCard tests the method getTopCard from the Deck class, it creates a deck and pulls the expected top card 
 * then compares the two
 */
	@Test
	public void testGetTopCard() {
		testDeck.createDeck();
		Card expected = new Card(Suit.CLUB,FaceValue.KING,new ImageIcon("images/king_club.jpg"));
		Card actual = testDeck.getTopCard();
		assertEquals(expected, actual);

	}
/**
 * testAddCard test the method addCard from the Deck class, it adds a card to the deck and then pulls the card
 * at that given index to make sure it is added, then compares actual and expected
 */
	@Test
	public void testAddCard() {
		testDeck.createDeck();
		testDeck.addCard(new Card(Suit.CLUB,FaceValue.QUEEN,new ImageIcon("images/queen_club.jpg")));
		Card expected = new Card(Suit.CLUB,FaceValue.QUEEN,new ImageIcon("images/queen_club.jpg"));
		Card actual = testDeck.getCard(52);
		assertEquals(expected, actual);
	}

}
