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
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class PlayerControlPanel extends JPanel
{
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
	
	private Color panelColor = new Color(255, 255, 255);
	private Color textColor = new Color(0, 0, 0);
	
	public PlayerControlPanel()
	{
		super();
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		this.setPreferredSize(new Dimension(100, 550));
		this.setBackground(this.panelColor);

		this.lblBank = new JLabel("Bank: $");
		this.lblBank.setFont(new Font("arial", Font.BOLD, 14));
		this.setForeground(this.textColor);
		
		this.five = new JRadioButton("$5");
		this.five.setForeground(this.textColor);
		
		this.ten = new JRadioButton("$10");
		this.ten.setForeground(this.textColor);
		
		this.twenty = new JRadioButton("$20");
		this.twenty.setForeground(this.textColor);
		
		this.fifty = new JRadioButton("$50");
		this.fifty.setForeground(this.textColor);
		
		this.max = new JRadioButton("Max");
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
		
		this.add(this.lblBank);
		this.add(this.five);
		this.add(this.ten);
		this.add(this.twenty);
		this.add(this.fifty);
		this.add(this.max);
		this.add(this.placeBet);
		this.add(this.hit);
		this.add(this.stay);
		
	}

	public JRadioButton getFive()
	{
		return five;
	}

	public JRadioButton getTen()
	{
		return ten;
	}

	public JRadioButton getTwenty()
	{
		return twenty;
	}

	public JRadioButton getFifty()
	{
		return fifty;
	}

	public JRadioButton getMax()
	{
		return max;
	}

	public JButton getPlaceBet()
	{
		return placeBet;
	}

	public JButton getHit()
	{
		return hit;
	}

	public JButton getStay()
	{
		return stay;
	}

	public void setPanelColor(Color c)
	{
		this.panelColor = c;
		this.setBackground(this.panelColor);
	}

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
	
}
