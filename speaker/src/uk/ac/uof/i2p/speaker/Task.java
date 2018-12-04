package uk.ac.uof.i2p.speaker;

public class Task {

    private String origin;
    private String destination;
    private boolean done = false;
    private boolean queued = false;
    private boolean okay = false;
    public String jsonTask = "Empty";
    public String answer = "We have a problem";

    public Task (String origin, String destination, String json){

        this.origin = origin;
        this.destination = destination;
        this.jsonTask = json;
        this.setDoneFalse();
        this.setOkayTrue();
        this.setQueuedFalse();
        this.answer = "Not answered yet";
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) { this.answer = answer; }

    public String getOrigin(){ return origin; }

    public String getDestination() { return destination; }

    public void setDoneTrue(){
        done = true;
    }

    public void setDoneFalse(){
        done = false;
    }

    public void setQueuedTrue(){
        queued = true;
    }

    public void setQueuedFalse(){
        queued = false;
    }

    public void setOkayTrue(){
        okay = true;
    }

    public void setOkayFalse(){
        okay = false;
    }

}
