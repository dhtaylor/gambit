/*
 * Assignment	gambit
 * Program		PlayerControlPanel
 * Author		Dandy H. Taylor
 * Date			Dec 1, 2015
 *
 */

package edu.teamsa.gambit.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;


/**
 * Method for creating the GUI Player Control Panel that displays player information about
 * current bank amount, bet values and setups the buttons for place bet, hit, stay and quit
 * @author Team Something Awesomes
 *
 */
@SuppressWarnings("serial")
public class PlayerControlPanel extends JPanel
{
	private Dimension panelDimension = new Dimension(150, 550);
	private Dimension labelDimension = new Dimension(150, 15);
	private Border defaultBorder = BorderFactory.createEmptyBorder(10,10,10,10);
	private Color panelColor = new Color(255, 255, 255);
	private Color textColor = new Color(0, 0, 0);
	
	private JLabel lblBank;
	private ButtonGroup buttonGroup;
	private JRadioButton five;
	private JRadioButton ten;
	private JRadioButton twenty;
	private JRadioButton fifty;
	private JRadioButton max;
	
	private JButton placeBet;
	private JButton hit;
	private JButton stay;
	private JButton quit;
	
	private int bankAmount;
	
	/**
	 * Constructor for creating the Player Control Panel
	 * @param bankAmount - player's bank amount
	 */
	public PlayerControlPanel(int bankAmount)
	{
		super();
		this.setLayout(new GridLayout(0,1,0,0));
		this.setBorder(this.defaultBorder);
		this.setPreferredSize(this.panelDimension);
		this.setBackground(this.panelColor);

		this.bankAmount = bankAmount;
		this.lblBank = new JLabel("Bank: $" + bankAmount);
		this.lblBank.setFont(new Font("arial", Font.BOLD, 14));
		this.lblBank.setPreferredSize(this.labelDimension);
		this.setForeground(this.textColor);
		
		this.five = new JRadioButton("$5");
		this.five.setForeground(this.textColor);
		
		this.ten = new JRadioButton("$10");
		this.ten.setForeground(this.textColor);
		
		this.twenty = new JRadioButton("$20");
		this.twenty.setForeground(this.textColor);
		
		this.fifty = new JRadioButton("$50");
		this.fifty.setForeground(this.textColor);
		
		this.max = new JRadioButton("All In!");
		this.max.setForeground(this.textColor);
		
		this.buttonGroup = new ButtonGroup();
		this.buttonGroup.add(this.five);
		this.buttonGroup.add(this.ten);
		this.buttonGroup.add(this.twenty);
		this.buttonGroup.add(this.fifty);
		this.buttonGroup.add(this.max);

		this.placeBet = new JButton("Place Bet");
		this.hit = new JButton("Hit");
		this.stay = new JButton("Stay");
		this.quit = new JButton("Quit");
		
		this.hit.setEnabled(false);
		this.stay.setEnabled(false);
		
		this.add(this.lblBank);
		this.add(this.five);
		this.add(this.ten);
		this.add(this.twenty);
		this.add(this.fifty);
		this.add(this.max);
		this.add(this.placeBet);
		this.add(this.hit);
		this.add(this.stay);
		this.add(this.quit);
		
	}
	
	/**
	 * Getter for the value of the radio button five
	 * @return - value of the radio button - five
	 */
	public JRadioButton getFive()
	{
		return five;
	}

	/**
	 * Getter for the value of the radio button ten
	 * @return - value of the radio button - ten
	 */
	public JRadioButton getTen()
	{
		return ten;
	}

	/**
	 * Getter for the value of the radio button twenty
	 * @return - value of the radio button - twenty
	 */
	public JRadioButton getTwenty()
	{
		return twenty;
	}

	/**
	 * Getter for the value of the radio button fifty
	 * @return - value of the radio button - fifty
	 */
	public JRadioButton getFifty()
	{
		return fifty;
	}

	/**
	 * Getter for the value of the radio button max
	 * @return - value of the radio button - max bet aka bank value
	 */
	public JRadioButton getMax()
	{
		return max;
	}

	/**
	 * Returns the button name that was selected - PlaceBet
	 * @return - placeBet
	 */
	public JButton getPlaceBet()
	{
		return placeBet;
	}

	/**
	 * Returns the button name that was selected - Hit
	 * @return - hit
	 */
	public JButton getHit()
	{
		return hit;
	}

	/**
	 * Returns the button name that was selected - Stay
	 * @return - stay
	 */
	public JButton getStay()
	{
		return stay;
	}

	/**
	 * Returns the button name that was selected - Quit
	 * @return - quit
	 */
	public JButton getQuit()
	{
		return this.quit;
	}
	
	/**
	 * Sets the bank amount label
	 * @param bankAmount - value of the current bank amount
	 */
	public void setBankLabel(int bankAmount)
	{
		this.bankAmount = bankAmount;
		lblBank.setText("Bank: $" + bankAmount);
	}
	
	/**
	 * Sets the color of the panel
	 * @param c
	 */
	public void setPanelColor(Color c)
	{
		this.panelColor = c;
		this.setBackground(this.panelColor);
		
		Component[] components = this.getComponents();
		
		for (int i = 0; i < components.length; i++)
		{
			if (!(components[i] instanceof JButton))
				components[i].setBackground(this.panelColor);
		}
	}

	/**
	 * Sets the color of the text in the panel
	 * @param c
	 */
	public void setTextColor(Color c)
	{
		this.textColor = c;

		Component[] components = this.getComponents();
		
		for (int i = 0; i < components.length; i++)
		{
			if (!(components[i] instanceof JButton))
				components[i].setForeground(this.textColor);
			
		}

	}
	
	/**
	 * Getter for retrieving the current bet value
	 * @return - value of the current bet selected by the player
	 */
	public int getSelectedBetValue()
	{
		if (five.isSelected())
			return 5;
		
		if (ten.isSelected())
			return 10;
		
		if (twenty.isSelected())
			return 20;
		
		if (fifty.isSelected())
			return 50;
		
		if (max.isSelected())
			return this.bankAmount;
		
		return 0;
	}
	
	/**
	 * Clears the displayed Selected Bet Value
	 */
	public void clearSelectedBetValue()
	{
		this.buttonGroup.clearSelection();
	}
	
	/**
	 * Disabled Bet selection values after the user has selected place bet
	 * and is playing their hand
	 */
	public void disableButtonGroup()
	{
		this.five.setEnabled(false);
		this.ten.setEnabled(false);
		this.twenty.setEnabled(false);
		this.fifty.setEnabled(false);
		this.max.setEnabled(false);

	}
	
	/**
	 * Enables the Bet selection values for the player to select a bet amount
	 */
	public void enableButtonGroup()
	{
		this.five.setEnabled(true);
		this.ten.setEnabled(true);
		this.twenty.setEnabled(true);
		this.fifty.setEnabled(true);
		this.max.setEnabled(true);
		
	}
	
}
