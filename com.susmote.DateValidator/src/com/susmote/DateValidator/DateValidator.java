package com.susmote.DateValidator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DateValidator extends JFrame {

	/**
	 * by susmote
	 */
	private static final long serialVersionUID = 9119736919010150296L;
	private final JTextField dateTextField;
	private final JTextField formatTextField;
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
					DateValidator frame = new DateValidator();
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
	public DateValidator() {
		setTitle("日期格式检验器");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(3,1,5,5));
		setContentPane(contentPane);

		JPanel datePanel = new JPanel();
		contentPane.add(datePanel);

		JLabel dateLabel = new JLabel("输入日期：");
		datePanel.setFont(new Font("微软雅黑",Font.PLAIN,18));
		datePanel.add(dateLabel);

		dateTextField = new JTextField();
		dateTextField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		datePanel.add(dateTextField);
		dateTextField.setColumns(15);

		JPanel formatPanel = new JPanel();
		contentPane.add(formatPanel);

		JLabel formatLabel = new JLabel("输入格式：");
		formatLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		formatPanel.add(formatLabel);

		formatTextField = new JTextField();
		formatTextField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		formatPanel.add(formatTextField);
		formatTextField.setColumns(15);

		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel);

		JButton button = new JButton("检验");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_button_actionPerformed(e);
			}
		});
		button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		buttonPanel.add(button);
	}
	protected void do_button_actionPerformed(ActionEvent e){
		String date = dateTextField.getText();
		String format = formatTextField.getText();
		if (date.length() == 0 || format.length() == 0) {
			JOptionPane.showMessageDialog(this, "日期或格式不能为空","",JOptionPane.WARNING_MESSAGE);
			return;
		}
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		try {
			formatter.parse(date);
		} catch (ParseException pe) {
			JOptionPane.showMessageDialog(this, "日期格式不能匹配", "" , JOptionPane.WARNING_MESSAGE);
			return;
		}
		JOptionPane.showMessageDialog(this, "日期格式相互匹配", "" , JOptionPane.WARNING_MESSAGE);
	}

}
