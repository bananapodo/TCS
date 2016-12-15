import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class SaveData {

	public synchronized void saveData() {

		List<String> list = new ArrayList<String>();
		String line = "";
		String addData = "";

		try {

			// 키오스크에서 받은 데이터파일
			BufferedReader br2 = new BufferedReader(new FileReader("kioskdata.txt"));
			addData = br2.readLine();
			// 데이터 파일이 공백이 아닐 경우 데이터 추가
			if (addData != null) {

				// 데이터 받은 후 내용 삭제
				FileOutputStream fos = new FileOutputStream("kioskdata.txt");
				fos.close();


				// 전체 데이터파일에서 값을 읽고 List에 저장
				BufferedReader br = new BufferedReader(new FileReader("test.txt"));
				while ((line = br.readLine()) != null) {
					list.add(line);
				}
				br.close();

				// 기존 데이터를 rewrite
				PrintWriter pw = new PrintWriter(new FileWriter("test.txt"));
				int priorCnt = list.size();
				for (int i = 0; i < priorCnt; i++) {
					pw.println(list.get(i));
				}
				pw.close();

				// 새로 들어온 데이터를 list에 추가
				list.add(addData);

				// 추가된 데이터를 전체데이터에 이어서 추가
				PrintWriter pw2 = new PrintWriter(new FileWriter("test.txt", true));
				pw2.println(0 + addData);
				pw2.close();

			} else {
				System.out.println("추가 할 데이터가 없습니다.");
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class SaveThread implements Runnable {
	SaveData sd = new SaveData();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		sd.saveData();
	}

}
