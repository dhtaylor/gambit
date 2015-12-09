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
import java.util.Timer;

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
	private Color applicationWarning = new Color(168, 44, 20);
	
	
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
		createSplashPanel();
		this.setVisible(true);
		
	}
	
	/**
	 * This method sets up the initial state for the game. It creates and loads
	 * a user, based on name input from the user. It also creates a dealer, 
	 * instantiates a deck object, and generates the game area portion of the
	 * interface.
	 * 
	 */
	private void setupGame()
	{
		user = new User(this.getUserName());
		user.load();
		
		dealer = new Dealer();
		
		createPlayerControlPanel();
		createResultPanel();
		createCardPanel();
		gameArea.validate();
		gameArea.repaint();

		setupForNewHand();
		
		this.getContentPane().add(lblFooter, BorderLayout.SOUTH);
		this.validate();
		this.repaint();
	}
	
	/**
	 * This method instantiates a new ControlPanel and adds it to the
	 * left side of the game area. This panel represents the area
	 * where all of controls for playing the game will be
	 * displayed.
	 * 
	 */
	public void createPlayerControlPanel()
	{
		playerControlPanel = new PlayerControlPanel(user.getBank());
		playerControlPanel.setPanelColor(applicationBackground);
		playerControlPanel.setTextColor(applicationText);
		gameArea.add(playerControlPanel, BorderLayout.WEST);
		
		// Set up actions for when the player pushes the "Hit" button
		playerControlPanel.getHit().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				user.hit(deck);
				user.checkAces();
				refreshUserCardsPanel();

				if (user.getHandValue() > 21)
					bust("Player");
			}

		});
		
		// Set up actions for when the player pushes the "Place Bet" button
		playerControlPanel.getPlaceBet().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int amount = playerControlPanel.getSelectedBetValue();

				// Check to see if they didn't make a selection
				if (amount == 0)
				{
					warnInvalidBetAmount();
					return;
				}

				// Check to see if their selection exceeds the bank
				if (exceedsBank(amount))
					return;
				
				// Start the hand
				setupForNewHand();
				
				// Set Bet
				user.placeBet(amount);
				lblFooter.setText("Current Bet: $" + amount);
				toggleControlPanel();
					
				// Deal hand
				for (int i = 0; i < 2; i++)
				{
					user.hit(deck);
					refreshUserCardsPanel();
					
					dealer.hit(deck);
					cardPanel.getDealerCards().add(dealer.getHandCard(i));
					
					if (i == 0)
						dealer.getHandCard(0).flip();
					
					
				}
				
