package uk.ac.uof.i2p.parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

// TODO Does this do the same as the Value class now?
public class Lexic {

	private final InputStreamReader reader;

	public Lexic(InputStream reader) {
		this.reader = new InputStreamReader(reader);

	}

	public Symbol next() throws IOException {
		int c = reader.read();

		if (-1 == c) return null;
		if ('{' == c) {
			// todo create JSON object here
			return new Symbol(Symbol.Type.OOPEN, "{");
		}
		if ('}' == c) return new Symbol(Symbol.Type.OCLOSE, "}");
		if ('"' == c) {
			// todo create word here
			return new Symbol(Symbol.Type.ST_WRAP, "\"");
		}
		// if('' == c ) return new Symbol(Symbol.Type.ST_ESCAPE); escape from String for extended marks
		if ('[' == c) {
			// todo create array here
			return new Symbol(Symbol.Type.ASTART, "[");
		}

		if (']' == c) return new Symbol(Symbol.Type.ACLOSE, "]");
		if (',' == c) {
			// todo expect to read next a member or a element
			return new Symbol(Symbol.Type.SEPARATOR, ",");
		}
		if (':' == c) {
			// todo expecting to create element here
			return new Symbol(Symbol.Type.DEFINE, ":");
		}

		if (Character.isWhitespace(c)) {
			while (Character.isWhitespace(c)) {
				c = reader.read();
			}
			return new Symbol(Symbol.Type.SPACE);
		}
		if (Character.isLetterOrDigit(c)) {
			StringBuffer word = new StringBuffer();
			while (Character.isLetterOrDigit((char) c)) {
				word.append((char) c);
				c = reader.read();
			}
			return new Symbol(Symbol.Type.WORD, word.toString());
		}

		return new Symbol(Symbol.Type.OTHER, Character.toString((char) c));
	}

}
