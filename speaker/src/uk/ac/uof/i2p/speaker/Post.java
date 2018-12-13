//todo exception handling

//todo remove main class
//todo refactoring
//todo java docs

package uk.ac.uof.i2p.speaker;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Post {
    private static final String USER_AGENT = "Mozilla/5.0";

    private void sendPost() throws Exception {


        String url = "http://i2j.openode.io/answer/5636";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add request header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "13108";

        // Send post request
        DataOutputStream wr=null;
        try {
            con.setDoOutput(true);
            wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + urlParameters);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            System.out.println(response.toString());
        }catch (Exception exception){
            System.out.println("Exception during post answer");
            exception.printStackTrace();
        }finally {
            wr.flush();
            wr.close();
        }



    }

    public static void main(String [] args) throws Exception {

        Post p = new Post();

        p.sendPost();
    }

}


