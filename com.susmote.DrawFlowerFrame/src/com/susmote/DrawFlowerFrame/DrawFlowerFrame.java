package com.susmote.DrawFlowerFrame;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawFlowerFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DrawFlowerPanel drawFlowerPanel = new DrawFlowerPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawFlowerFrame frame = new DrawFlowerFrame();
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
	public DrawFlowerFrame() {
		setTitle("绘制花瓣");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 230);
		add(drawFlowerPanel);
	}
	class DrawFlowerPanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = -663535374644690906L;

		@Override
		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.translate(drawFlowerPanel.getWidth() / 2, drawFlowerPanel.getHeight() / 2);

			Ellipse2D.Float ellipse = new Ellipse2D.Float(30, 0, 70, 20);
			Color color = new Color(0, 255, 0);
			g2.setColor(color);
			g2.fill(ellipse);
			int i = 0;
			while (i < 8){
				g2.rotate(30);
				g2.fill(ellipse);
				i++;
			}
			ellipse = new Ellipse2D.Float(20, 0, 60, 15);
			color = new Color(255, 0 ,0);
			g2.setColor(color);
			g2.fill(ellipse);
			i = 0;
			while (i < 15){
				g2.rotate(75);
				g2.fill(ellipse);
				i++;
			}
			ellipse = new Ellipse2D.Float(10, 0, 50, 15);
			color = new Color(255, 255, 0);
			g2.setColor(color);
			g2.fill(ellipse);
			i = 0;
			while (i < 8){
				g2.rotate(30);
				g2.fill(ellipse);
				i++;
			}
			color = new Color(255, 0, 0);
			g2.setColor(color);
			ellipse = new Ellipse2D.Float(-10, -10, 20, 20);
			g2.fill(ellipse);
		}
	}

}
