package edu.teamsa.gambit;

import static org.junit.Assert.*;

import javax.swing.ImageIcon;

import org.junit.Test;

public class PlayerTest {

	Deck myDeck = new Deck();
	Player myPlayer = new Player();
	
	@Test
	public void testHit() {
		myDeck.addCard(new Card(Suit.SPADE,FaceValue.ACE,new ImageIcon("images/A_club.jpg")));
		myDeck.addCard(new Card(Suit.SPADE,FaceValue.TWO,new ImageIcon("images/A_club.jpg")));
		
		Card expected = new Card(Suit.SPADE,FaceValue.ACE,new ImageIcon("images/A_club.jpg"));
		myPlayer.hit(myDeck);
		Card actual = myPlayer.getHandCard(0);

		assertEquals(expected, actual);	
	}

//	@Test
//	public void testStay() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testBlackJack() {
//		fail("Not yet implemented");
//	}
//
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
//
//	@Test
//	public void testGetHandCard() {
//		fail("Not yet implemented");
//	}
//
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
