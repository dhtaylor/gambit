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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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
	private Color applicationText = new Color(240, 186, 0);
	
	private User user;
	private Dealer dealer;
	private Deck deck;
	
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
		
		this.addWindowListener(new WindowListener(){
			public void windowOpened(WindowEvent e){ }
			public void windowClosed(WindowEvent e){ }
			public void windowIconified(WindowEvent e){ }
			public void windowDeiconified(WindowEvent e){ }
			public void windowActivated(WindowEvent e){ }
			public void windowDeactivated(WindowEvent e){ }

			public void windowClosing(WindowEvent e){
				if (user != null)
					user.save();				
			}
		});
		
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
		user.load();
		
		dealer = new Dealer();
		deck = dealer.getDeck();
		
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
		playerControlPanel = new PlayerControlPanel(user.getBank());
		playerControlPanel.setPanelColor(applicationBackground);
		playerControlPanel.setTextColor(applicationText);
		gameArea.add(playerControlPanel, BorderLayout.WEST);
		
		playerControlPanel.getHit().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				user.hit(deck);
				user.checkAces();
				
				if (user.getHandValue() > 21)
				{
					bustUser();
					return;
				}
				
				printHands();
			}

		});
		
		playerControlPanel.getPlaceBet().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (dealer.checkTooFewCards(deck));
					deck = dealer.getDeck();
				
				int amount = playerControlPanel.getSelectedBetValue();
				
				if (amount > user.getBank())
				{
					JOptionPane.showMessageDialog(
							  null
							, String.format("Bet is larger than amount in bank.%nPlease select a value less than or equal to current bank value of $%d.", user.getBank())
							, "Bank Exceeded"
							, JOptionPane.WARNING_MESSAGE
					);
					
					return;
				}
				
				if (amount > 0)
				{
					// Set Bet
					user.placeBet(amount);
					lblFooter.setText("Current Bet: $" + amount);
					playerControlPanel.setBankLabel(user.getBank());
					playerControlPanel.getPlaceBet().setEnabled(false);
					playerControlPanel.getHit().setEnabled(true);
					playerControlPanel.getStay().setEnabled(true);
					playerControlPanel.clearSelectedBetValue();
					
					// Deal hand
					Card c1 = user.hit(deck);
					c1.flip();
					cardPanel.getUserCards().add(c1);
					
					dealer.hit(deck);
					user.hit(deck);
					dealer.hit(deck);
					
					System.out.println(deck.size());
					
					printHands();
					
				}
				
			}
		});
		
		playerControlPanel.getQuit().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				user.save();
				System.exit(0);
			}
		});
		
		playerControlPanel.getStay().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				do
				{
					dealer.checkAces();
					
					if (dealer.getHandValue() >= dealer.getLimit())
						dealer.setHardLimit(true);

					if (dealer.getHandValue() < dealer.getLimit())
						dealer.hit(deck);
					
				}
				while(dealer.getHandValue() >= dealer.getLimit() && !dealer.isHardLimit());

				if (dealer.getHandValue() > 21)
				{
					bustDealer();
					return;
				}
				
				printHands();
				
				
				if (dealer.getHandValue() > user.getHandValue())
				{
					System.out.println("Dealer Wins!");
				}
				else
				{
					System.out.println("User Wins!");
					user.gameResults("Player");
				}

				dealer.clearHand();
				user.clearHand();
				
				lblFooter.setText("Current Bet: $0");
				playerControlPanel.getPlaceBet().setEnabled(true);
				playerControlPanel.getHit().setEnabled(false);
				playerControlPanel.getStay().setEnabled(false);
				playerControlPanel.setBankLabel(user.getBank());	
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

	public void printHands(){
		System.out.println("Player:: " + user.currentHand + ":: " + user.getHandValue());
		System.out.println("Dealer:: " + dealer.currentHand + ":: " + dealer.getHandValue());
		

	}
	
	private void bustUser()
	{
		lblFooter.setText("Current Bet: $0");
		user.clearHand();
		dealer.clearHand();
		playerControlPanel.getPlaceBet().setEnabled(true);
		playerControlPanel.getHit().setEnabled(false);
		playerControlPanel.getStay().setEnabled(false);

		JOptionPane.showMessageDialog(
				  null
				, String.format("You Busted! House Wins!")
				, "Bank Exceeded"
				, JOptionPane.WARNING_MESSAGE
		);
		
		return;
	}

	private void bustDealer()
	{
		user.gameResults("Player");
		lblFooter.setText("Current Bet: $0");
		user.clearHand();
		dealer.clearHand();
		playerControlPanel.getPlaceBet().setEnabled(true);
		playerControlPanel.getHit().setEnabled(false);
		playerControlPanel.getStay().setEnabled(false);
		playerControlPanel.setBankLabel(user.getBank());
		
		System.out.println("Dealer Busts!");
		
		return;
	}

}
