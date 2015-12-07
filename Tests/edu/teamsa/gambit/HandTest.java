package edu.teamsa.gambit;

import static org.junit.Assert.*;

import javax.swing.ImageIcon;

import org.junit.Test;

public class HandTest {
	
	Card card1 = new Card(Suit.CLUB,FaceValue.KING,new ImageIcon("images/king_club.jpg"));
	Card card2 = new Card(Suit.CLUB,FaceValue.THREE,new ImageIcon("images/3_club.jpg"));
	
	Hand testHand = new Hand(card1, card2); 
			

	@Test
	public void testSetCurrentValue() {
		testHand.setCurrentValue(14);
		int expected = 14;
		int actual = testHand.getCurrentValue();
		assertEquals(expected, actual);

	}

	@Test
	public void testGetCurrentValue() {
		int expected = 13;
		int actual = testHand.getCurrentValue();
	}

}
