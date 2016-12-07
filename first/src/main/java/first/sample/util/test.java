package first.sample.util;

import java.util.*;

public class test {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		//InfoDAO.insertProjectList();
		FileParseJson.getData();
		TimerTask tt = new TimerTask() {

		      @Override
		      public void run() {
		        // TODO Auto-generated method stub
		        System.out.println("timer Task Start");
		        FileParseJson.getData();
		        //FTPUpLoader.FTPUpload();
		        
		      }
		    };

		    //
		    Timer timer = new Timer();
		    Calendar date = Calendar.getInstance();
		    //
		    timer.scheduleAtFixedRate(tt, date.getTime(), 5000);
	}

}
