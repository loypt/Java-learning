package com.susmote.WatermarkTextFrame;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class WatermarkTextFrame extends JFrame {

	/**
	 * coding by susmote
	 */
	private static final long serialVersionUID = -5807877390115918989L;
	private Image img = null;
	private WatermarkTextPanel watermarkTextPanel = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		WatermarkTextFrame frame = new WatermarkTextFrame();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public WatermarkTextFrame() {
		super();
		URL imgUrl = WatermarkTextFrame.class.getResource("/img/image.jpg");
		img = Toolkit.getDefaultToolkit().getImage(imgUrl);
		watermarkTextPanel = new WatermarkTextPanel();
		this.setBounds(200, 160, 316, 237);
		this.add(watermarkTextPanel);
		this.setTitle("水印文字特效");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class WatermarkTextPanel extends JPanel{
		/**
		 * coding by susmote
		 */
		private static final long serialVersionUID = -2142735044711632762L;

		@Override
		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D)g;
			g2.drawImage(img, 0, 0, 300, 237, this);
			g2.rotate(Math.toRadians(-30));
			Font font = new Font("楷体", Font.BOLD, 60);
			g2.setFont(font);
			g2.setColor(Color.WHITE);
			AlphaComposite alpha = AlphaComposite.SrcOver.derive(0.3f);
			g2.setComposite(alpha);
			g2.drawString("我爱编程", -60, 180);
		}
	}

}
