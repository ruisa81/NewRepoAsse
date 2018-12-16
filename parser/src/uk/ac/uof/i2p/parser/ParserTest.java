package uk.ac.uof.i2p.parser;
import org.junit.jupiter.api.Assertions;



class ParserTest {

    @org.junit.jupiter.api.Test
    void unWrapString() {

        Parser test = new Parser();
        String string = "ajvvdjhabdlajknsdjn";
        string = test.wrapString(string,'{','}');

        Assertions.assertEquals("{ajvvdjhabdlajknsdjn}",string);
    }

    @org.junit.jupiter.api.Test
    void wrapString() {
        Parser test = new Parser();
        String string = "\"ajvvdjhabdlajknsdjn\"";
        string = test.unWrapString(string,'"');

        Assertions.assertEquals("ajvvdjhabdlajknsdjn",string);



    }
}