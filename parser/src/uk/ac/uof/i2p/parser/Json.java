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
			addMember(new Member(instruction));

			String parameters = rawData.substring(rawData.indexOf(',')+1, rawData.lastIndexOf(','));
			addMember(new Member(parameters));

			String answerDestination = rawData.substring(rawData.lastIndexOf(',')+1, rawData.length());
			addMember(new Member(answerDestination));

		}catch (Exception e){
			System.out.println("Data corrupted or is not in the expected format");
			System.out.println(e);

		}


	}

	public void printMembers(){
		Iterator i = members.iterator();
		while (i.hasNext()){
			Member member = (Member) i.next();
			member.printMember();
		}
	}

	public String getInstruction(){
		Iterator iterator = this.members.iterator();
		Member member = (Member) iterator.next();
		while(iterator.hasNext()){
			//System.out.println("member name: " + member.getName());
			if (member.getName().compareTo("instruction")==0)
				return member.getInstruction();

			member = (Member) iterator.next();
		}

		System.out.println("Fail to return Instruction");
		return null;
	};

	public List getParameters() {
		Iterator iterator = this.members.iterator();
		Member member = (Member) iterator.next();
		while(iterator.hasNext()){
			//System.out.println("member name: " + member.getName());
			if (member.getName().compareTo("parameters")==0) {
				//member.printMember();
				return member.getParameters();
			}else
				member = (Member) iterator.next();
		}
		System.out.println("Fail to return Parameters");
		return null;



	}
}

