package com.susmote.ArtDesignFrame;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ArtDesignFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6753823382364980954L;
	ArtDesignPanel artDesignPanel = new ArtDesignPanel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ArtDesignFrame frame = new ArtDesignFrame();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public ArtDesignFrame() {
		super();
		setTitle("绘制艺术图案");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 230);
		add(artDesignPanel);
	}
	class ArtDesignPanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 67936637491009735L;

		public void paint (Graphics g){
			Graphics2D g2 = (Graphics2D)g;
			Ellipse2D.Float ellipse = new Ellipse2D.Float(-80, 5, 160, 10);
			Random random = new Random();
			g2.translate(160, 90);
			int R = random.nextInt(256);
			int G = random.nextInt(256);
			int B = random.nextInt(256);
			Color color = new Color(R, G, B);
			g2.setColor(color);
			g2.draw(ellipse);
			int i = 0;
			while (i < 100){
				R = random.nextInt(256);
				G = random.nextInt(256);
				B = random.nextInt(256);
				color = new Color(R, G, B);
				g2.setColor(color);
				g2.rotate(10);
				g2.draw(ellipse);
				i++;
			}
		}
	}

}
