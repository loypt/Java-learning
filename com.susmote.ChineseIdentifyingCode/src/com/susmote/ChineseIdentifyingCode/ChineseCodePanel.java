package com.susmote.ChineseIdentifyingCode;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ChineseCodePanel extends JPanel {

	/**
	 * coding by susmote
	 */
	private static final long serialVersionUID = -8385760823307807562L;
	public static final int WIDTH = 120;
	public static final int HEIGHT = 35;
	private String num = "";
	Random random = new Random();

	public ChineseCodePanel(){
		this.setVisible(true);
		setLayout(null);
	}

	@Override
	public void paint(Graphics g) {
		String HanZi = "特克斯编程助手集学查用界面设计项目开发等内容于一体";
		BufferedImage image = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics gs = image.getGraphics();
		if(!num.isEmpty()){
			num = "";
		}
		Font font = new Font("黑体", Font.BOLD, 20);
		gs.setFont(font);
		gs.fillRect(0, 0, WIDTH, HEIGHT);
		for (int i = 0; i < 4; i++){
			int index = random.nextInt(HanZi.length());
			String ctmp = HanZi.substring(index, index+1);
			num += ctmp;
			Color color = new Color(20 + random.nextInt(120), 20 + random.nextInt(120), random.nextInt(120));
			gs.setColor(color);
			Graphics2D gs2d = (Graphics2D)gs;
			AffineTransform trans = new AffineTransform();
			trans.rotate(random.nextInt(45) * 3.14 / 180, 22 * i + 8, 7);
			float scaleSize = random.nextFloat() + 0.8f;
			if(scaleSize > 1f){
				scaleSize = 1f;
			}
			trans.scale(scaleSize, scaleSize);
			gs2d.setTransform(trans);
			gs.drawString(ctmp, WIDTH / 6 * i + 28, HEIGHT / 2);
		}
		g.drawImage(image, 0, 0, null);
	}
	public void draw(){
		repaint();
	}
	public String getNum(){
		return num;
	}
}
