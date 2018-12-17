package uk.ac.uof.i2p.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// given a string of json
// unwrap the { } curly brackets
public class Json {

	public List<Member> members = new ArrayList<>();

	public Json(InputStream stream) throws IOException {

		Lexic read = new Lexic(stream);

		if (read.next().type == Symbol.Type.OBJECT) { // check if { is present

			while (read.next().type != Symbol.Type.OCLOSE || read.next().type != Symbol.Type.SEPARATOR) {
				Member m = new Member(read.toString());
				// TODO set the element (value) of this member

				this.members.add(m);
			}
			
			
		}

	}
	
	public Json(String input) {
		char firstChar = input.charAt(0);
		char lastChar = input.charAt(input.length() - 1);
		
		// validate
		if (firstChar != '{' || lastChar != '}') {
			// TODO throw exception?
		}
		
		// TODO unwrap { } brackets
		String unWrappedString = Parser.unWrapString(input, firstChar, lastChar);
		
		// if open curly bracket, start of object
		// if close curly bracket, end of object
		// if whitespace, ignore and go to next
		// if quote (")
		// 		if started reading word, end word
		//      else start reading word
		// if colon (:), value will be next
		// else, must be a value?
	}
	
}
