package uk.ac.uof.i2p.coms;

import java.util.List;

/**
 * This class handles the 1st message received from the server and set the tasks
 *
 */

public class Receiver extends MailMan {

	private List<String> taskAddresses;

	public int tasks = 0;

	public Receiver() {}

	public void addAddress(String address) {
		taskAddresses.add(address);
	}

}
