import java.net.InetAddress;

public class KioskPingCheck implements Runnable{
	public static void pingCheck() {

		String[] addressTmp = { "192.168.50.10" };
		String[] addressName = { "KIOSK1" };
		while (true) {
			for (int i = 0; i < addressTmp.length; i++) {

				try {
					Thread.sleep(3000);
					InetAddress targetIp = InetAddress.getByName(addressTmp[i]);

					boolean value = targetIp.isReachable(5000);
					if (value) {
						System.out.println(addressTmp[i] + "-" + addressName[i] + " ============== Success");
					} else {
						System.out.println(addressTmp[i] + "-" + addressName[i] + " ============== fales");

					}
				
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}

	public static void pingSleep(String[] addressTmp) {

	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		pingCheck();
	}
}
