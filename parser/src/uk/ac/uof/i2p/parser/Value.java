package uk.ac.uof.i2p.parser;

import java.util.ArrayList;
import java.util.List;

// TODO decide 'type' of value, e.g. boolean, number, string, elements (list)
public class Value {

	private boolean aBoolean;
	private int number;
	private String string;
	private List<Symbol> elements = new ArrayList<>();

	public Value(String input) {


	}

	/**
	 * Removes the first and last characters, splits the elements and parses each one into a Value of its own
	 * @param input
	 * @param firstChar
	 * @param lastChar
	 */
	public void parseElement(String input, char firstChar, char lastChar) {
		// unwrap the brackets
		Parser.unWrapString(input, firstChar, lastChar);

		// todo split by ','
		String[] tokens = input.split(",");

		// store in this.array
		for (String token : tokens) {
		//	Symbol value = new Symbol(Symbol.Type.);
		//	elements.add(value);
		}
	}

	public void parseString(String input) {
		if (Character.isDigit(input.charAt(1))) { // is the second char a number
			parseStringToNumber(input);
		} else {
			this.string = input;
		}
	}

	public void parseStringToNumber(String input) {
		// unwrap the quotes
		String unWrappedString = Parser.unWrapString(input, '"', '"');
		
		// store as number
		this.number = Integer.parseInt(unWrappedString);
	}

}
