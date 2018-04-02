package com.susmote.DisturbLineCode;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class DisturbCodePanel extends JPanel {

	/**
	 * coding by susmote
	 */
	private static final long serialVersionUID = -7513719311586950455L;
	public static final int WIDTH = 120;
	public static final int HEIGHT = 35;
	private String num = "";
	Random random = new Random();

	public DisturbCodePanel(){
		this.setVisible(true);
		setLayout(null);
	}

	@Override
	public void paint(Graphics g) {
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics gs = image.getGraphics();
		if(!num.isEmpty()){
			num = "";
		}
		Font font = new Font("黑体", Font.BOLD, 20);
		gs.setFont(font);
		gs.fillRect(0, 0, WIDTH, HEIGHT);
		Image img = null;
		try {
			img = ImageIO.read(new File("src/img/image.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		image.getGraphics().drawImage(img, 0, 0, WIDTH, HEIGHT, null);
		int startX1 = random.nextInt(20);
		int startY1 = random.nextInt(20);
		int startX2 = random.nextInt(30) + 35;
		int startY2 = random.nextInt(10) + 20;
		int startX3 = random.nextInt(30) + 90;
		int startY3 = random.nextInt(10) + 5;
		gs.setColor(Color.RED);
		gs.drawLine(startX1, startY1, startX2, startY2);
		gs.setColor(Color.BLUE);
		gs.drawLine(startX2, startY2, startX3, startY3);
		for (int i = 0; i < 4; i++){
			char ctmp = (char) (random.nextInt(26)+ 65);
			num += ctmp;
			Color color = new Color(20 + random.nextInt(120), 20 + random.nextInt(120), 20 + random.nextInt(120));
			gs.setColor(color);
			Graphics2D gs2d = (Graphics2D) gs;
			AffineTransform trans = new AffineTransform();
			trans.rotate(random.nextInt(45) * 3.14 / 180, 22 * i + 8, 7);
			float scaleSize = random.nextFloat() + 0.8f;
			if (scaleSize > 1f){
				scaleSize = 1f;
			}
			trans.scale(scaleSize, scaleSize);
			gs2d.setTransform(trans);
			gs.drawString(String.valueOf(ctmp), WIDTH / 6 * i + 28, HEIGHT / 2);
		}
		g.drawImage(image, 0, 0, null);
	}
	public void draw(){
		repaint();
	}

	public String getNum() {
		return num;
	}
}

