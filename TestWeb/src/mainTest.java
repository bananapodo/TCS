import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class mainTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

		new View();

		
		// 데이터 읽고 저장
//		Runnable r = new SaveThread();
//		Thread t1 = new Thread(r);
//		t1.start();
		
		 KioskPingCheck.pingCheck();
		
		//ArrayList<String> data = ReadData.readData();
		//SendPostTest.submitData(data);
	
		 

	}

}
