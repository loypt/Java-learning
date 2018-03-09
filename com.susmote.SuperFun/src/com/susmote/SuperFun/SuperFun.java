package com.susmote.SuperFun;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SuperFun extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8928166578569613279L;
	private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;

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
					SuperFun frame = new SuperFun();
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
	public SuperFun() {
	    setTitle("大乐透号码生成器");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 2, 5, 5));

		JLabel label = new JLabel("请输入号码个数:");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		label.setHorizontalAlignment(SwingConstants.CENTER);
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
	    for (int i = 0;i < times; i++){
	        for (int j = 0; j < 5; j++){
	            List<Integer> list = new ArrayList<Integer>();
	            for (int k = 1; k < 35; k++){
	            	list.add(k);
				}
				int  number = list.get(new Random().nextInt(list.size()));
	            String luckNumber = number < 10 ? "0" + number : "" +number;
	            sb.append(luckNumber + " ");
	            list.remove(new Integer(number));
            }
            sb.append("\t\t");
	        for (int j = 0; j < 2; j++){
				 List<Integer> list = new ArrayList<Integer>();
				 for (int k = 1; k < 13; k++){
				 	list.add(k);
				 }
				 int number = list.get(new Random().nextInt(list.size()));
				 String luckNumber = number < 10 ? "0" + number : "" + number;
				 sb.append(luckNumber + " " );
				 list.remove(new Integer(number));
			}
			sb.append("\n");
        }
        textArea.setText(sb.toString());
    }

}
