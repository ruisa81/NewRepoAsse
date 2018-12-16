package uk.ac.uof.i2p.parser;


public class Member {

    private String name;
    private Symbol define;
    private Value element  ;

    public Member(String member){

        String []tokens = member.split(":");

        this.name = tokens[0];
        this.element = new Value(tokens[1]);
    }


}
