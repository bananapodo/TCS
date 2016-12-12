import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SendPostTest {

	public static synchronized void submitData(String json) {
		OutputStreamWriter wr = null;
		BufferedReader rd = null;

		// String result = "";
		try {
			// Construct data

			String data = "data=" + URLEncoder.encode(json, "utf-8");

			// Send data
			URL url = new URL("http://localhost:8010/TestWeb/sample.jsp");
			// URL url = new
			// URL("http://192.168.1.16:8080/first/sample/getJson.do");

			// URL url = new
			// URL("http://127.0.0.1:8080/first/sample/getJson.do");

			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			// conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");

			wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(data);
			wr.flush();

			// Get the response
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
				// result += line;
			}
			// System.out.println(result);
		} catch (Exception e) {
			System.out.println(e.toString());

		} finally {
			try {
				if (wr != null) {
					wr.close();
				}
				if (rd != null) {
					rd.close();
				}
			} catch (IOException ioe) {
				System.out.println(ioe.toString());
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
	}
}