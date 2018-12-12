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

}

//todo start to parser
//todo start task parser to write file