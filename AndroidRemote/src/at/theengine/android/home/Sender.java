package at.theengine.android.home;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Sender {

	@SuppressWarnings("deprecation")
	public static String getStringResponseFromGetRequest(String requestUrl) throws IOException{
		URL url1;
		URLConnection urlConnection;
		DataInputStream inStream;

		url1 = new URL(requestUrl);
		urlConnection = url1.openConnection();
		((HttpURLConnection)urlConnection).setRequestMethod("GET");
		urlConnection.setDoInput(true);
		urlConnection.setDoOutput(false);
		urlConnection.setUseCaches(false);

		inStream = new DataInputStream(urlConnection.getInputStream());

		return inStream.readLine();
	}
	
}
