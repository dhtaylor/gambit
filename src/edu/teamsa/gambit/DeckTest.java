package edu.teamsa.gambit;

import static org.junit.Assert.*;

import javax.swing.ImageIcon;

import org.junit.Test;

public class DeckTest {
	Deck testDeck = new Deck();

	@Test
	public void testGetTopCard() {
		testDeck.createDeck();
		Card expected = new Card(Suit.CLUB,FaceValue.KING,new ImageIcon("images/king_club.jpg"));
		Card actual = testDeck.getTopCard();
		assertEquals(expected, actual);

	}

	@Test
	public void testAddCard() {
		testDeck.createDeck();
		testDeck.addCard(new Card(Suit.CLUB,FaceValue.QUEEN,new ImageIcon("images/queen_club.jpg")));
		Card expected = new Card(Suit.CLUB,FaceValue.QUEEN,new ImageIcon("images/queen_club.jpg"));
		Card actual = testDeck.getCard(52);
		assertEquals(expected, actual);
	}

}
