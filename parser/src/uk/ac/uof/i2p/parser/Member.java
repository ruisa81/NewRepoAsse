package uk.ac.uof.i2p.parser;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Member {



	final String name;
	private List<Symbol> element = new ArrayList<>();

	public String getName() {
		return name;
	}

	public Member(String member) {
		String name = member.substring(0, member.indexOf(':'));
		name = Parser.unWrapString(name, '"', '"');
		this.name = name;

		String elements = member.substring(member.indexOf(':') + 1, member.length());

		switch (elements.charAt(0)){
			case '[':
				elements = Parser.unWrapString(elements, '[', ']');
				break;
			case '"':
				elements = Parser.unWrapString(elements, '"', '"');
				break;

				default:
					System.out.println("unknown format");
		}

		String [] split = elements.split(",");

		for (int i=0 ; i<split.length ;i++){
			if (split[i].charAt(0)== '"'){
				split[i] = Parser.unWrapString(split[i],'"','"');
			}
			element.add(new Symbol(Symbol.Type.STRING , split[i]));
		}

	}

	public Member(String memberName, Symbol element) {
		this.name = memberName;
		this.element.add(element);
	}

	public List getParameters() {
		return element;
	}

	public void printMember(){
		System.out.println("Member name: " + name +"|");
		Iterator i = element.iterator();
		while (i.hasNext()){

		Symbol symbol =	(Symbol) i.next();
		symbol.printSymbol();
		}
	}


	public String getInstruction() {
		if(this.getName().compareTo("instruction")==0)
			return element.get(0).getValue();

		else
			System.out.println("this member does not have an instruction");
			return null;
	}
}
