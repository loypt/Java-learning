package susmote.SimulationClock;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class SimulationClock extends JFrame {
    

    /**
	 * 
	 */
	private static final long serialVersionUID = -7621111096338218040L;

	/**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SimulationClock frame = new SimulationClock();
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
    public SimulationClock() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent arg0) {
                do_this_windowActivated(arg0);
            }
        });
        setTitle("模拟时钟by susmote");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 300);
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        Rectangle rectangle = getBounds();
        Insets insets = getInsets();
        int radius = 120;
        int x = (rectangle.width - 2 * radius - insets.left - insets.right) / 2 + insets.left;
        int y = (rectangle.height - 2 * radius - insets.top - insets.bottom) / 2 + insets.top;
        Point2D.Double center = new Point2D.Double(x + radius, y + radius);
        g.drawOval(x, y, 2 * radius, 2 * radius);
        Point2D.Double[] scales = new Point2D.Double[60];
        double angle = Math.PI / 30;
        for (int i = 0; i < scales.length; i++) {
            scales[i] = new Point2D.Double();
            scales[i].setLocation(x + radius + radius * Math.sin(angle * i), y + radius - radius * Math.cos(angle * i));
        }
        for (int i = 0; i < scales.length; i++) {
            if (i % 5 == 0) {
                g.setColor(Color.RED);
                g.fillOval((int) scales[i].x - 4, (int) scales[i].y - 4, 8, 8);
            } else {
                g.setColor(Color.CYAN);
                g.fillOval((int) scales[i].x - 2, (int) scales[i].y - 2, 4, 4);
            }
        }
        Calendar calendar = new GregorianCalendar();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.draw(new Line2D.Double(center, scales[second]));
        BasicStroke bs = new BasicStroke(3f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        g2d.setStroke(bs);
        g2d.setColor(Color.blue);
        g2d.draw(new Line2D.Double(center, scales[minute]));
        bs = new BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
        g2d.setStroke(bs);
        g2d.setColor(Color.green);
        g2d.draw(new Line2D.Double(center, scales[hour * 5 + minute / 12]));
    }
    
    private class ClockRunnable implements Runnable {
        
        @Override
        public void run() {
            while (true) {
                repaint();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
        }
        
    }
    
    protected void do_this_windowActivated(WindowEvent arg0) {
        new Thread(new ClockRunnable()).start();
    }
}
