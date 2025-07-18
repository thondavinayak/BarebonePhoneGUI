package phonegui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class DialogBox extends JFrame implements ActionListener {
	JButton ok;
	JButton cancel;
	
	public DialogBox() {
		ok = new JButton("OK");
		cancel = new JButton("CANCEL");
		this.setLayout(new FlowLayout());
		
		this.setSize(200, 200);
		this.setTitle("CONFIRM ACTION");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.getContentPane().setBackground(Color.blue);
		
		ok.addActionListener(this);
		cancel.addActionListener(this);
		this.add(ok);
		this.add(cancel);
	}

	public void actionPerformed(ActionEvent e) {
		
		
	}
	
}
