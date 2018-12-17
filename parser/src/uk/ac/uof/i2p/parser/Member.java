package uk.ac.uof.i2p.parser;

// TODO split by colon (:)
// TODO populate name with first token
// TODO populate element with second token
public class Member {

	private String name;
	private Value element;

	public Member(String member) {
		String[] tokens = member.split(":");

		this.name = tokens[0];
		this.element = new Value(tokens[1]);
	}

}
