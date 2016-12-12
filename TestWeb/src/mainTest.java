
public class mainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runnable r = new ThreadTest(); //데이터 전송 메소드가 있는 클래스
		
		
		Thread t1 = new Thread(r); //키오스크에서 들어오는 데이터를 쓰레드로 실행
		Thread t2 = new Thread(r); //키오스크에서 들어오는 데이터를 쓰레드로 실행

		
		//데이터가 한개만 들어오면 쓰레드 1만 실행시켜야함.... 
		t1.start();
		t2.start();

		// URLConnectionPOST.sendData();

		// SendPOSTTest.submitData(data);

	}

}
