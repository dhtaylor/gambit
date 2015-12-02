/*
 * Assignment	Group Project
 * Program		Gambit
 * Author		Team Something Awesomes
 * Date			Nov 5, 2015
 *
 */

package edu.teamsa.gambit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This is the main class for the Gambit application.
 * 
 * @author Team Something Awesomes
 *
 */
@SuppressWarnings("serial")
public class Gambit extends JFrame
{

	private String appName = "Gambit";
	private JPanel gameArea;
	
	public static void main(String[] args)
	{
		new Gambit().run();
	}
	
	public Gambit()
	{
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 450);
		this.getContentPane().setBackground(new Color(7, 99, 36));
		this.setTitle(appName);
		
		gameArea = new JPanel();
		gameArea.setLayout(new BorderLayout());
		gameArea.setBackground(new Color(7, 99, 36));
		this.getContentPane().add(gameArea, BorderLayout.CENTER);
		
		JLabel lblGame = new JLabel(this.getAppName().toUpperCase());
		lblGame.setHorizontalAlignment(JLabel.CENTER);
		lblGame.setFont(new Font("Garamond", Font.BOLD, 36));
		lblGame.setForeground(new Color(240, 186, 0));
		lblGame.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		this.getContentPane().add(lblGame, BorderLayout.NORTH);
		
	}
	
	public void run()
	{
		displaySplash();
		this.setVisible(true);
		
	}

	public String getAppName()
	{
		return this.appName;
	}
	
	public void displaySplash()
	{
		SplashScreen splash = new SplashScreen();
		
		gameArea.add(splash, BorderLayout.CENTER);
		
		splash.getStart().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				splash.destroy();
				
			}
		});
		
		splash.getQuit().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		
	}
	
}
