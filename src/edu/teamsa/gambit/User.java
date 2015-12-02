package edu.teamsa.gambit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class User extends Player {
	
	public String pName;
	public int currentBet;
	public int bank;
	private String filename = "Gambit.bj";
	
	User(String name){
		this.pName = name;
	}
	
	public int getBank()
	{
		return bank;
	}
	
	public void placeBet(int amount)
	{
		currentBet = amount;
		bank = bank - currentBet;
	}
	
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
	
	public void load()
	{
		try (ObjectInputStream inputObj = new ObjectInputStream(new FileInputStream(filename)))
    	{
    		pName = (String) inputObj.readObject();
    		bank = (int) inputObj.readObject();
    		inputObj.close();
    	}catch (FileNotFoundException e)
    	{
    		e.printStackTrace();
    	}catch (IOException e)
    	{
    		e.printStackTrace();
    	}catch (Exception e)
    	{
    		e.printStackTrace();
    	}
	}
}
