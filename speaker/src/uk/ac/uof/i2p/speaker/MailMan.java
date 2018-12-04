package uk.ac.uof.i2p.speaker;

public class MailMan {


    protected Task task = new Task("origin","dest", "jason");
    protected  static String URLBASE ="http://i2p.openode.io";
    public String studentId = "s195237";
    public String address ="NULL";


    public void setAddress(String address) {
        this.address = URLBASE + address;
    }
}
