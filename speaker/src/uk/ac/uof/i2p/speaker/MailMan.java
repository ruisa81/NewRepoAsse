package uk.ac.uof.i2p.speaker;



public class MailMan {


    public Task task;
    public String URLBASE ="http://i2j.openode.io";
    public String studentId = "s195237";
    private String address ="NULL";

    public MailMan() {
    }


    public void setAddress(String address) {
        this.address = URLBASE + address;
    }

    public String getFirstURL(){

        this.setAddress("/student?id=" + this.studentId);
        System.out.println(this.getAddress());
        return getAddress();
    }

    public String getAddress() {
        return address;
    }

    public void buildTask(String content){



    }
}
