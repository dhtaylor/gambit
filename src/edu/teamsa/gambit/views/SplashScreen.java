/*
 * Assignment	gambit
 * Program		SplashScreen
 * Author		Dandy H. Taylor
 * Date			Dec 1, 2015
 *
 */

package edu.teamsa.gambit.views;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SplashScreen extends JPanel
{
	private JButton start;
	private JButton quit;
	
	public SplashScreen()
	{
		super();
		this.setPreferredSize(new Dimension(100, 50));
		this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		this.setOpaque(false);
		this.setLayout(new GridLayout(4, 1, 10, 10));

		this.start = new JButton("Start New Game");
		this.quit = new JButton("Quit");

		this.add(this.start);
		this.add(this.quit);

	}

	public JButton getStart()
	{
		return this.start;
	}

	public JButton getQuit()
	{
		return this.quit;
	}
	
}
