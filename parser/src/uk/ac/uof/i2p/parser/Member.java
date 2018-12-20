package uk.ac.uof.i2p.parser;


import java.util.ArrayList;
import java.util.List;


public class Member {

	final String name;
	public List<Symbol> element = new ArrayList<>();

	public String getName() {
		return name;
	}

	public Member(String memberName) {
		this.name = memberName;
	}

	public Member(String memberName, Symbol element) {
		this.name = memberName;
		this.element.add(element);
	}

	public List getParameters() {
		return element;
	}
}
