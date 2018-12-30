package uk.ac.uof.i2p.coms;

import uk.ac.uof.i2p.parser.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

//TODO method to pass to task generator
//TODO refactoring
//TODO java docs

/**
 * This is the main class to run the application
 *
 */
public class MainControl extends MailMan {

	private static HttpURLConnection con;

	public static void main(String[] args) throws  IOException {


		MailMan sender= new MailMan();

		if (args != null){
			try {
				sender = new MailMan(args[0]);
			}catch (Exception e){
				System.out.println("No input student number. Using default");
			}
		}

        System.out.println("MailMan created with address: " + sender.getAddress());


		String message = httpGet(sender);
		message = message.trim();
		message = Parser.unWrapString(message,'{','}');

		CharSequence tasksList = message.subSequence(message.indexOf('[')+1,message.indexOf(']'));
		String s = tasksList.toString();
		String [] parts = s.split(",");

		for (int i=0 ; i < parts.length ;  i++) {
			parts[i] = Parser.unWrapString(parts[i],'"' ,'"');

			Task t = new Task(parts[i]);
			sender.setAddress(t.getOrigin());
			String jSonCode = httpGet(sender);
			t.setJsonTask(jSonCode.trim());

			Tasks.tasks.add(t);
/*control block on the task set up
			System.out.println(t.getOrigin());
			System.out.println(t.getDestination());
			System.out.println(t.getTaskId());
			System.out.println(t.getJsonTask()+"\n");
*/

		}
       	Iterator taskIterator = Tasks.tasks.iterator();

		while(taskIterator.hasNext()) {
			Task t = (Task) taskIterator.next();
			System.out.println("____________ \n Processing task: " + t.getTaskId());
			Json json = new Json(t.getJsonTask());
			json.printMembers();


		}
	}


	public static String httpGet(MailMan sender) throws IOException{

		String url = sender.getAddress();
		URL myURL = new URL(url);
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
		}catch (IOException e){
			System.out.println("Error getting data from server:");
			System.out.println(e.toString());
		}
		finally {

			con.disconnect();
		}
		return content.toString();

	}

	public static String httpPost(String url, String parameters) throws Exception {

		URL obj = new URL(url);
		con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		StringBuffer response = new StringBuffer();
		DataOutputStream wr = null;

		try {
			con.setDoOutput(true);
			wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(parameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + parameters);
			if (responseCode!=200) {
				System.out.println("Response Code : " + responseCode);
			}

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;


			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());

		} catch (Exception exception) {
			System.out.println("Exception during post:");
			exception.printStackTrace();
		} finally {
			wr.flush();
			wr.close();
		}

		return response.toString();

	}
}




