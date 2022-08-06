package gameOfWar;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class App {
	
	List<String> names = List.of("Justin", "Adam", "Aleks", "Chris", "Ronald");
	Random random = new Random();
	
	public static void main(String[] args) {
		new App().run();
		

	}

	private void run() {
		
		/*
		 * Below Calls the Two Players Randomly from the List.
		 */
		
		List<String> playerNames = new LinkedList<>(names);
		Player player1 = addPlayer(playerNames);
		Player player2 = addPlayer(playerNames);
		
		//System.out.println(player1.getName() + " vs. " + player2.getName());
		
		
		//System.out.println("Player 1: " + player1);
		//System.out.println("Player 2: " + player2);
		
		/*
		 * Below Create a Deck and Shuffles the Deck. 
		 */
		
		Deck deck = new Deck();
		deck.shuffle();
		
		//System.out.println(deck);
		
		/*
		 * Below Deals Hands to Both Players
		 */
		
		deal(deck, player1, player2);
		//System.out.println(player1 + "'s Hand: " + player1.getHand());
		//System.out.println(player2 + "'s Hand: " + player2.getHand());
		
		
		/*
		 * Below Plays a Game of War
		 */
		
		playGameOfWar(player1, player2);
		
		/*
		 * Below Announces Who Won Along With Scores
		 */
		
		announceWinner(player1, player2);
		
	}
	
	/*
	 * Methods Listed Below
	 */
	
	private void announceWinner(Player player1, Player player2) {
		if(player1.getScore() > player2.getScore()) {
			printWinner(player1);
			printLoser(player2);
		}
		else if(player2.getScore() > player1.getScore()) {
			printWinner(player2);
			printLoser(player1);
		}
		else {
			printTie(player1, player2);
		}
		
	}

	private void printTie(Player player1, Player player2) {
		System.out.println(player1.getName() + " and " + player2.getName() + "Tied! - Score: " + player1.getScore() + ".");
		
	}

	private void printLoser(Player loser) {
		System.out.println("Loser... " + loser.getName() + " - Score: " + loser.getScore() + "." );
		
	}

	private void printWinner(Player winner) {
	System.out.println("Winner!! " + winner.getName() + " - Score: " + winner.getScore() + ".");
	
}

	private void playGameOfWar(Player player1, Player player2) {
		int turns = player1.getHand().size();
	
		for(int turn = 0; turn < turns; turn++) {
		Card cardOne = player1.flip();
		Card cardTwo = player2.flip();
		
			if(cardOne.getValue() > cardTwo.getValue()) {
			player1.incrementScore();
		}
			else if(cardTwo.getValue() > cardOne.getValue()) {
			player2.incrementScore();
		}
	}
		
		
	}

	private void deal(Deck deck, Player player1, Player player2) {
		int deckSize = deck.size();
		
		for(int i = 0; i < deckSize; i++) {
			if(i % 2 == 0) {
				player1.draw(deck);
			}
			else {
				player2.draw(deck);
			}
		}
		
	}

	private Player addPlayer(List<String> names) {
		
		int position = random.nextInt(names.size());
		String name = names.remove(position);
		return new Player(name);
		
	}

}
