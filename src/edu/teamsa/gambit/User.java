package edu.teamsa.gambit;

public class User extends Player {
	
	String pName;
	int currentBet;
	int bank;
	
	User(String name){
		this.pName = name;
	}
	
	public void placeBet(int amount){
		//todo bet logic
	}
	
	public void save(){
		//todo save logic
	}
}
