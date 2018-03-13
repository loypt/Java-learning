package com.susmote.CutImageFrame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.*;

public class CutImageFrame extends JFrame {

	/**
	 * coding by susmote
	 */
	private Image img = null;
	private OldImagePanel oldImagePanel = null;
	private int pressPanelX = 0, pressPanelY = 0;
	private int pressX = 0, pressY = 0;
	private int releaseX = 0, releaseY = 0;
	private Robot robot = null;
	private BufferedImage buffImage = null;
	private CutImagePanel cutImagePanel = new CutImagePanel();
	private boolean flag = false;
	private static final long serialVersionUID = -8164040422234830584L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CutImageFrame frame = new CutImageFrame();
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
	public CutImageFrame() {
		super();
		this.setTitle("裁剪图片");
		URL imgUrl = CutImageFrame.class.getResource("/img/image.jpg");
		img = Toolkit.getDefaultToolkit().getImage(imgUrl);
		oldImagePanel = new OldImagePanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 160, 355, 276);
		final JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerLocation((this.getWidth() / 2) - 10);
		getContentPane().add(splitPane, BorderLayout.CENTER);
		splitPane.setLeftComponent(oldImagePanel);
		splitPane.setRightComponent(cutImagePanel);
		oldImagePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pressPanelX = e.getX();
				pressPanelY = e.getY();
				pressX = e.getXOnScreen() + 1;
				pressY = e.getYOnScreen() + 1;
				flag = true;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				releaseX = e.getXOnScreen() - 1;
				releaseY = e.getYOnScreen() - 1;
				try {
					robot = new Robot();
					if(releaseX - pressX > 0 && releaseY - pressY > 0) {
                        Rectangle rect = new Rectangle(pressX, pressY, releaseX - pressX, releaseY - pressY);
                        buffImage = robot.createScreenCapture(rect);
                        cutImagePanel.repaint();
                    }
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
				flag = false;
			}
		});
		oldImagePanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if(flag){
					releaseX = e.getXOnScreen();
					releaseY = e.getYOnScreen();
					oldImagePanel.repaint();
				}
			}
		});
	}
	class OldImagePanel extends JPanel{
		/**
		 * coding by susmote
		 */
		private static final long serialVersionUID = 4599167238629009582L;

		@Override
		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			g2.setColor(Color.WHITE);
			if(flag){
				float[] arr = { 5.0f };
				BasicStroke stroke = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1.0f, arr, 0);
				g2.setStroke(stroke);
				g2.drawRect(pressPanelX, pressPanelY, releaseX - pressX, releaseY - pressY);
			}
		}
	}
	class CutImagePanel extends JPanel{
		/**
		 * coding by susmote
		 */
		private static final long serialVersionUID = 3626241618061659042L;

		@Override
		public void paint(Graphics g) {
			g.clearRect(0, 0, this.getWidth(), this.getHeight());
			g.drawImage(buffImage, 0, 0, releaseX - pressX, releaseY - pressY, this);
		}
	}

}
