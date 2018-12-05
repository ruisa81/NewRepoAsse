package uk.ac.uof.i2p.speaker;

public class MailMan {


    public Task task;
    public static String URLBASE ="http://i2p.openode.io";
    public String studentId = "s195237";
    private String address ="NULL";

    public MailMan() {
    }


    public void setAddress(String address) {
        this.address = URLBASE + address;
    }

    public String getFirstURL(){

        this.setAddress(URLBASE + "/student?id=" + this.studentId);
        System.out.println(this.getAddress());
        return getAddress();
    }

    public String getAddress() {
        return address;
    }
}
