package susmote.CheckPhoneNum;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CheckPhoneNum extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField phoneNumField;
	private JTextField ageField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckPhoneNum frame = new CheckPhoneNum();
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
    public CheckPhoneNum() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 260, 190);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblip = new JLabel("姓名：");
        lblip.setBounds(10, 15, 122, 15);
        contentPane.add(lblip);
        
        nameField = new JTextField();
        nameField.setBounds(80, 10, 141, 25);
        contentPane.add(nameField);
        
        JButton button = new JButton("验证");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(90, 119, 93, 23);
        contentPane.add(button);
        
        JLabel label = new JLabel("电话号码：");
        label.setBounds(10, 87, 60, 15);
        contentPane.add(label);
        
        phoneNumField = new JTextField();
        phoneNumField.setBounds(80, 82, 141, 25);
        contentPane.add(phoneNumField);
        
        JLabel label_1 = new JLabel("年龄：");
        label_1.setBounds(10, 50, 122, 15);
        contentPane.add(label_1);
        
        ageField = new JTextField();
        ageField.setBounds(80, 45, 141, 25);
        contentPane.add(ageField);
    }

	protected void do_button_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String text = phoneNumField.getText();
		String info = check(text);
		JOptionPane.showMessageDialog(null, info);
	}

	private String check(String text) {
		// TODO Auto-generated method stub
		if(text == null || text.isEmpty()) {
			return "请输入电话号码：";
		}
		String regex = "^\\d{3}-?||d{8}|\\d{4}-?\\d{8}$";
		if(text.matches(regex)) {
			return text + "\n是一个合法的电话号码!";
		}else {
			return text + "\n不是一个合法的电话号码!";
		}
	}

}
