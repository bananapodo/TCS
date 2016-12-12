
public class ThreadTest implements Runnable {
	
	String data = InputData.inputData();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		SendPostTest.submitData(data);
		String name = Thread.currentThread().getName();
		System.out.println(name);
		//System.out.println(data);
	}

}
