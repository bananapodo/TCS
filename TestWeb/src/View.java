import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sun.nio.cs.ext.PCK;

public class View extends JFrame implements ActionListener, MouseListener {
	private static final long serialVersionUID = -711163588504124217L;
	

	JButton buttonStart = new JButton("run");
	JButton buttonEnd = new JButton("stop");
	JButton btnConnectKISOK = new JButton("KISOK Check");
	JButton btnDisconnectKISOK = new JButton("btnDisconnectKISOK");
	JLabel kiosk = new JLabel("KIOSK");
	JLabel kioskIP = new JLabel("IP");
	JLabel kioskName = new JLabel("NAME");

	JTextField txtKioskIP = new JTextField(15);
	
	KioskPingCheck pkc = new KioskPingCheck();

	public View() {

		setBounds(100, 100, 500, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		JPanel pane = new JPanel();

		pane.add(buttonStart);
		pane.add(buttonEnd);

		// pane.add(kiosk);
		// pane.add(kioskIP);
		// pane.add(kioskName);
		pane.add(txtKioskIP);
		pane.add(btnConnectKISOK);
		//pane.add(btnDisconnectKISOK);
		btnConnectKISOK.addActionListener(this);
		buttonStart.addActionListener(this);
		btnDisconnectKISOK.addActionListener(this);
		//btnDisconnectKISOK.setEnabled(false);
		
		btnConnectKISOK.addMouseListener(this);
		
		contentPane.add(pane);

		setVisible(true);
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//
//		// 서버연결
//		if (e.getSource() == buttonStart) {
//			System.out.println("서버연결");
//		}
//
//		if (e.getSource() == btnConnectKISOK) {
//			System.out.println(txtKioskIP.getText());
//			String a = txtKioskIP.getText().toString();
//			String[] ip = { a };
//
//			KioskPingCheck.pingCheck(ip);
//			btnConnectKISOK.setEnabled(false);
//			btnDisconnectKISOK.setEnabled(true);
//		}
//		
//		if(e.getSource()==btnDisconnectKISOK){
//			String a = txtKioskIP.getText().toString();
//			String[] ip = { a };
//			KioskPingCheck.pingSleep(ip);
//		}
//
//	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnConnectKISOK){
			String a = txtKioskIP.getText().toString();
			String[] ip = { a };
			System.out.println(a);
			
			pkc.run();
		}
	}	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
