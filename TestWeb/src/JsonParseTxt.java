
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class JsonParseTxt {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		String name = null; // ����� �̸�
		
		String email = null;
		Scanner sc = new Scanner(System.in);

		
		SimpleDateFormat df = new SimpleDateFormat("yyMMddhhmm");
		Date date = new Date();
		String today = df.format(date);

		
		System.out.print("이름: ");
		name = sc.nextLine();
	
	
		System.out.print("이메일 : ");
		email = sc.nextLine();

		JSONObject obj = new JSONObject();
		obj.put("name", name);
		obj.put("email", email);

		try {

			FileWriter file = new FileWriter("E:\\tcs\\TCSdemo\\data\\test.txt");
			BufferedWriter bw = new BufferedWriter(file);
			bw.write(obj.toJSONString());
			bw.flush();
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		// System.out.print(obj);

	}
}
