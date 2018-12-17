package uk.ac.uof.i2p.parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ParserTest {

    @org.junit.jupiter.api.Test
    void wrapString() {


        String string = "ajvvdjhabdlajknsdjn";
        string = Parser.wrapString(string,'{','}');

        Assertions.assertEquals("{ajvvdjhabdlajknsdjn}",string);
    }

    @org.junit.jupiter.api.Test
    void unWrapString() {

        String string = "\"ajvvdjhabdlajknsdjn\"";
        string = Parser.unWrapString(string,'"','"');

        Assertions.assertEquals("ajvvdjhabdlajknsdjn",string);



    }

    @Test
    void parseSymbol() {




    }
}