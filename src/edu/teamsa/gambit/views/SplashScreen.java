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

/**
 * Method for creating the initial splash screen when the GUI program is launched
 * Extends JPanel
 * @author Team Something Awesomes
 *
 */
@SuppressWarnings("serial")
public class SplashScreen extends JPanel
{
	private JButton start;
	private JButton quit;
	
	/**
	 * Constructor for creating the splash screen
	 */
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

	/**
	 * Getter for returning the start button if selected
	 * @return -start
	 */
	public JButton getStart()
	{
		return this.start;
	}

	/**
	 * Getter for returning the quit button if selected
	 * @return - quit
	 */
	public JButton getQuit()
	{
		return this.quit;
	}
	
}
