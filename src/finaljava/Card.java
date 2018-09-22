/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaljava;

/**
 *
 * @author J. Garcia, jyo.garcia at gmail.com
 */
public class Card {

	private int id;

	public static enum type{
		HARTS,
		DIAMONDS,
		SPADES,
		CLOVERS
	}
	public static enum values{
		V1,
		V2,
		V3,
		V4,
		V5,
		V6,
		V7,
		V8,
		V9,
		V10,
		J,
		Q,
		K
	}
	public static String[] valueStrings = {
		"1",
		"2",
		"3",
		"4",
		"5",
		"6",
		"7",
		"8",
		"9",
		"10",
		"J",
		"Q",
		"K"
	};
	public static String[] typeStrings = {
		"Harts",
		"Diamonds",
		"Spades",
		"Cloves"
	};
	public static String[] colorStrings = {
		"red",
		"black"
	};
	private int type;
	private String color;
	private int value;
	private String rep;

	public Card(int type, int value) {
		this.type = type;
		this.value = value;
		update();
	}
	private void update(){
		this.rep = typeStrings[type]+"-"+valueStrings[value];
		this.color = (type %2 == 0 )? colorStrings[0] : colorStrings[1];
		this.id = (type * 13 + value);
	}

	public int getId() {
		return id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
		update();
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
		update();
	}

	@Override
	public String toString() {
		return this.rep; 
	}
	
	
}
