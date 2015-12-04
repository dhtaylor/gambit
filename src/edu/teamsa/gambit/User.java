package edu.teamsa.gambit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class User extends Player {
	
	/** Player Name */
	public String pName;
	/** Value of the current bet */
	public int currentBet;
	/** Value of the user's bank */
	public int bank;
	/** Name of the file with the saved user information */
	private String filename = "Gambit.bj";
	
	/**
	 * Constructor for the User class - sets the name of the user
	 * @param name - name of the user
	 */
	public User(String name)
	{
		this.pName = name;
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
		}
		if (result == "Player")
		{
			bank = bank + (currentBet * 2);
		}
		if (bank <= 0)
		{
			int reply = JOptionPane.showConfirmDialog(null, "You are out of money, would you like some more?", "Busted!!", JOptionPane.YES_NO_OPTION);
			
			if (reply == JOptionPane.YES_OPTION)
			{			
				bank = 250;
			}
			else {
				JOptionPane.showMessageDialog(null, "Thanks, come again");
				System.exit(0);
			}
			
		}
		
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
    		inputObj.close();
    	}catch (FileNotFoundException e)
    	{
    		this.save();
    	}catch (IOException e)
    	{
    		e.printStackTrace();
    	}catch (Exception e)
    	{
    		e.printStackTrace();
    	}
	}
}
