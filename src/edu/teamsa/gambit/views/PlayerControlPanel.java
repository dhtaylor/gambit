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
	
	public PlayerControlPanel()
	{
		super();
		this.setLayout(new GridLayout(0,1,0,0));
		this.setBorder(this.defaultBorder);
		this.setPreferredSize(this.panelDimension);
		this.setBackground(this.panelColor);

		this.lblBank = new JLabel("Bank: $0");
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
		this.quit = new JButton("Quit");
		
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

	public JButton getQuit()
	{
		return this.quit;
	}
	
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
