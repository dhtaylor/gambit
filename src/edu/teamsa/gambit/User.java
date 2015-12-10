package edu.teamsa.gambit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

/**
 * Extends the Player class
 * Methods for processing the User information, storing and retrieving the user information from a serialized file
 * Processing the bank and the results of the game and the player's stats
 * @author Team Something Awesomes
 *
 */
public class User extends Player {
	
	/** Player Name */
	public String pName;
	/** Value of the current bet */
	public int currentBet;
	/** Value of the user's bank */
	public int bank;
	/**  Number of games won by the player */
	public int wins;
	/**  Number of games lost by the player */
	public int lost;
	/**  Amount of money won by the player */
	public int moneyWon;
	/**  Amount of money lost by the player */
	public int moneyLost;
	/** Name of the file with the saved user information */
	private String filename;
	
	/**
	 * Constructor for the User class - sets the name of the user
	 * @param name - name of the user
	 */
	public User(String name)
	{
		this.pName = name;
		this.filename = (name + ".gambit").toLowerCase();
	}
	
	/**
	 * Returns the value of the users bank
	 * @return the value of the bank
	 * 
	 */
	public int getBank()
	{
		return bank;
	}
	
	/**
	 * Sets the default bank value for the user
	 */
	public void setBank()
	{
		this.bank = 250;
	}
	
	/**
	 * Takes the amount of the user's bet and sets the currentBet value and then subtracts that amount from the bank
	 * @param amount - amount of the user's bet
	 */
	public void placeBet(int amount)
	{
		currentBet = amount;
		bank = bank - currentBet;
	}
	
	/**
	 * Processes the results of the game and then adjusts the user's bank accordingly
	 * @param result - the result of the game 
	 */
	public void gameResults(String result)
	{
		if (result == "Blackjack")
		{
			bank = bank + ((currentBet * 2) * 2);
			wins ++;
			moneyWon = moneyWon + currentBet;
		}
		if (result == "Player")
		{
			bank = bank + (currentBet * 2);
			wins ++;
			moneyWon = moneyWon + currentBet;
		}
		if (result == "Dealer")
		{
			lost ++;
			moneyLost = moneyLost + currentBet;
		}
		if (result == "Push")
		{
			bank = bank + currentBet;
		}
		if (bank <= 0)
		{
			int reply = JOptionPane.showConfirmDialog(null, "You are out of money, would you like some more?", "Busted!!", JOptionPane.YES_NO_OPTION);
			
			if (reply == JOptionPane.YES_OPTION)
			{			
				setBank();
			}
			else {
				JOptionPane.showMessageDialog(null, "Thanks, come again");
				System.exit(0);
			}
			
		}
		
	}
	
	/**
	 * 
	 * @return wins - number of games won by the user
	 */
	public int getWins()
	{
		return this.wins;
	}
	
	/**
	 * 
	 * @return lost - number of games lost by the user
	 */
	public int getLost()
	{
		return this.lost;
	}
	
	/**
	 * 
	 * @return (moneyWon - moneyLost) - returns the net winning/losses by the user
	 */
	public int getNetWinnings()
	{
		return moneyWon - moneyLost;
	}
	
	/**
	 * Saves the user's name and bank value out to a a file called Gambit.bj
	 */
	public void save()
	{
		try (ObjectOutputStream outputObj = new ObjectOutputStream(new FileOutputStream(filename)))
    	{
    		outputObj.writeObject(pName);
			outputObj.writeObject(bank);
			outputObj.writeObject(wins);
			outputObj.writeObject(lost);
			outputObj.writeObject(moneyWon);
			outputObj.writeObject(moneyLost);
    		outputObj.close();
    		
    	} catch (FileNotFoundException e)
    	{
    		System.err.println(e.getMessage());
    	} catch (IOException e)
    	{
    		System.err.println(e.getMessage());
    	} finally { }
    }
	
	/**
	 * Loads a saved game and sets the user name and bank value.
	 * If a file is not found, it calls the save method and creates the file
	 */
	public void load()
	{
		try (ObjectInputStream inputObj = new ObjectInputStream(new FileInputStream(filename)))
    	{
    		pName = (String) inputObj.readObject();
    		bank = (int) inputObj.readObject();
    		wins = (int) inputObj.readObject();
    		lost = (int) inputObj.readObject();
    		moneyWon = (int) inputObj.readObject();
    		moneyLost = (int) inputObj.readObject();
    		inputObj.close();
    	}catch (FileNotFoundException e)
    	{
    		createNewUser();
    	}catch (IOException e)
    	{
    		e.printStackTrace();
    	}catch (Exception e)
    	{
    		e.printStackTrace();
    	}
	}
	
	/**
	 * If there is no file found for the user - this method setups the user with default vaules
	 * and saves/creates the file
	 */
	public void createNewUser()
	{
		setBank();
		this.wins = 0;
		this.lost = 0;
		this.moneyWon = 0;
		this.moneyLost = 0;
		this.save();
	}
}
