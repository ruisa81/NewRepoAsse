package uk.ac.uof.i2p.parser;


import java.util.List;

public class  Value  {

    private boolean aBoolean;
    private int number;
    private String string;
    private List<Value> array;


    public Value(String token) {

        if(token.charAt(0) == '[') {
            // todo split by ','
        }
        if (token.charAt(0) == '"'){
               this.string = token;
        }
        if (token.charAt(0) == '{'){


        }



        else switch (token) {
                case "true":
                    this.aBoolean = true;
                    break;

                case "false":
                    this.aBoolean = false;
                    break;

                case "null":
                    System.out.println("null! ops!");
                    break;
            }

    }

}
