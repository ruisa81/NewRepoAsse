package uk.ac.uof.i2p.parcer;

public class Symbol {
    public enum Type { OSTART, OCLOSE, OBJECT, SWRAP, SESCAPE, STRING, VALUE, ASTART, ARRAY, ACLOSE, SEPARATOR, DEFINE, CHARACTER, NUMBER, OTHER}


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
