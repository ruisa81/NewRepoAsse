package uk.ac.uof.i2p.coms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

//TODO method to pass to task generator
//TODO refactoring
//TODO java docs

/**
 * This is the main class to run the application
 *
 */
public class DialUp extends MailMan {

	private static HttpURLConnection con;

	public static void main(String[] args) throws  IOException {


		MailMan sender= new MailMan();

		if (args != null){
			try {
				sender = new MailMan(args[0]);
			}catch (Exception e){
				System.out.println("error on Input argument value: \n" + e.toString());
			}
		}


		String message = DialUp.geTasks(sender);
		System.out.println(message);


	}


	public static String geTasks(MailMan sender) throws IOException{

		String url = sender.getAddress();
		URL myURL = new URL(url);
		HttpURLConnection con;
		con = (HttpURLConnection) myURL.openConnection();
		StringBuilder content = new StringBuilder();

		try {

			con.setRequestMethod("GET");

			try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {

				String line;


				while ((line = in.readLine()) != null) {

					content.append(line);
					content.append(System.lineSeparator());
				}
			}
		}finally {

			con.disconnect();
		}
		return content.toString();

	}
}




