/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaljava;

import java.util.Random;
import java.util.Stack;

/**
 *
 * @author J. Garcia, jyo.garcia at gmail.com
 */
public class Deck {
	public Stack<Card> cards;

	public void fill(){
		cards = new Stack<>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				cards.add(new Card(i,j));
			}
		}
		System.out.println(cards.size());
	}
	public void scramble(){
		Random rand = new Random();
		Stack<Card> temp = new Stack<>();
		for (int i = cards.size() -1 ; i > -1 ; i--){
			int index = rand.nextInt(i+1);
			temp.add(cards.remove(index));
		}
		cards = temp;
	}
	public void printDeck(){
		for (int i = 0; i < cards.size(); i++) {
			System.out.println(String.format("%d %s", i+1 ,  cards.get(i)));
		}
	}
	public void sort(){
		cards.sort((t, t1) -> {
			Integer a = t.getId();
			Integer b = t1.getId();
			return a.compareTo(b); //To change body of generated lambdas, choose Tools | Templates.
		});
	
	}
	
	public void flip(){
		Stack<Card> temp = new Stack<>();
		for (int i = cards.size() - 1 ; i > -1 ; i--){
			temp.add(cards.remove(i));
		}
		cards = temp;
	}

	public Card remove(Card c){
		Card found = null;
		for (int i = 0; i < cards.size(); i++) {
			if (c.toString().compareTo(cards.get(i).toString()) == 0 ) {
				found = cards.remove(i);
			}
		}
		return found;
	}

	public static void main(String[] args) {
		// Deck instance
		Deck d = new Deck();
		// Fill deck
		System.out.println("********************************************************************************");
		System.out.println("Filling deck:"); 
		System.out.println("********************************************************************************");
		d.fill();
		d.printDeck();

		// Flip order
		System.out.println("********************************************************************************");
		System.out.println("Flipping deck:"); 
		System.out.println("********************************************************************************");
		d.flip();
		d.printDeck();

		// Removing cards
		Card temp = null;
		System.out.println("********************************************************************************");
		System.out.println("Taking out cards:"); 
		System.out.println("********************************************************************************");
		temp = d.remove(new Card(Card.type.SPADES.ordinal(), Card.values.V10.ordinal()));
		System.out.println(String.format("Removed: %s", 
				(temp != null) ? temp.toString() : "none"));
		temp = d.remove(new Card(Card.type.DIAMONDS.ordinal(), Card.values.K.ordinal()));
		System.out.println(String.format("Removed: %s", 
				(temp != null) ? temp.toString() : "none"));
		temp = d.remove(new Card(Card.type.DIAMONDS.ordinal(), Card.values.V3.ordinal()));
		System.out.println(String.format("Removed: %s", 
				(temp != null) ? temp.toString() : "none"));
		d.scramble();
		System.out.println("********************************************************************************");
		System.out.println("Cards left: " + d.cards.size());
		System.out.println("********************************************************************************");
		d.printDeck();

		// Sorting
		System.out.println("********************************************************************************");
		System.out.println("Scrambled:");
		System.out.println("********************************************************************************");
		d.scramble();
		d.printDeck();
		System.out.println("********************************************************************************");
		System.out.println("Ordered:");
		System.out.println("********************************************************************************");
		d.sort();
		d.printDeck();
	}
	
}
