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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.teamsa.gambit.views.CardPanel;
import edu.teamsa.gambit.views.PlayerControlPanel;
import edu.teamsa.gambit.views.ResultPanel;
import edu.teamsa.gambit.views.SplashScreen;

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
	private PlayerControlPanel playerControlPanel;
	private CardPanel cardPanel;
	private ResultPanel resultPanel;
	
	private JLabel lblFooter;
	
	private Color applicationBackground = new Color(1, 28, 71);
//	private Color applicationBackground = new Color(7, 99, 36);
	private Color applicationText = new Color(240, 186, 0);
	
	private User user;
	
	/**
	 * This is the main entry point to the Gambit game.
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args)
	{
		new Gambit().run();
	}
	
	/**
	 * Constructor for the Gambit black jack game. This method sets up the
	 * application size and background as well as the title.
	 * 
	 */
	public Gambit()
	{
		// Set up the JFrame
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 750, 550);
		this.getContentPane().setBackground(applicationBackground);
		this.setTitle(this.appName);
		
		// Get the Application Label
		JLabel lblGame = new JLabel(this.appName.toUpperCase());
		lblGame.setHorizontalAlignment(JLabel.CENTER);
		lblGame.setFont(new Font("Garamond", Font.BOLD, 36));
		lblGame.setForeground(applicationText);
		lblGame.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		this.getContentPane().add(lblGame, BorderLayout.NORTH);

		// Set up the game area
		gameArea = new JPanel();
		gameArea.setLayout(new BorderLayout());
		gameArea.setBackground(applicationBackground);
		this.getContentPane().add(gameArea, BorderLayout.CENTER);
		
		lblFooter = new JLabel("Current Bet: $0");
		lblFooter.setHorizontalAlignment(JLabel.CENTER);
		lblFooter.setFont(new Font("Garamond", Font.BOLD, 36));
		lblFooter.setForeground(applicationText);
		lblFooter.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		//this.getContentPane().add(lblFooter, BorderLayout.SOUTH);
		
	}
	
	/**
	 * This is the main run method for the application. The majority of
	 * the calls to the separate classes for the game will happen in this
	 * area.
	 * 
	 */
	public void run()
	{
		displaySplash();
		this.setVisible(true);
		
	}
	
	public void displaySplash()
	{
		// Get Spacers to center the buttons
		JPanel leftSpacer = new JPanel();
		leftSpacer.setPreferredSize(new Dimension(150, 100));
		leftSpacer.setOpaque(false);
		
		JPanel rightSpacer = new JPanel();
		rightSpacer.setPreferredSize(new Dimension(150, 100));
		rightSpacer.setOpaque(false);

		gameArea.add(leftSpacer, BorderLayout.WEST);
		gameArea.add(rightSpacer, BorderLayout.EAST);

		// Get the Splash Screen to display
		SplashScreen splash = new SplashScreen();
		gameArea.add(splash, BorderLayout.CENTER);
		
		// Add the listeners to the splashscreen buttons.
		splash.getStart().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				// Remove the splash screen
				gameArea.remove(splash);
				gameArea.repaint();

				// Get the main game area
				setupGame();
				
			}
		});
		
		splash.getQuit().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
	}
	
	private void setupGame()
	{
		user = new User(this.getUserName());
		
		createPlayerControlPanel();
		createResultPanel();
		createCardPanel();
		gameArea.validate();
		gameArea.repaint();

		this.getContentPane().add(lblFooter, BorderLayout.SOUTH);
		this.validate();
		this.repaint();
	}
	
	public void createPlayerControlPanel()
	{
		playerControlPanel = new PlayerControlPanel();
		playerControlPanel.setPanelColor(applicationBackground);
		playerControlPanel.setTextColor(applicationText);
		gameArea.add(playerControlPanel, BorderLayout.WEST);
		
		playerControlPanel.getQuit().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
	}
	
	public void createResultPanel()
	{
		resultPanel = new ResultPanel();
		resultPanel.setPanelColor(applicationBackground);
		resultPanel.setTextColor(applicationText);
		resultPanel.setPlayer(user.pName);
		gameArea.add(resultPanel, BorderLayout.EAST);
	
	}
	
	public void createCardPanel()
	{
		cardPanel = new CardPanel();
		//cardPanel.setPanelColor(applicationBackground);
		gameArea.add(cardPanel, BorderLayout.CENTER);
	}
	
	public String getUserName()
	{
		String userName = null;
		
		while(userName == null || userName.equals(""))
		{
			userName = (String)JOptionPane.showInputDialog(
	                this,
	                "Please Enter Your Name:",
	                "User Name Input",
	                JOptionPane.PLAIN_MESSAGE,
	                null,
	                null,
	                null);

		}

		return userName;
		
	}
	
}
