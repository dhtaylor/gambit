/*
 * Assignment	gambit
 * Program		ResultPanel
 * Author		Dandy H. Taylor
 * Date			Dec 3, 2015
 *
 */

package edu.teamsa.gambit.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Method for creating the GUI Result Panel that displays player name, statistics and hand value
 * and displays the dealer name, dealer's hand value after processing the dealer's hand
 * @author Team Something Awesomes
 *
 */
@SuppressWarnings("serial")
public class ResultPanel extends JPanel
{
//	private Dimension panelDimension = new Dimension(150, 550);
//	private Dimension labelDimension = new Dimension(150, 15);
	private Dimension panelDimension = new Dimension(200, 550);
	private Dimension labelDimension = new Dimension(200, 15);
	private Border defaultBorder = BorderFactory.createEmptyBorder(10,10,10,10);
	private Color panelColor = new Color(255, 255, 255);
	private Color textColor = new Color(0, 0, 0);
	
	private String playerName = "";
	private JPanel dealerResultPanel;
	private JLabel lblDealer;
	private JLabel lblDHandValue;
	
	private JPanel playerResultPanel;
	private JLabel lblPlayer;
	private JLabel lblPWins;
	private JLabel lblPLosses;
	private JLabel lblPWinnings;
	private JLabel lblPHandValue;
	
	/**
	 * Constructor that creates the result panel
	 */
	public ResultPanel()
	{
		super();
		this.setLayout(new GridLayout(0, 1, 0, 0));
		this.setBorder(this.defaultBorder);
		this.setPreferredSize(this.panelDimension);
		this.setBackground(this.panelColor);

		this.add(createDealerResultPanel());
		this.add(createPlayerResultPanel());
		
	}
	
	
	/**
	 * The dealer's hand value
	 * @return - the dealer's and value label
	 */
	public JLabel getLblDHandValue()
	{
		return this.lblDHandValue;
	}


	/**
	 * The number of wins by the player
	 * @return - the players number of wins label
	 */
	public JLabel getLblPWins()
	{
		return this.lblPWins;
	}

	/**
	 * The number of losses by the player
	 * @return - the players number of losses label
	 */
	public JLabel getLblPLosses()
	{
		return this.lblPLosses;
	}

	/**
	 * The net winnings/losses ($) of the player's betting
	 * @return - the player's net betting wins/losses label
	 */
	public JLabel getLblPWinnings()
	{
		return this.lblPWinnings;
	}

	/**
	 * The player's current hand value
	 * @return - the current value of the player's land label
	 */
	public JLabel getLblPHandValue()
	{
		return this.lblPHandValue;
	}
	
	/**
	 * Sets the color of the panel
	 * @param c - color of the panel
	 */
	public void setPanelColor(Color c)
	{
		this.panelColor = c;
		this.setBackground(this.panelColor);
		dealerResultPanel.setBackground(this.panelColor);
		playerResultPanel.setBackground(this.panelColor);
		
	}

	/**
	 * Sets the player name and adds it to the Player Label
	 * @param name - name of the player
	 */
	public void setPlayer(String name)
	{
		this.playerName = name;
		this.lblPlayer.setText("Player: " + this.playerName);
	}
	
	/**
	 * The color of text in the panel
	 * @param c - color of text
	 */
	public void setTextColor(Color c)
	{
		this.textColor = c;
		
		Component[] dealerComponents = this.dealerResultPanel.getComponents();
		
		for (int i = 0; i < dealerComponents.length; i++)
		{
			if (dealerComponents[i] instanceof JLabel)
				dealerComponents[i].setForeground(this.textColor);
		}

		Component[] playerComponents = this.playerResultPanel.getComponents();
		
		for (int i = 0; i < playerComponents.length; i++)
		{
			if (playerComponents[i] instanceof JLabel)
				playerComponents[i].setForeground(this.textColor);
		}
		
	}
	
	/**
	 * Method for creating the Player Result Panel
	 * @return - playerResultPanel
	 */
	private JPanel createPlayerResultPanel()
	{
		playerResultPanel = new JPanel();
		playerResultPanel.setBackground(this.panelColor);
		playerResultPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblPlayer = new JLabel();
		lblPlayer.setPreferredSize(this.labelDimension);
		lblPlayer.setForeground(this.textColor);
		lblPlayer.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		
		lblPWins = new JLabel("Wins: 0");
		lblPWins.setPreferredSize(this.labelDimension);
		lblPWins.setForeground(this.textColor);
		lblPWins.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
		
		lblPLosses = new JLabel("Losses: 0");
		lblPLosses.setPreferredSize(this.labelDimension);
		lblPLosses.setForeground(this.textColor);
		lblPLosses.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
		
		lblPWinnings = new JLabel("Winnings: $0");
		lblPWinnings.setPreferredSize(this.labelDimension);
		lblPWinnings.setForeground(this.textColor);
		lblPWinnings.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
		
		lblPHandValue = new JLabel("Current Hand Value: 0");
		lblPHandValue.setPreferredSize(this.labelDimension);
		lblPHandValue.setForeground(this.textColor);
		lblPHandValue.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
		
		playerResultPanel.add(lblPlayer);
		playerResultPanel.add(lblPWins);
		playerResultPanel.add(lblPLosses);
		playerResultPanel.add(lblPWinnings);
		playerResultPanel.add(lblPHandValue);

		return playerResultPanel;
	}

	/**
	 * Method for creating the Dealer's Result Panel
	 * @return - dealerResultPanel
	 */
	private JPanel createDealerResultPanel()
	{
		dealerResultPanel = new JPanel();
		dealerResultPanel.setBackground(this.panelColor);
		dealerResultPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

 		lblDealer = new JLabel("Dealer: Bob");
		lblDealer.setPreferredSize(this.labelDimension);
		lblDealer.setForeground(this.textColor);
		lblDealer.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		
		lblDHandValue = new JLabel("Current Hand Value: 0");
		lblDHandValue.setPreferredSize(this.labelDimension);
		lblDHandValue.setForeground(this.textColor);
		lblDHandValue.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
		
		dealerResultPanel.add(lblDealer);
		dealerResultPanel.add(lblDHandValue);
		
		return dealerResultPanel;
		
	}

}
