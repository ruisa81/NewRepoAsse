package uk.ac.uof.i2p.speaker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

//todo method to pass to task generator
//todo refactoring
//todo remove main class
//todo java docs


public class TestingConnection extends MailMan{

    private static HttpURLConnection con;

    public static void main(String [] args) throws MalformedURLException, ProtocolException, IOException {

       MailMan sender = new MailMan();

       String url = sender.getFirstURL();

        try {
            URL myURL = new URL(url);

            con = (HttpURLConnection) myURL.openConnection();
            con.setRequestMethod("GET");
            StringBuilder content;

            try(BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))){

                String line;
                content = new StringBuilder();

                while ((line = in.readLine()) != null){

                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }

            System.out.println(content.toString());


        } finally {
            con.disconnect();
        }


    }
}
