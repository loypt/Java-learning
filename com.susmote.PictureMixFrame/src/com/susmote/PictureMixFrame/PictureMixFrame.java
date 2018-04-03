package com.susmote.PictureMixFrame;

import java.awt.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PictureMixFrame extends JFrame {

	/**
	 * coding by susmote
	 */
	private static final long serialVersionUID = 497757469307297995L;
	private Image img1 = null;
	private Image img2 = null;
	private JSlider slider = null;
	private PictureMixPanel pictureMixPanel = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PictureMixFrame frame = new PictureMixFrame();
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
	public PictureMixFrame() {
		super();
		URL imgUrl = PictureMixFrame.class.getResource("/img/img.jpg");
		img1 = Toolkit.getDefaultToolkit().getImage(imgUrl);
		imgUrl = PictureMixFrame.class.getResource("/img/imag.jpg");
		img2 = Toolkit.getDefaultToolkit().getImage(imgUrl);
		pictureMixPanel = new PictureMixPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 160, 316, 237);
		this.add(pictureMixPanel);
		this.setTitle("图片融合特效");

		slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				pictureMixPanel.repaint();
			}
		});
		getContentPane().add(slider, BorderLayout.SOUTH);
	}

	class PictureMixPanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = -6466287580522507889L;
		boolean flag = true;
		AlphaComposite alpha = AlphaComposite.SrcOver.derive(0.5f);

		@Override
		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(img1, 0, 0, getWidth(), getHeight(), this);
			float value = slider.getValue();
			float alphaValue = value / 100;
			alpha = AlphaComposite.SrcOver.derive(alphaValue);
			g2.setComposite(alpha);
			g.drawImage(img2, 0, 0, getWidth(), getHeight(), this);

		}
	}

}
