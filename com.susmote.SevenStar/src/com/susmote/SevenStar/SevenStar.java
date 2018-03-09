package com.susmote.SevenStar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SevenStar extends JFrame {

	/**
	 *by susmote
	 */
	private static final long serialVersionUID = -540356640489679528L;
	private final JTextField textField;
	private final JTextArea textArea;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SevenStar frame = new SevenStar();
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
	public SevenStar() {
		setTitle("七星彩号码生成器");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 3, 5, 5));

		JLabel label = new JLabel("请输入号码个数");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		panel.add(label);

		textField = new JTextField();
		textField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		panel.add(textField);
		textField.setColumns(10);

		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);

		JButton button = new JButton("生成号码");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_button_actionPerformed(e);
			}
		});
		button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		buttonPanel.add(button);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		textArea = new JTextArea();
		textArea.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		scrollPane.setViewportView(textArea);
	}
	protected void do_button_actionPerformed(ActionEvent e){
		int times = Integer.parseInt(textField.getText());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < times; i++){
			int number = new Random().nextInt((int) Math.pow(10, 7));
			String luckNumber = "" + number;
			while (luckNumber.length() < 7) {
				luckNumber = "0" + luckNumber;
			}
			sb.append(luckNumber + "\n");
		}
		textArea.setText(sb.toString());
	}

}
