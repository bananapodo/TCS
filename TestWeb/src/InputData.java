import java.util.Scanner;

import org.json.simple.JSONObject;

public class InputData {


	@SuppressWarnings("unchecked")
	public static String inputData() {
		Scanner sc = new Scanner(System.in);

		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("이메일: ");
		String email = sc.nextLine();

		// JSONParser jsonParser = new JSONParser();

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		jsonObject.put("email", email);

		String data = jsonObject.toJSONString();

		System.out.println(data);

		return data;
	}
}