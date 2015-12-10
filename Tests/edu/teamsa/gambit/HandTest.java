package edu.teamsa.gambit;
/**
 * @author Team Something Awesomes
 * Junit tests for the class Hand
 */
import static org.junit.Assert.*;

import javax.swing.ImageIcon;

import org.junit.Test;

public class HandTest {
	
	Card card1 = new Card(Suit.CLUB,FaceValue.KING,new ImageIcon("images/king_club.jpg"));
	Card card2 = new Card(Suit.CLUB,FaceValue.THREE,new ImageIcon("images/3_club.jpg"));
	
	Hand testHand = new Hand(card1, card2); 
			
/**
 * testSetCurrentValue tests the method setCurrentValue, it runs the method and sets the value to 14 then 
 * compares the actual and expected values
 */
	@Test
	public void testSetCurrentValue() {
		testHand.setCurrentValue(14);
		int expected = 14;
		int actual = testHand.getCurrentValue();
		assertEquals(expected, actual);

	}
/**
 * testGetCurrentValue tests the getCurrentValue, it uses the hand created including the king and three, then 
 * runs the method and compares the expected value and the actual value
 */
	@Test
	public void testGetCurrentValue() {
		int expected = 13;
		int actual = testHand.getCurrentValue();
		assertEquals(expected, actual);
	}

}
