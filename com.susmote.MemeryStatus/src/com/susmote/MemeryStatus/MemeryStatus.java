package com.susmote.MemeryStatus;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MemeryStatus extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4760637754779640344L;
	private final JPanel statusPanel;
	private final JLabel freeLabel;
	private final JLabel totalLabel;
	private final JScrollPane scrollPane;
	private final JProgressBar progressBar;
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
					MemeryStatus frame = new MemeryStatus();
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
	public MemeryStatus() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				super.windowActivated(e);
				do_this_windowActivated(e);
			}
		});
		setTitle("内存状态");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		statusPanel = new JPanel();
		contentPane.add(statusPanel, BorderLayout.SOUTH);
		statusPanel.setLayout(new GridLayout(2, 1, 5, 5));

		freeLabel = new JLabel("");
		freeLabel.setFont(new Font("微软雅黑" , Font.PLAIN, 18));
		statusPanel.add(freeLabel);

		totalLabel = new JLabel();
		totalLabel.setFont(new Font("微软雅黑" , Font.PLAIN, 18));
		statusPanel.add(totalLabel);

		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setFont(new Font("微软雅黑" , Font.PLAIN, 18));
		progressBar.setOrientation(SwingConstants.VERTICAL);
		scrollPane.setViewportView(progressBar);
	}

	protected void do_this_windowActivated(WindowEvent e) {
		new Thread(new Memory()).start();
	}
	private class Memory implements Runnable{
		@Override
		public void run() {
			while (true){
				System.gc();
				int free = (int) Runtime.getRuntime().freeMemory() / 1024;
				int total = (int) Runtime.getRuntime().totalMemory() / 1024;
				int status = free * 100 / total;
				freeLabel.setText("可用内存： " + free + "kb");
				totalLabel.setText("总共内存： " + total + "kb");
				progressBar.setValue(status);
				progressBar.setString("可用内存: " + status + "%");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
