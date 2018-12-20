package uk.ac.uof.i2p.parser;

import java.util.ArrayList;
import java.util.List;


public class Json {

	public List<Member> members = new ArrayList<>();

	public Json(Member member) {

		this.members.add(member);

	}
}

