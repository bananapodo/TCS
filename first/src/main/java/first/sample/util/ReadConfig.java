package first.sample.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class ReadConfig {

	public static String[] getProjectKey() {

	    SimpleDateFormat df = new SimpleDateFormat("yyMMdd");
	    Date date = new Date();
	    String today = df.format(date);

	    String[] key = new String[7];
	    
	    try {

	      String s = "";
	      // config file read
	      
	      BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\TCS\\config\\config.txt"));
	      int i;

	      // 한글자씩 읽음
	      while ((i = bis.read()) != -1) {
	        // System.out.println((char) i);
	        s += (char) i; // 스트링형으로 저장
	      }
	      bis.close();

	      String sub = s.substring(0, s.indexOf("/")).trim();
	      StringTokenizer tokens = new StringTokenizer(sub, "|");

	      //구분자별로 저장
	      for (int k = 0; tokens.hasMoreTokens(); k++) {
	        key[k] = tokens.nextToken().trim();
	        // System.out.println(key[k]);
	      }
	      key[1] = key[1].concat(today);

	    } catch (IOException e) {
	      e.printStackTrace();
	    }

	    return key;

	  }

	  public static String[] getFtpDetail() {

	    String[] ftpDetails = new String[4];
	    try {
	      String s = "";
	      // config file read
	      BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\TCS\\config\\config.txt"));

	      int i;

	      // 텍스트 한글자씩 읽어서 저장
	      while ((i = bis.read()) != -1) {
	        // System.out.println((char) i);
	        s += (char) i;
	      }
	      bis.close();

	      String sub = s.substring(s.indexOf("/") + 1, s.lastIndexOf("/")).trim();
	      StringTokenizer tokens = new StringTokenizer(sub, "|");

	      // 구분자 별로 저장
	      for (int k = 0; tokens.hasMoreTokens(); k++) {
	        ftpDetails[k] = tokens.nextToken().trim();
	        // System.out.println(ftpDetails[k]);

	      }

	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    return ftpDetails;

	  }

	  public static String[] columnArray() {
	    String[] split = new String[30]; 

	    try {
	      // config file read
	      String s = "";
	      // config file read
	      BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\TCS\\config\\config.txt"));
	      int i;
	      while ((i = bis.read()) != -1) {
	        // System.out.println((char) i);
	        s += (char) i;
	      }
	      bis.close();

	      // 구분자대로 문자열 자름
	      String sub = s.substring(s.lastIndexOf("/") + 1, s.length()).trim();
	      StringTokenizer tokens = new StringTokenizer(sub, "|");

	      // 구분자 별로 저장
	      for (int k = 0; tokens.hasMoreTokens(); k++) {
	        split[k] = tokens.nextToken().trim();
	        // System.out.println(split[k]);

	      }

	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    return split;

	  }
}
