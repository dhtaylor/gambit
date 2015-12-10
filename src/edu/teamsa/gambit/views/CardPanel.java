/*
 * Assignment	gambit
 * Program		CardPanel
 * Author		Dandy H. Taylor
 * Date			Dec 3, 2015
 *
 */

package edu.teamsa.gambit.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Method for creating the GUI panel that displays the dealer's and user's cards
 * @author Team Something Awesomes
 *
 */
@SuppressWarnings("serial")
public class CardPanel extends JPanel
{
	private Dimension panelDimension = new Dimension(340, 550);
	private Border defaultBorder = BorderFactory.createEmptyBorder(10,10,10,10);
	private Color panelColor = new Color(7, 99, 36);
	//I created the user panel and dealer panel, added 5 placeholders for cards, not sure if this is how we want to do it or not
	//it would maybe be better to do a flowlayout centered and add the card places dynamically but I'm not that smart! -Britt
	private JPanel userCards = new JPanel();
	private JPanel dealerCards = new JPanel();

	
	/**
	 * Constructor for creating the card panel that houses the user's and dealer's cards
	 */
	public CardPanel()
	{
		super();
		this.setLayout(new GridLayout(2, 1));
		this.setBorder(defaultBorder);
		this.setPreferredSize(this.panelDimension);
		this.setBackground(panelColor);
		
		this.add(createDealerPanel());
		this.add(createUserPanel());
		
	}
	
	/**
	 * Sets the color of the Cardpanel
	 * @param c - the color for the panel
	 */
	public void setPanelColor(Color c)
	{
		this.panelColor = c;
		this.setBackground(this.panelColor);
	}
	
	/**
	 * Creates the panel that houses the player's cards
	 * @return - the userCards
	 */
	public JPanel createUserPanel()
	{
		userCards.setBackground(panelColor);
		userCards.setLayout(new GridLayout(1, 5, 0 , 0));
		userCards.setBorder(defaultBorder);

		return userCards;

	}
	
	/**
	 * Creates the panel that houses the dealers's cards
	 * @return - the dealerCards
	 */
	public JPanel createDealerPanel()
	{
		dealerCards.setBackground(panelColor);
		dealerCards.setLayout(new GridLayout(1, 5, 0, 0));
		dealerCards.setBorder(defaultBorder);

		return dealerCards;

	}
	
	/**
	 * Getter for User Cards
	 * @return - userCards
	 */
	public JPanel getUserCards()
	{
		return this.userCards;
	}

	/**
	 * Getter for Dealer Cards
	 * @return - dealerCards
	 */
	public JPanel getDealerCards()
	{
		return this.dealerCards;
	}
}
