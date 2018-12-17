package uk.ac.uof.i2p.speaker;

public class MailMan {

	private final String STUDENT_PATH = "/student?id=";
	private final String URL_BASE = "http://i2j.openode.io";

	public Task task;
	public String studentId;
	private String address = null;

	public MailMan() {}

	public MailMan(String studentId) {
		this.studentId = studentId;
		setAddress(STUDENT_PATH + studentId);

		System.out.println("MailMan created with address: " + this.address);
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = URL_BASE + address;
	}

	public String getFirstURL() {
		this.setAddress("/student?id=" + this.studentId);
		System.out.println(this.getAddress());

		return getAddress();
	}

	public void buildTask(String content) {

	}
}
