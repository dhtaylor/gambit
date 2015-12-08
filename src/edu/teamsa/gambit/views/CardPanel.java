/*
 * Assignment	gambit
 * Program		CardPanel
 * Author		Dandy H. Taylor
 * Date			Dec 3, 2015
 *
 */

package edu.teamsa.gambit.views;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class CardPanel extends JPanel
{
	private Border defaultBorder = BorderFactory.createEmptyBorder(10,10,10,10);
	private Color panelColor = new Color(7, 99, 36);
	//I created the user panel and dealer panel, added 5 placeholders for cards, not sure if this is how we want to do it or not
	//it would maybe be better to do a flowlayout centered and add the card places dynamically but I'm not that smart! -Britt
	private JPanel userCards = new JPanel();
	private JPanel dealerCards = new JPanel();
	private JLabel userCard1 = new JLabel();
	private JLabel userCard2 = new JLabel();
	private JLabel userCard3 = new JLabel();
	private JLabel userCard4 = new JLabel();
	private JLabel userCard5 = new JLabel();
	private JLabel dealerCard1 = new JLabel();
	private JLabel dealerCard2 = new JLabel();
	private JLabel dealerCard3 = new JLabel();
	private JLabel dealerCard4 = new JLabel();
	private JLabel dealerCard5 = new JLabel();

	
	public CardPanel()
	{
		super();
		this.setLayout(new GridLayout(2, 1));
		this.setBorder(defaultBorder); 
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
		userCards.setLayout(new GridLayout(1, 5));
//		userCards.add(userCard1);
//		userCards.add(userCard2);
//		userCards.add(userCard3);
//		userCards.add(userCard4);
//		userCards.add(userCard5);
		return userCards;

	}
	public JPanel createDealerPanel(){
		dealerCards.setBackground(panelColor);
		dealerCards.setLayout(new GridLayout(1, 5));
//		dealerCards.add(dealerCard1);
//		dealerCards.add(dealerCard2);
//		dealerCards.add(dealerCard3);
//		dealerCards.add(dealerCard4);
//		dealerCards.add(dealerCard5);
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