//				if (user.getHandValue() == 21)
//					playerControlPanel.getStay().doClick();
				
				//todo flip dealer card on all blackJack instances
				if(user.getHandValue() == 21 && dealer.getHandValue()==21){
					user.gameResults("Push");
					lblFooter.setText("Push");
					lblFooter.setForeground(applicationWarning);
					refreshDealerCardsPanel();
					endHand();
				}
					
					if (user.getHandValue() == 21)
					{
						user.gameResults("Blackjack");
						lblFooter.setText("Player Wins!");
						lblFooter.setForeground(applicationWarning);
						//flip dealer hand
						endHand();
					}

					if (dealer.getHandValue() == 21)
					{
						user.gameResults("Dealer");
						lblFooter.setText("House Wins!");
						lblFooter.setForeground(applicationWarning);
						//flip dealer hand
						endHand();
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
					dealer.checkAces(dealer.getLimit()); // checkAces() only works if HandValue > 21
					
					if (dealer.getHandValue() >= dealer.getLimit())
						dealer.setHardLimit(true);

					if (dealer.getHandValue() < dealer.getLimit())
						dealer.hit(deck);
					
				}
				while(dealer.getHandValue() <= dealer.getLimit() && !dealer.isHardLimit());

				refreshDealerCardsPanel();

				if (dealer.getHandValue() > 21)
				{
					bust("Dealer");
					return;
				}
				
				if (dealer.getHandValue() == user.getHandValue())
				{
					user.gameResults("Push");
					lblFooter.setText("Push!");
					lblFooter.setForeground(applicationWarning);
				}

				if (dealer.getHandValue() > user.getHandValue())
				{
					user.gameResults("Dealer");
					lblFooter.setText("House Wins!");
					lblFooter.setForeground(applicationWarning);
				}
				else if (dealer.getHandValue() < user.getHandValue())
				{
					user.gameResults("Player");
					lblFooter.setText("Player Wins!");
					lblFooter.setForeground(applicationWarning);
				}
				
				endHand();
				
			}
		});
	}
	
	/**
	 * This method instantiates a new ResultPanel and adds it to the
	 * right side of the game area. This panel represents the area
	 * where all of the statistics for the player and dealer will be
	 * displayed.
	 * 
	 */
	public void createResultPanel()
	{
		resultPanel = new ResultPanel();
		resultPanel.setPanelColor(applicationBackground);
		resultPanel.setTextColor(applicationText);
		resultPanel.setPlayer(user.pName);
		
		refreshResultPanel();
		
		gameArea.add(resultPanel, BorderLayout.EAST);
	
	}
	
	/**
	 * This method instantiates a new CardPanel and adds it to the
	 * center of the game area. This panel represents the area where
	 * all of the cards (player's and dealer's) will be displayed.
	 * 
	 */
	public void createCardPanel()
	{
		cardPanel = new CardPanel();
		gameArea.add(cardPanel, BorderLayout.CENTER);
	}
	
	/**
	 * This method prompts the user for their name that is
	 * then used for the name of the file where their statistics
	 * will be saved.
	 * 
	 * @return	Returns a String representing the player's name.
	 */
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
	
	/**
	 * This method displays the initial splash screen for
	 * the game that allows the user to start a game or quit
	 * immediately.
	 * 
	 */
	public void createSplashPanel()
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

	/**
	 * This method sets the footer label and passes game results so that the player or
	 * dealer are appropriately credited for a loss when they bust.
	 * 
	 * @param player	This is a string that represents the player that busted, "Player" or "Dealer"
	 * 
	 */
	private void bust(String player)
	{
		if (player.equals("Player"))
		{
			user.gameResults("Dealer"); // Seems backward, but if the player busts, the game results go to dealer.
			lblFooter.setText("You Busted! House Wins!");
		}
		else
		{
			user.gameResults("Player"); // Seems backward, but if the dealer busts, the game results go to player.
			lblFooter.setText("Dealer Busts!");
		}

		lblFooter.setForeground(applicationWarning);
		endHand();
	}
	
	/**
	 * This method resets the control panel for a new hand and updates the results
	 * panel with the results from the latest hand.
	 * 
	 */
	private void endHand()
	{
		toggleControlPanel();
		refreshResultPanel();
		
		/* Debugging Output */
		System.out.println("User Hand Value: " + user.getHandValue());
		System.out.println(user.currentHand);
		System.out.println("Dealer Hand value: " + dealer.getHandValue());
		System.out.println("HardLimit: "+dealer.isHardLimit());
		System.out.println(dealer.currentHand + "\n----------------\n");
		/* End debugging output */
		
	}

	/**
	 * This method updates the Result Panel with the latest information on wins and losses.
	 * 
	 */
	private void refreshResultPanel()
	{
		resultPanel.getLblDWins().setText(String.format("Wins: %d", user.getLost())); // This works on the assumption that a user loss is a dealer win.
		resultPanel.getLblDLosses().setText(String.format("Losses: %d", user.getWins())); // This works on the assumption that a user win is a dealer loss.
		resultPanel.getLblPWins().setText(String.format("Wins: %d", user.getWins()));
		resultPanel.getLblPLosses().setText(String.format("Losses: %d", user.getLost()));
		resultPanel.getLblPWinnings().setText(String.format("Winnings: $%d", user.getNetWinnings()));
	}

	/**
	 * This method will clear the UserCards panel that is part of the CardPanel and
	 * re-add the updated user hand to the UserCards panel, flipping the newly added
	 * card so all cards are face up.
	 * 
	 */
	private void refreshUserCardsPanel()
	{
		cardPanel.getUserCards().removeAll();
		
		for (Card c : user.currentHand)
		{
			if (user.currentHand.indexOf(c) == (user.currentHand.size() - 1))
				c.flip();
			
			cardPanel.getUserCards().add(c);
		}

		cardPanel.getUserCards().validate();
		cardPanel.getUserCards().repaint();
		
	}

	/**
	 * This method will clear the DealerCards panel that is part of the CardPanel and
	 * re-add the updated dealer hand to the DealerCards panel, flipping the newly added
	 * cards so all cards are face up.
	 * 
	 */
	private void refreshDealerCardsPanel()
	{
		cardPanel.getDealerCards().removeAll();
		
		for (Card c : dealer.currentHand)
		{
			if (dealer.currentHand.indexOf(c) > 0)
				c.flip();
			
			cardPanel.getDealerCards().add(c);
		}

		cardPanel.getDealerCards().validate();
		cardPanel.getDealerCards().repaint();
		
	}
	
	/**
	 * This method sets up for a new hand to be played. It will clear both the
	 * user and dealer hands and clear the CardPanel. In the dealer's case, it
	 * will also reset the hard limit boolean value to false. The final task that
	 * it completes is a check to see if there are less than or equal to 8 cards
	 * in the current deck and generates a new deck if that is the case.
	 * 
	 */
	private void setupForNewHand()
	{
		dealer.clearHand();
		dealer.setHardLimit(false);
		cardPanel.getDealerCards().removeAll();
		cardPanel.getDealerCards().validate();
		cardPanel.getDealerCards().repaint();
		
		user.clearHand();
		cardPanel.getUserCards().removeAll();
		cardPanel.getUserCards().validate();
		cardPanel.getUserCards().repaint();
		
		/* Debugging Output */
		System.out.println("User Hand Value: " + user.getHandValue());
		System.out.println(user.currentHand);
		System.out.println("Dealer Hand value: " + dealer.getHandValue());
		System.out.println("HardLimit: " + dealer.isHardLimit());
		System.out.println(dealer.currentHand + "\n----------------\n");
		/* End Debugging Output */
		
		lblFooter.setText("Current Bet: $0");
		lblFooter.setForeground(applicationText);
		
		if (deck == null || deck.size() <= 8)
			deck = dealer.getDeck();
		
	}

	/**
	 * This message shows a dialog box that warns the user that their bet has exceeded the amount
	 * they have in their bank.
	 * 
	 */
	private boolean exceedsBank(int amount)
	{
		if (amount > user.getBank())
		{
			JOptionPane.showMessageDialog(
					  null
					, String.format("Bet is larger than amount in bank.%nPlease select a value less than or equal to current bank value of $%d.", user.getBank())
					, "Bank Exceeded"
					, JOptionPane.WARNING_MESSAGE
			);

			return true;
		}
		
		return false;

	}
	
	/**
	 * This method displays a dialog box warning that the user has not selected
	 * a bet amount before clicking the "Place Bet" button. They cannot continue
	 * with the game until an amount is selected.
	 * 
	 */
	private void warnInvalidBetAmount()
	{
		JOptionPane.showMessageDialog(
				  null
				, String.format("Please enter a selection for the amount to bet.")
				, "Invalid Bet Amount"
				, JOptionPane.WARNING_MESSAGE
		);
	}

	/**
	 * This method toggles the buttons on the control panel based on what the user
	 * selects. After selecting a bet amount and clicking the "Place Bet" button,
	 * that button and the radio buttons are disabled while the "Hit" and "Stay"
	 * buttons are enabled for playing the hand. Once the hand is completed, the
	 * "Hit" and "Stay" buttons are disabled and the "Place Bet" and radio buttons
	 * are re-enabled. In both cases, the bank amount is refreshed.
	 * 
	 */
	private void toggleControlPanel()
	{
		playerControlPanel.setBankLabel(user.getBank());

		if (playerControlPanel.getPlaceBet().isEnabled())
		{
			playerControlPanel.clearSelectedBetValue();
			playerControlPanel.disableButtonGroup();
			playerControlPanel.getPlaceBet().setEnabled(false);
			playerControlPanel.getHit().setEnabled(true);
			playerControlPanel.getStay().setEnabled(true);
			
		}
		else
		{
			playerControlPanel.enableButtonGroup();
			playerControlPanel.getPlaceBet().setEnabled(true);
			playerControlPanel.getHit().setEnabled(false);
			playerControlPanel.getStay().setEnabled(false);
			
		}

	}

}
