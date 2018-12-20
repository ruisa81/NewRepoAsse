package uk.ac.uof.i2p.parser;

import java.io.IOException;
import java.util.Iterator;

public interface Parser {


	static int parseStringToNumber(String input) {
		char c;
		for(int i=0; i<input.length(); i++){
			c = input.charAt(i);
			if (!Character.isDigit(c)){
				System.out.println(input + "can not be parse to a integer");
				return -999;
			}
		}
		// store as number
		return Integer.parseInt(input);
	}

	static String executeInstruction(String instruction, Member parameters) {
		int result=0;
		int size = parameters.element.size();
		Iterator iterator = parameters.element.iterator();

		switch (instruction){
			case "add":{
				while(iterator.hasNext()){
					Symbol element = (Symbol) iterator.next();
					if (Symbol.Type.NUMBER == element.type)
						result += Parser.parseStringToNumber(element.value);
				}
				break;
			}
			case "subtract": {
				while(iterator.hasNext()){
					Symbol element = (Symbol) iterator.next();
					if (Symbol.Type.NUMBER == element.type)
						result -= Parser.parseStringToNumber(element.value);
				}
				break;
			}
			case "multiply":{
				while(iterator.hasNext()){
					Symbol element = (Symbol) iterator.next();
					if (Symbol.Type.NUMBER == element.type)
						result *= Parser.parseStringToNumber(element.value);
				}
				break;
			}
			case "divide":{

					Symbol element = (Symbol) iterator.next();
					int val1 = Parser.parseStringToNumber(element.value);
					iterator.next();
					int val2 = Parser.parseStringToNumber(element.value);
					result = val1/val2;

				break;
			}
			case "append":{
				StringBuilder str = new StringBuilder("");
				while(iterator.hasNext()){
					Symbol element = (Symbol) iterator.next();
					str.append(element.value);
				}
				return str.toString();
			}
			case "task":{

				break;
			}
			case "id":{
				break;
			}
			default:
				return "instruction not defined";


		}



		return Integer.toString(result);
	}

	static String unWrapString(String string, char c1, char c2) {
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

	static String wrapString(String string, char c1, char c2) {
		String result;

		result = Character.toString(c1) + string + Character.toString(c2);
		return result;
	}
	
	static Symbol parseSymbol(String value) throws IOException {
		char c = value.charAt(0);
		boolean isWord=false;

		if (Character.isWhitespace(c) && isWord) {
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
