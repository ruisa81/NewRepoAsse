package uk.ac.uof.i2p.parser;

import java.io.IOException;

public interface Parser {

	public static String executeInstruction(Member instruction, Member parameters) {
		int result = 0;

		return Integer.toString(result);
	}

	public static String unWrapString(String string, char c1, char c2) {
		if (string.charAt(0) != c1) {
			System.out.println("Input string do not start with " + c1);
			System.out.println("String return without change");
			System.out.println(string);
			return string;
		}
		if (string.charAt(string.length() - 1) != c2) {
			System.out.println("Input string do not finish with " + c2);
			System.out.println("String returned without change");
			System.out.println(string);
			return string;
		} else {
			return string.substring(1, string.length() - 1);
		}
	}

	public static String wrapString(String string, char c1, char c2) {
		String result;

		result = Character.toString(c1) + string + Character.toString(c2);
		return result;
	}
	
	public static Symbol parseSymbol(String value) throws IOException {
		char c = value.charAt(0);

		if (Character.isWhitespace(c)) {
			return parseSymbol(value.substring(1));
		} else
			if (Character.isLetterOrDigit(c)) {
				StringBuffer word = new StringBuffer();
				while (Character.isLetterOrDigit((char) c)) {
					word.append((char) c);
					parseSymbol(value.substring(1));
				}
				return new Symbol(Symbol.Type.WORD, word.toString());
			}
		
		// everything else
		switch (c) {
			case '{':
				return new Symbol(Symbol.Type.OOPEN, "{");
			case '}':
				return new Symbol(Symbol.Type.OCLOSE, "}");
			case '"':
				return new Symbol(Symbol.Type.ST_WRAP, "\"");
			case '[':
				return new Symbol(Symbol.Type.ASTART, "[");
			case ']':
				return new Symbol(Symbol.Type.ACLOSE, "]");
			case ',':
				return new Symbol(Symbol.Type.SEPARATOR, ",");
			case ':':
				return new Symbol(Symbol.Type.DEFINE, ":");
			default:
				return new Symbol(Symbol.Type.OTHER, Character.toString((char) c));
		}

	}

}
