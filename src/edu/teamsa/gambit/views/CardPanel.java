/*
 * Assignment	gambit
 * Program		CardPanel
 * Author		Dandy H. Taylor
 * Date			Dec 3, 2015
 *
 */

package edu.teamsa.gambit.views;

import java.awt.Color;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CardPanel extends JPanel
{
	private Color panelColor = new Color(7, 99, 36);
	
	public CardPanel()
	{
		super();
		this.setBackground(panelColor);
		
	}
	
	public void setPanelColor(Color c)
	{
		this.panelColor = c;
		this.setBackground(this.panelColor);
	}
	
}
