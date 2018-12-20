package uk.ac.uof.i2p.parser;

public abstract class Value {


	public static Symbol isString(String string) {

		return new Symbol(Symbol.Type.STRING, string);
	}



	void arrayElement(String element) {

	}


	void isBoolean(boolean b) {

	}


	void isNumber(String number) {

	}


}
