package edu.teamsa.gambit;
/**
 * @author Team Something Awesomes
 * Junit tests for the class Player
 */
import static org.junit.Assert.*;

import javax.swing.ImageIcon;

import org.junit.Test;

public class PlayerTest {

	Deck myDeck = new Deck();
	Player myPlayer = new Player();
	/**
	 * testHit test the method hit, it uses the deck created, adds a specific card to the test
	 * then runs the method and compares the expected and actual cards returned
	 */
	@Test
	public void testHit() {
		myDeck.addCard(new Card(Suit.SPADE,FaceValue.ACE,new ImageIcon("images/A_club.jpg")));
		myDeck.addCard(new Card(Suit.SPADE,FaceValue.TWO,new ImageIcon("images/A_club.jpg")));
		
		Card expected = new Card(Suit.SPADE,FaceValue.ACE,new ImageIcon("images/A_club.jpg"));
		myPlayer.hit(myDeck);
		Card actual = myPlayer.getHandCard(0);

		assertEquals(expected, actual);	
	}

/**
 * testGetHandValue adds five specific cards to the deck, and hits each time testing the returned value
 * from the hand by running the method and comparing it to the expected results
 */
	@Test
	public void testGetHandValue() {
		myDeck.addCard(new Card(Suit.SPADE,FaceValue.ACE,new ImageIcon("images/A_club.jpg")));
		myDeck.addCard(new Card(Suit.SPADE,FaceValue.TWO,new ImageIcon("images/A_club.jpg")));
		myDeck.addCard(new Card(Suit.HEART,FaceValue.NINE,new ImageIcon("images/A_club.jpg")));
		myDeck.addCard(new Card(Suit.HEART,FaceValue.SEVEN,new ImageIcon("images/A_club.jpg")));
		myDeck.addCard(new Card(Suit.HEART,FaceValue.KING,new ImageIcon("images/A_club.jpg")));
		
		myPlayer.hit(myDeck);
		myPlayer.hit(myDeck);
		int expected = 13;
		int actual = myPlayer.getHandValue();
		assertEquals(expected, actual);	
		
		myPlayer.hit(myDeck);
		expected = 22;
		actual = myPlayer.getHandValue();
		assertEquals(expected, actual);	
		
		myPlayer.hit(myDeck);
		expected = 29;
		actual = myPlayer.getHandValue();
		assertEquals(expected, actual);
		
		myPlayer.hit(myDeck);
		expected = 39;
		actual = myPlayer.getHandValue();
		assertEquals(expected, actual);
	}
/**
 * testClearHand tests the clearHand method, it creates a hand and clears it, comparing the expected hand Value of 0 to the actual hand 
 * value after running the method
 */
	@Test
	public void testClearHand() {
		myDeck.addCard(new Card(Suit.SPADE,FaceValue.ACE,new ImageIcon("images/A_club.jpg")));
		myDeck.addCard(new Card(Suit.SPADE,FaceValue.TWO,new ImageIcon("images/A_club.jpg")));
		myDeck.addCard(new Card(Suit.HEART,FaceValue.NINE,new ImageIcon("images/A_club.jpg")));
		myDeck.addCard(new Card(Suit.HEART,FaceValue.SEVEN,new ImageIcon("images/A_club.jpg")));
		myDeck.addCard(new Card(Suit.HEART,FaceValue.KING,new ImageIcon("images/A_club.jpg")));
		
		int expected = 0;
		myPlayer.hit(myDeck);
		myPlayer.hit(myDeck);
		myPlayer.clearHand();
		assertEquals(expected, myPlayer.getHandValue());
		
		myPlayer.hit(myDeck);
		myPlayer.hit(myDeck);
		myPlayer.hit(myDeck);
		myPlayer.clearHand();
		assertEquals(expected, myPlayer.getHandValue());
		
	}
/**
 * testCheckAces creates five unique scenarios of hands that have aces and makes sure the method changes 
 * the value of the aces when it should
 */
	@Test
	public void testCheckAces() {
		int expected = 11;
		int actual;
		myDeck.addCard(new Card(Suit.SPADE,FaceValue.ACE,new ImageIcon("images/A_club.jpg")));
		myDeck.addCard(new Card(Suit.SPADE,FaceValue.TWO,new ImageIcon("images/A_club.jpg")));
		myDeck.addCard(new Card(Suit.HEART,FaceValue.NINE,new ImageIcon("images/A_club.jpg")));
		myDeck.addCard(new Card(Suit.SPADE,FaceValue.ACE,new ImageIcon("images/A_club.jpg")));
		myPlayer.hit(myDeck);
		
		myPlayer.checkAces();
		actual = myPlayer.getHandValue();
		assertEquals(expected, actual);
		
		myPlayer.hit(myDeck);
		expected = 13;
		myPlayer.checkAces();
		actual = myPlayer.getHandValue();
		assertEquals(expected, actual);
		
		myPlayer.hit(myDeck);
		expected = 12;
		myPlayer.checkAces();
		actual = myPlayer.getHandValue();
		assertEquals(expected, actual);
		
		myPlayer.hit(myDeck);
		expected = 13;
		myPlayer.checkAces();
		actual = myPlayer.getHandValue();
		assertEquals(expected, actual);
		
		for(int i = 0; i < 10; i++){
			myDeck.addCard(new Card(Suit.SPADE,FaceValue.ACE,new ImageIcon("images/A_club.jpg")));
			myPlayer.hit(myDeck);
			myPlayer.checkAces();
			expected++;
			actual = myPlayer.getHandValue();
			assertEquals(expected, actual);
		}
		
	}

}
