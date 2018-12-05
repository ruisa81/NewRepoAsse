package uk.ac.uof.i2p.speaker;


import java.util.List;


// this class handles the 1st message received from the server and set the tasks


public class Receiver extends MailMan {

    private List taskAddresses;

    public int tasks=0;

    public Receiver(){
    }

    public void addAddress(String address) {

        taskAddresses.add(address);
    }



}








