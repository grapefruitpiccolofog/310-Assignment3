package main.java.chat;

import javax.swing.*;
import javax.*;

import java.awt.*;
import java.awt.event.*;

public class swing {
	public static void main (String[] args){
		
		JFrame frame = new JFrame("Test");
		frame.setVisible(true);
		frame.setSize(300,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JLabel label = new JLabel("hello");
		JPanel panel = new JPanel(new GridBagLayout());
		frame.add(panel);
		
		GridBagConstraints c = new GridBagConstraints();
		//c.gridx = 0;
		//c.gridy = 0;
		//panel.add(label, c);
		
		JButton button = new JButton("Send Message");
		c.gridx = 0;
		c.gridy = 0;
		panel.add(button, c);
		button.addActionListener(new Action());
	}	
		static class Action implements ActionListener{
			public void actionPerformed (ActionEvent e){
				JFrame frame2 = new JFrame("Clicked");
				frame2.setVisible(true);
				frame2.setSize(200,200);
				JPanel panel = new JPanel();
				JLabel label = new JLabel("You clicked me!");
				frame2.add(panel);
				panel.add(label);
			}
		}
}
