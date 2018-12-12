package uk.ac.uof.i2p.parser;


import java.io.IOException;
import java.io.Reader;

public class Lexic {

    private final Reader reader;

    public Lexic(Reader reader){
        this.reader = reader;
    }

    public Symbol next() throws IOException {
        int c = reader.read();

        if(-1 == c) return null;
        if('{' == c ) return new Symbol(Symbol.Type.OOPEN);
        if('}' == c ) return new Symbol(Symbol.Type.OCLOSE);
        if('"' == c ) return new Symbol(Symbol.Type.ST_WRAP);
        //if('' == c ) return new Symbol(Symbol.Type.ST_ESCAPE); escape from String for extended marks
        if('[' == c ) return new Symbol(Symbol.Type.ASTART);
        if(']' == c ) return new Symbol(Symbol.Type.ACLOSE);
        if(':' == c ) return new Symbol(Symbol.Type.SEPARATOR);
        if(Character.isWhitespace(c)) {
            while (Character.isWhitespace(c)) {
                c = reader.read();
            }
            return new Symbol(Symbol.Type.SPACE);
        }
        if(Character.isLetterOrDigit(c)){
            StringBuffer word = new StringBuffer();
            while(Character.isLetterOrDigit((char)c)){
                word.append((char)c);
                c = reader.read();
            }
            return new Symbol(Symbol.Type.WORD, word.toString());
        }

        return new Symbol(Symbol.Type.OTHER , Character.toString((char)c));
    }
}
