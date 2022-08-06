package gameOfWar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Player {
	
	private String name;
	private int score = 0;
	
	List<Card> hand = new ArrayList<Card>();

	public Player(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public void draw(Deck deck) {
		hand.add(deck.remove(0));
	}
	
	public List<Card> getHand() {
		
		return hand;
	}
	
	public Card flip() {

		return hand.remove(0);
	}
	
	public void incrementScore() {
		score += 1;	
	}
	
	public String getName() {
		
		return name;
	}
	
	public int getScore() {
		return score;
	}
}
