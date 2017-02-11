package testing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WindowTesting {
	
	public static JFrame frame;
	public static JButton button;
	public static JTextField textField;
	public static JCheckBox checkBox;
	public static JLabel label;
	
	public static void main(String[] args) {
		
		frame = new JFrame("A new window! :D");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(640, 480);
		frame.setLayout(null);
		
		button = new JButton("BUTTON");
		button.setBounds(20, 20, 200, 100);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText(textField.getText());
			}
			
		});
		
		textField = new JTextField();
		textField.setBounds(20, 140, 200, 40);
		
		checkBox = new JCheckBox("Checkbox");
		checkBox.setBounds(20, 180, 200, 40);
		checkBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(checkBox.isSelected()){
					button.setBackground(Color.RED);
				} else {
					button.setBackground(null);
				}
				
			}
		});
		
		label = new JLabel("Hello World!!!");
		label.setBounds(20, 220, 200, 40);
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		
		frame.add(button);
		frame.add(textField);
		frame.add(checkBox);
		frame.add(label);
		
		frame.setVisible(true);
		
	}

}
