import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadData {

	public static synchronized ArrayList<String> readData() {

		ArrayList<String> data = new ArrayList<String>();
		String s = "";

		try {
			BufferedReader br = new BufferedReader(new FileReader("test.txt"));

			// 라인별로 데이터를 읽는다.
			while ((s = br.readLine()) != null) {
				// 라인의 첫번째 글자가 0이면 list에 저장
				char index = s.charAt(0);
				System.out.println(index);
				if (index == '0') {
					data.add(s);
				}
			}
//			for(int i=0;i<data.size();i++){
//				System.out.println(data.get(i));
//			}
			
			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;

	}

}