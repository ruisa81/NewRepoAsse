package uk.ac.uof.i2p.parser;

import java.io.Reader;
import java.lang.reflect.Array;

public class Parser {

    public Parser(){

    }


    public String executeInstruction(Member instruction, Member parameters){

        int result=0;

        return Integer.toString(result);
    }

    public String unWrapString(String string, char c1, char c2){

        if (string.charAt(0) != c1) {
            System.out.println("Input string do not start with" + c1);
            System.out.println("String return without change");
            System.out.println(string);
            return string;
        }
        if(string.charAt(string.length()) != c2){
            System.out.println("Input string do not finish with" + c2);
            System.out.println("String returned without change!");
            System.out.println(string);
            return string;
        }else {
            return string.substring(1, string.length() - 1);
        }
    }

    public String wrapString(String string, char c1, char c2){
        String result;

        result = Character.toString(c1) + string + Character.toString(c2);
        return result;
    }





}
