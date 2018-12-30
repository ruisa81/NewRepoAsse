package uk.ac.uof.i2p.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Json {

	public List<Member> members = new ArrayList<>();

	public void addMember(Member member) {

		this.members.add(member);

	}

	public Json (String rawData){

		try {
			rawData = Parser.unWrapString(rawData,'{','}');
			rawData = rawData.trim();
			String instruction = rawData.substring(0, rawData.indexOf(','));
			String parameters = rawData.substring(rawData.indexOf(',')+1, rawData.lastIndexOf(','));
			String answerDestination = rawData.substring(rawData.lastIndexOf(',')+1, rawData.length());
			addMember(new Member(instruction));
			addMember(new Member(parameters));
			addMember(new Member(answerDestination));
		}catch (Exception e){
			System.out.println("Data corrupted or is not in the expected format");

		}


	}

	public void printMembers(){
		Iterator i = members.iterator();
		while (i.hasNext()){
			Member member = (Member) i.next();
			member.printMember();
		}
	}

}

