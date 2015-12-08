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
	
	public void setPanelColor(Color c)
	{
		this.panelColor = c;
		this.setBackground(this.panelColor);
	}
	
	public JPanel createUserPanel(){
		userCards.setBackground(panelColor);
		userCards.setLayout(new GridLayout(1, 5, 0 , 0));
		userCards.setBorder(defaultBorder);

		return userCards;

	}
	public JPanel createDealerPanel(){
		dealerCards.setBackground(panelColor);
		dealerCards.setLayout(new GridLayout(1, 5, 0, 0));
		dealerCards.setBorder(defaultBorder);

		return dealerCards;

	}
	
	public JPanel getUserCards()
	{
		return this.userCards;
	}

	public JPanel getDealerCards()
	{
		return this.dealerCards;
	}
}
