/*
 * Assignment	gambit
 * Program		CardPanel
 * Author		Dandy H. Taylor
 * Date			Dec 3, 2015
 *
 */

package edu.teamsa.gambit.views;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class CardPanel extends JPanel
{
	private Border defaultBorder = BorderFactory.createEmptyBorder(10,10,10,10);
	private Color panelColor = new Color(7, 99, 36);
	
	public CardPanel()
	{
		super();
		this.setBorder(defaultBorder);
		this.setBackground(panelColor);
		
	}
	
	public void setPanelColor(Color c)
	{
		this.panelColor = c;
		this.setBackground(this.panelColor);
	}
	
}
