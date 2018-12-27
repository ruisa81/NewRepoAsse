package uk.ac.uof.i2p.coms;

public class Task {

	private String origin;
	private String destination;



	private String taskId;
	private boolean done = false;
	private boolean queued = false;
	private boolean okay = false;
	public String jsonTask = "Empty";
	public String answer = "We have a problem";

	public Task(String origin, String destination, String json) {

		this.origin = origin;
		this.destination = destination;
		this.jsonTask = json;
		this.setDone(false);
		this.setOkay(true);
		this.setQueued(false);
		this.answer = "Not answered yet";
	}


	public String getTaskId() {
		return taskId;
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

	public void setDone(boolean b) {
		done = b;
	}


	public void setQueued(boolean b) {
		queued = b;
	}


	public void setOkay(boolean b) {
		okay = b;
	}



}
