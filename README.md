# gambit
This is a test file for README.

Project Components
-GUI
	-Welcome Screen
		-menu to other screens
	-Play Screen
	-High Scores Screen
	-Event handling
-Deck of Cards
	-card values
	-card suits
		-(enum)
-Dealer AI
-Player choices
	-hit
	-stay
	-double down
	-bet value
-Scoring System
	-dolla bills yo!
-Running bank amount in a .txt file
	-write to the file
	-read from file for bank amount
	
Rules:
	when deck < 8 cards, grab discard and reshuffle.
	dealer must hit unless hard 17 or above
	
	
	Gameplay steps:
	1- Place bet
		--> at end of place bet call the dealHand method
	2- Deal initial cards
		-hit User X2
		-hit Dealer X2
	3- Player Turn
		-hit until stay or bust
		-if bust go to step 5.
	4- Dealer Turn
		-hit until hand total >=17, or bust.
	5- Evaluate hands
	6- Payout bets
	7- Play again, or save bank to file.
