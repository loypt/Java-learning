package com.susmote.ChineseIdentifyingCode;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame extends JFrame {

	/**
	 * coding by susmote
	 */
	private static final long serialVersionUID = 3158934925369241017L;
	ChineseCodePanel imageCode = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		super();
		setResizable(false);
		setTitle("中文验证码");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 210);
		imageCode = new ChineseCodePanel();
		imageCode.setBounds(170, 85, 106, 35);
		getContentPane().add(imageCode);

		final JPanel panel = new JPanel();
		panel.setLayout(null);
		getContentPane().add(panel, BorderLayout.CENTER);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(imageCode != null){
					imageCode.draw();
				}
			}
		});
		button.setText("换一张");
		button.setBounds(301, 90, 94, 28);
		panel.add(button);

		final JLabel label = new JLabel();
		label.setText("用户名: ");
		label.setBounds(29, 25, 66, 18);
		panel.add(label);

		final JLabel label_1 = new JLabel();
		label_1.setText("密 码: ");
		label_1.setBounds(29, 59, 66, 18);
		panel.add(label_1);

		JTextField nameText = new JTextField();
		nameText.setBounds(85, 23, 310, 22);
		panel.add(nameText);

		JPasswordField pwdText = new JPasswordField();
		pwdText.setBounds(85, 57, 310, 22);
		panel.add(pwdText);

		final JLabel label_1_1 = new JLabel();
		label_1_1.setText("验证码: ");
		label_1_1.setBounds(29, 95, 66, 18);
		panel.add(label_1_1);

		JTextField codeText = new JTextField();
		codeText.setBounds(85, 93, 77, 22);
		panel.add(codeText);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = nameText.getText();
				String password = new String(pwdText.getPassword());
				String code = codeText.getText();
				String info = "";
				if (username == null || username.isEmpty()){
					info = "用户名为空！";
				}
				else if (password == null || password.isEmpty()){
					info = "密码为空！";
				}
				else if (code == null || code.isEmpty()){
					info = "验证码为空!";
				}
				else if (!code.equals(imageCode.getNum())){
					info = "验证码错误！";
				}
				else if (username.equals("特克斯博客") && password.equals("TexTec")){
					info = "恭喜，登录成功";
				}else{
					info = "用户名或密码错误！";
				}
				JOptionPane.showMessageDialog(null, info);
			}
		});
		button_1.setText("登 录");
		button_1.setBounds(42, 134, 106, 28);
		panel.add(button_1);
		final JButton button_1_1 = new JButton();
		button_1_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nameText.setText("");
				pwdText.setText("");
				codeText.setText("");
			}
		});
		button_1_1.setText("重 置");
		button_1_1.setBounds(191, 143, 106, 28);
		panel.add(button_1_1);
	}

}
