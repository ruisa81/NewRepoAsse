package uk.ac.uof.i2p.parser;

import java.io.IOException;

import java.io.InputStream;
import java.util.List;


public class Json {
    public List<Member> members;


    public Json (InputStream stream) throws IOException {

        Lexic read = new Lexic(stream);

        if(read.next().type == Symbol.Type.OBJECT) { //check if { is present

            while (read.next().type != Symbol.Type.OCLOSE || read.next().type != Symbol.Type.SEPARATOR){
                Member m = new Member(read.toString());
                //todo set the element (value) of this member

                this.members.add(m);
            }

        }

    }

}
