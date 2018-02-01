package susmote.CheckIPAddress;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CheckIPAddress extends JFrame {

	private JPanel contentPane;
	private JTextField ipField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckIPAddress frame = new CheckIPAddress();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CheckIPAddress() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 128);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblip = new JLabel("请输入IP地址：");
		lblip.setBounds(12,14,92,15);
		contentPane.add(lblip);
		
		ipField = new JTextField();
		ipField.setBounds(100,10,141,25);
		contentPane.add(ipField);
		
		JButton button = new JButton("验证");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_button_actionPerformed(e);
			}
		});
		button.setBounds(66,57,93,23);
		contentPane.add(button);
	}

	protected void do_button_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String text = ipField.getText();
		String info = matches(text);
		JOptionPane.showMessageDialog(null, info);
	}

	/**
	 * @param text    ip地址
	 * @return	验证结果
	 */
	private String matches(String text) {
		// TODO Auto-generated method stub
		if (text != null && !text.isEmpty()) {
			String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
					+"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
					+"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
					+"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
			if (text.matches(regex)) {
				return text + "\n是一个合法的IP地址！";
			}else {
				return text + "\n不是一个合法的IP地址";
			}
		}
		return "请输入要验证的IP地址";
	}
}
