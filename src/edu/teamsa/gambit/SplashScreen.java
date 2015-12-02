/*
 * Assignment	gambit
 * Program		SplashScreen
 * Author		Dandy H. Taylor
 * Date			Dec 1, 2015
 *
 */

package edu.teamsa.gambit;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SplashScreen extends JPanel
{
	private JButton start;
//	private JButton leaders;
//	private JButton losers;
	private JButton quit;
	
	public SplashScreen()
	{
		this.setSize(10, 10);
		this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		this.setOpaque(false);
		this.setLayout(new GridLayout(4, 1, 10, 10));

		start = new JButton("Start New Game");
		leaders = new JButton("Top Winners");
		losers = new JButton("Biggest Losers");
		quit = new JButton("Quit");

		this.add(start);
		this.add(leaders);
		this.add(losers);
		this.add(quit);

	}

	public void destroy()
	{
		this.removeAll();
		this.repaint();
		
	}

	public JButton getStart()
	{
		return this.start;
	}

//	public JButton getLeaders()
//	{
//		return this.leaders;
//	}
//
//	public JButton getLosers()
//	{
//		return this.losers;
//	}

	public JButton getQuit()
	{
		return this.quit;
	}
	
	
}
