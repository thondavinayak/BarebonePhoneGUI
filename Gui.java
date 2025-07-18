package phonegui;

import phonegui.DialogBox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Gui extends JFrame implements ActionListener {
    JTextField screen;
    JButton volumeup, volumedown, makecall, endcall;
    JButton zero, one, two, three, four, five, six, seven, eight, nine, star, htag;
    JRadioButton speakeron, speakeroff;
    ButtonGroup speakergroup;
    int volumevalue = 3;
    
    public Gui() {

        this.setLayout(new BorderLayout());

        screen = new JTextField();
        this.add(screen, BorderLayout.NORTH);

        JPanel callpanel = new JPanel();
        callpanel.setLayout(new GridLayout(1,2));
        makecall = new JButton("Make Call");
        makecall.addActionListener(this);
        callpanel.add(makecall);
        endcall = new JButton("End Call");
        endcall.addActionListener(this);
        callpanel.add(endcall);
        callpanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "makecall"));
        this.add(callpanel, BorderLayout.SOUTH);

        JPanel speakerPanel = new JPanel();
        speakerPanel.setLayout(new GridLayout(2,2));
        speakeron = new JRadioButton("Speaker ON");
        speakeroff = new JRadioButton("Speaker OFF");
        speakergroup = new ButtonGroup();
        speakergroup.add(speakeron);
        speakergroup.add(speakeroff);
        speakerPanel.add(speakeron);
        speakerPanel.add(speakeroff);
        speakerPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Speaker"));

        this.add(speakerPanel, BorderLayout.EAST);

        JPanel volumepanel = new JPanel();
        volumepanel.setLayout(new GridLayout(2, 1));
        volumeup = new JButton("UP");
        volumedown = new JButton("DOWN");
        volumedown.addActionListener(this);
        volumeup.addActionListener(this);
        volumepanel.add(volumeup);
        volumepanel.add(volumedown);

        volumepanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Volume"));
        this.add(volumepanel, BorderLayout.WEST);

        zero = new JButton("0");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        star = new JButton("*");
        htag = new JButton("#");
        
        zero.addActionListener(this);
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        star.addActionListener(this);  
        htag.addActionListener(this);  

        JPanel digitpanel = new JPanel();
        digitpanel.setLayout(new GridLayout(4, 3));
        digitpanel.add(one);
        digitpanel.add(two);
        digitpanel.add(three);
        digitpanel.add(four);
        digitpanel.add(five);
        digitpanel.add(six);
        digitpanel.add(seven);
        digitpanel.add(eight);
        digitpanel.add(nine);
        digitpanel.add(star);
        digitpanel.add(zero);
        digitpanel.add(htag);

        this.add(digitpanel, BorderLayout.CENTER);

        this.setTitle("PHONE APPLICATION");
        this.setSize(400, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Gui();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == volumeup) {
			System.out.println(" Volume up button clicked");
			if(volumevalue < 5) {
				volumevalue++;
				screen.setText("Volume increase to " + volumevalue);
			} else {
				JOptionPane.showMessageDialog(this, "The maximum volume is reached", "INFORMATION", JOptionPane.ERROR_MESSAGE);
			}
			//String a = this.getTitle();
			//this.setTitle(" Volume up is pressed");
			//this.setTitle(a);
			
		}
		if(e.getSource() == volumedown) {
			System.out.println(" Volume down button clicked");
			screen.setText("Volume down");
			if(volumevalue != 0) {
				volumevalue--;
				screen.setText("Volume decreased to " + volumevalue);
			} else {
				JOptionPane.showMessageDialog(this, "The volume is zero", "INFORMATION", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource() instanceof JButton) {
			JButton b = (JButton) e.getSource();
			String btext = b.getText();
			if(btext.matches("[0-9,*,#]")) {
				String t = screen.getText();
				t += btext;
				screen.setText(t);
			}
		}
		if(e.getSource() == makecall) {
			
			int ret = JOptionPane.showConfirmDialog(this, "DO you want to make the call", "Confirmation", JOptionPane.YES_NO_OPTION);
			
			if(ret == JOptionPane.OK_OPTION ) {
				System.out.println("Making a call to " + screen.getText());
				String s = screen.getText();
				String s2 = " Making a call to ";
				s2 += s;
				screen.setText(s2);
			} 
			if(ret == JOptionPane.NO_OPTION) {
				screen.setText("");
			}
			
			/*
			JFrame frame = new JFrame();
			//new DialogBox();
			JDialog confirmbox = new JDialog(frame, true);
			confirmbox.setLayout(new FlowLayout());
			confirmbox.setTitle("CONFIRM ACTION");
			confirmbox.getContentPane().setBackground(Color.blue);
			
			JButton ok = new JButton("OK");
			JButton cancel = new JButton("CANCEL");
			ok.addActionListener(this);
			cancel.addActionListener(this);
			confirmbox.add(ok);
			confirmbox.add(cancel);
			
			confirmbox.setSize(300,300);
			confirmbox.setBounds(10, 10, 300, 300);
			confirmbox.setVisible(true);
			confirmbox.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			if(e.getSource() == ok) {
				String s = screen.getText();
				String s2 = " Making a call to ";
				s2 += s;
				screen.setText(s2);
			}
			if(e.getSource() == cancel) {
				screen.setText("");
			}
			*/
		}
		if(e.getSource() == endcall) {
			screen.setText("");
		}
		if(e.getSource() == speakeron) {
			screen.setText(" Speaker is ON");
		}
		if(e.getSource() == speakeroff) {
			screen.setText(" Speaker is OFF");
		}
	}
}
