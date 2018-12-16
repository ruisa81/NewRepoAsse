package uk.ac.uof.i2p.parser;

public class Symbol {

    public enum Type { SPACE, OOPEN, OCLOSE, OBJECT, ST_WRAP, ST_ESCAPE, VALUE, ASTART, ARRAY, ACLOSE,
        SEPARATOR, DEFINE, WORD, NUMBER, OTHER }

    public final Type type;
    public final String value;

    public Symbol (Type type, String value){

        this.type = type;
        this.value = value;
    }

    public Symbol(Type type){
        this(type, null);
    }

    public String getValue() {
        if (type == Type.NUMBER){
            return Integer.toString(getIntValue());
        }
        return value;
    }

    public Type getType() {
        return type;
    }
    public int getIntValue(){
        if (type != Type.NUMBER){
            System.out.println("Symbol is not an integer");
            return -999;
        }

        return Integer.parseInt(value);
    }

}

//todo start to parser
