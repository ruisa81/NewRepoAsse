package uk.ac.uof.i2p.parser;

public class Symbol extends Value {

	public enum Type {
		SPACE,
		OOPEN,
		OCLOSE,
		OBJECT,
		ST_WRAP,
		STRING,
		ST_ESCAPE,
		ASTART,
		ARRAY,
		ACLOSE,
		SEPARATOR,
		DEFINE,
		WORD,
		NUMBER,
		OTHER
	}
	final Type type;
	final String value;

	public Symbol(Type type, String value) {

		this.type = type;
		this.value = value;
	}

	public Symbol(Type type) {
		this(type, null);
	}

	public String getValue() {

		return value;
	}

	public Type getType() {
		return type;
	}

	public int getIntValue() {
		//System.out.println("Symbol value: " + this.value);
		return Integer.parseInt(value);
	}


	public void printSymbol(){
		System.out.println("Symbol type: " + type + " | Symbol value: " + value + "|");

	}



}


