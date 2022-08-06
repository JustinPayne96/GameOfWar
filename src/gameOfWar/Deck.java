package gameOfWar;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck extends LinkedList<Card>{
	private final List<String> ranks = List.of("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace");
	private final List<String> suits = List.of("Hearts", "Diamonds", "Spades", "Clubs");
	
	public Deck() {
		for(int rankPos = 0; rankPos < ranks.size(); rankPos++) {
			int value = rankPos + 2;
			String rank = ranks.get(rankPos);
			
			for(String suit : suits) {
				add(new Card(suit, rank, value));				
			}
		}
	}

	@Override
	public String toString() {

		StringBuilder b = new StringBuilder();
		
		b.append("List of Cards:").append(System.lineSeparator());
		
		for(Card card : this) {
			b.append(" >> ").append(card).append(System.lineSeparator());
		}
		return b.toString();
	}

	public void shuffle() {
		Collections.shuffle(this);		
	}	
}
