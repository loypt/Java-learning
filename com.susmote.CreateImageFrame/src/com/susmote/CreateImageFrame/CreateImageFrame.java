package com.susmote.CreateImageFrame;

import java.awt.*;
import java.awt.image.ImageProducer;
import java.awt.image.MemoryImageSource;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CreateImageFrame extends JFrame {

	/**
	 * coding by susmote
	 */
	private static final long serialVersionUID = 3774668161587162044L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateImageFrame frame = new CreateImageFrame();
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
	public CreateImageFrame() {
		super();
		setTitle("使用像素值生成图像");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 220);
		getContentPane().add(new CreateImagePanel());
	}

	class CreateImagePanel extends JPanel{
		/**
		 * coding by susmote
		 */
		private static final long serialVersionUID = 4690978446118379023L;

		@Override
		public void paint(Graphics g) {
			int w = 300;
			int h = 220;
			int pix[] = new int[w * h];
			int index = 0;
			for (int y = 0; y < h; y++){
				int red = (y * 255) / (h - 1);
				for (int x = 0; x < w; x++){
					int blue = (x * 255) / (w - 1);
					pix[index++] = (255 << 24) | (red << 16) | blue;
				}
			}
			ImageProducer imageProducer = new MemoryImageSource(w, h, pix, 0, w);
			Image img = createImage(imageProducer);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		}
	}

}
