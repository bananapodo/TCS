import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class SendPostTest {

	public static void submitData(ArrayList<String> json) {
		OutputStreamWriter wr = null;
		BufferedReader rd = null;

		JSONObject jsonObj = new JSONObject();
		JSONParser jParser = new JSONParser();
		// String result = "";
		try {
			// Construct data
			for (int i = 0; i < json.size(); i++) {
				System.out.println(json.get(i));
				String data = "data=" + URLEncoder.encode(json.get(i), "utf-8");

				// Send data
				// URL url = new
				// URL("http://localhost:8010/TestWeb/sample.jsp");

				URL url = new URL("http://localhost:8080/first/sample/getJson.do");

				URLConnection conn = url.openConnection();
				conn.setDoOutput(true);
				// conn.setRequestProperty("Content-Type", "application/json");
				conn.setRequestProperty("Accept", "application/json");
				
				
				wr = new OutputStreamWriter(conn.getOutputStream());
				wr.write(data);
				wr.flush();
				System.out.println("===============전송완료 ============\n"+json.get(i));

				// 이미지 명 매핑하고 전송메소드가 여기 들어가면 될듯
//				ArrayList<String> list = new ArrayList<>();
//				String img_name = null;
//				jsonObj = (JSONObject) jParser.parse(json.get(i));
//				if ((img_name = jsonObj.get("img_name").toString()) != null) {
//					list.add(img_name);
//					FTPUpload.sendFtpServer(list);
//				}

				
				// 데이터 전송 후 인덱스 값 변경
				//json.get(i);
				
				// Get the response
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
				String line;
				while ((line = rd.readLine()) != null) {
					System.out.println(line);
					// result += line;
				} // end while
			} // end for
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