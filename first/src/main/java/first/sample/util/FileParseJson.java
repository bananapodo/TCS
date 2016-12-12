package first.sample.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FileParseJson {

	public static void getData() {
		// JSONParser parser = new JSONParser(); // ????? ???
		// String[] keyArray = new String[30]; // ????? ??? ??????
		// String[] valueArray = new String[30]; // ????? ????? ????
		// String[] columnArray = ReadConfig.columnArray();
		//
		// // json
		// HashMap<String, String> data = new HashMap<String, String>();
		//
		// ArrayList<String> files = new ArrayList<String>();
		//
		// InfoDAO idao = new InfoDAO(); //
		//
		// try {
		// // 제이슨 파서
		// Object obj = parser.parse(new BufferedReader(new
		// FileReader("C:\\TCS\\data\\test.txt")));
		// // 제이슨 오브잭트
		// JSONObject jsonObject = (JSONObject) obj;
		//
		// // 제이슨 배열
		// JSONArray jsonArray = (JSONArray) jsonObject.get("info");
		//
		// JSONObject keyObject = (JSONObject) jsonArray.get(1);
		// String key = (String) keyObject.get("project_key");
		//
		// int listCount = idao.getListCount(key);
		// //System.out.println(key);
		//
		// if (jsonArray.size() == listCount) {
		// System.out.println("입력할 데이터가 없습니다.");
		// } else {
		// for (int arr = listCount; arr < jsonArray.size(); arr++) {
		//
		// JSONObject infoObject = (JSONObject) jsonArray.get(arr);
		// // 키셋 추출
		// String keys = infoObject.keySet().toString();
		// String subKeys = keys.substring(1, keys.length() - 1);
		//
		// // 구분자로 키셋 나눔
		// StringTokenizer tokens = new StringTokenizer(subKeys, ",");
		//
		// //
		// for (int i = 0; tokens.hasMoreTokens(); i++) {
		// // data 키 저장
		// keyArray[i] = tokens.nextToken().trim();
		//
		// // data 밸류 저장
		// valueArray[i] = (String) infoObject.get(keyArray[i]);
		//
		// // data 해쉬멥에 저장
		// data.put(keyArray[i], valueArray[i]);
		// // System.out.println(data);
		//
		// }
		//
		// // db 저장
		// idao.insertData(columnArray, data);
		//
		// // 이미지 여러개일시 for 문 사용
		// // for (int i = 0; i < 10; i++) {
		// // if (data.get("transfile" + i) != null) {
		// // break;
		// // }
		// // files.add(data.get("transfile" + i));
		// // }
		// // files.add(data.get("img_name"));
		// // FTPUpload.sendFtpServer(files);
		// }
		//
		// } // end if
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// } catch (ParseException e) {
		// e.printStackTrace();
		// }
		//
		// return data;
		// }
	}
}