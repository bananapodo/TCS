
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FTPUpload {
	
	public static void sendFtpServer(ArrayList<String> files) {
		String[] ftpInfo = ReadConfig.getFtpDetail();

		String ip = ftpInfo[0];
		int port = Integer.parseInt(ftpInfo[1]);
		String id = ftpInfo[2];
		String password = ftpInfo[3];

		String folder = "\\TCS\\img\\";
		String localPath = "E:\\tcs\\TCSdemo\\img\\";
		// ArrayList<String> files = new ArrayList<String>();

		// files.add("1rx2cn.jpg");

		boolean isSuccess = false;
		FTPClient ftp = new FTPClient();

		int reply;
		try {
			ftp = new FTPClient();
			ftp.setControlEncoding("UTF-8");
			ftp.connect(ip, port);
			System.out.println("Connected to " + ip + " on " + ftp.getRemotePort());

			// After connection attempt, you should check the reply code to
			// verify
			// success.
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				System.err.println("FTP server refused connection.");
				System.exit(1);
			}

			if (!ftp.login(id, password)) {
				ftp.logout();
				throw new Exception("ftp 서버에 로그인하지 못했습니다.");
			}

			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			ftp.enterLocalPassiveMode();

			System.out.println(ftp.printWorkingDirectory());
			try {
				ftp.makeDirectory(folder);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ftp.changeWorkingDirectory(folder);
			System.out.println(ftp.printWorkingDirectory());

			for (int i = 0; i < files.size(); i++) {
				String sourceFile = localPath + files.get(i);
				File uploadFile = new File(sourceFile);
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(uploadFile);
					System.out.println(sourceFile + " : 전송시작 = >");
					isSuccess = ftp.storeFile(files.get(i), fis);
					System.out.println(sourceFile + " : 전송결과 = >" + isSuccess);
				} catch (IOException e) {
					e.printStackTrace();
					isSuccess = false;
				} finally {
					if (fis != null) {
						try {
							fis.close();
						} catch (IOException e) {
						}
					}
				} // end try
			} // end for

			ftp.logout();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ftp != null && ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException e) {
				}
			}
		}
		files.clear();
		// return isSuccess;
	}
}
