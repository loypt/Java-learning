package com.susmote.FillGradientFrame;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FillGradientFrame extends JFrame {

	/**
	 * coding by susmote
	 */
	private static final long serialVersionUID = 3095840986421483864L;
	FillGradientPanel fillGradientPanel = new FillGradientPanel();

	/**
	 * Launch the application.
	 */
    public static void main(String args[]) { 
        FillGradientFrame frame = new FillGradientFrame(); 
        frame.setVisible(true); 
    }

	/**
	 * Create the frame.
	 */
	public FillGradientFrame() {
		setTitle("为图形填充渐变色");
		setBounds(100, 100, 338, 220);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(fillGradientPanel);
	}
	class FillGradientPanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = -1066405748880972799L;

		public void paint(Graphics g){
            Graphics2D g2 = (Graphics2D) g;
            Rectangle2D.Float rect = new Rectangle2D.Float(20, 20, 280, 140);
            GradientPaint paint = new GradientPaint(20, 20, Color.BLUE, 100, 80, Color.RED, true);
            g2.setPaint(paint);
            g2.fill(rect);
        }
	}
}