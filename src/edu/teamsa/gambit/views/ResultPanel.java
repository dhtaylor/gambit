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

@SuppressWarnings("serial")
public class ResultPanel extends JPanel
{
	private Dimension panelDimension = new Dimension(150, 550);
	private Dimension labelDimension = new Dimension(150, 15);
	private Color panelColor = new Color(255, 255, 255);
	private Color textColor = new Color(0, 0, 0);
	
	private String playerName = "";
	private JPanel dealerResultPanel;
	private JLabel lblDealer;
	private JLabel lblDWins;
	private JLabel lblDLosses;
	
	private JPanel playerResultPanel;
	private JLabel lblPlayer;
	private JLabel lblPWins;
	private JLabel lblPLosses;
	private JLabel lblPWinnings;
	
	public ResultPanel()
	{
		super();
		this.setLayout(new GridLayout(0, 1, 0, 0));
		this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		this.setPreferredSize(this.panelDimension);
		this.setBackground(this.panelColor);

		this.add(createDealerResultPanel());
		this.add(createPlayerResultPanel());
		
	}
	
	public void setPanelColor(Color c)
	{
		this.panelColor = c;
		this.setBackground(this.panelColor);
		dealerResultPanel.setBackground(this.panelColor);
		playerResultPanel.setBackground(this.panelColor);
		
	}

	public void setPlayer(String name)
	{
		this.playerName = name;
		this.lblPlayer.setText("Player: " + this.playerName);
	}
	
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
		
		playerResultPanel.add(lblPlayer);
		playerResultPanel.add(lblPWins);
		playerResultPanel.add(lblPLosses);
		playerResultPanel.add(lblPWinnings);

		return playerResultPanel;
	}

	private JPanel createDealerResultPanel()
	{
		dealerResultPanel = new JPanel();
		dealerResultPanel.setBackground(this.panelColor);
		dealerResultPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

 		lblDealer = new JLabel("Dealer: Bob");
		lblDealer.setPreferredSize(this.labelDimension);
		lblDealer.setForeground(this.textColor);
		lblDealer.setBorder(BorderFactory.createEmptyBorder(5,10,0,0));
		
		lblDWins = new JLabel("Wins: 0");
		lblDWins.setPreferredSize(this.labelDimension);
		lblDWins.setForeground(this.textColor);
		lblDWins.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
		
		lblDLosses = new JLabel("Losses: 0");
		lblDLosses.setPreferredSize(this.labelDimension);
		lblDLosses.setForeground(this.textColor);
		lblDLosses.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
		
		dealerResultPanel.add(lblDealer);
		dealerResultPanel.add(lblDWins);
		dealerResultPanel.add(lblDLosses);
		
		return dealerResultPanel;
		
	}

}