package uk.ac.uof.i2p.coms;

public class Task {

	private String origin;
	private String destination;



	private String taskId;
	private boolean solved = false;
	private boolean haveJson = false;
	private boolean haveDestination = false;



	public String jsonTask = "Empty";
	public String answer = "We have a problem";

	public Task(String origin, String destination, String json) {

		this.origin = origin;
		this.destination = destination;
		this.jsonTask = json;
		this.setSolved(false);
		this.setHaveDestination(true);
		this.setHaveJson(false);
		this.answer = "Not answered yet";
	}

	public Task(String taskNumber){
		this.origin = MailMan.getURL_BASE()+taskNumber;
		this.setHaveJson(false);
		this.setSolved(false);

	}


	public String getTaskId() {
		return taskId;
	}

	public void setJsonTask(String jsonTask) {
		this.jsonTask = jsonTask;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setSolved(boolean b) {
		this.solved = b;
	}


	public void setHaveJson(boolean b) {
		this.haveJson = b;
	}


	public void setHaveDestination(boolean b) {
		this.haveDestination = b;
	}



}
