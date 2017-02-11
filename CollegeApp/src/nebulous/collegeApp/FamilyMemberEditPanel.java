package nebulous.collegeApp;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;

import nebulous.tools.DataHandler;
import nebulous.tools.File;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.border.LineBorder;

public class FamilyMemberEditPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField middleInitial;
	
	private int localIndex = 0;
	
	private File localFile;
	
	private JLabel imageLabel;
	private JTextField age;

	public FamilyMemberEditPanel(int index, FamilyMember member) {
		
		localIndex = index;
		System.out.println("Created new edit panel with index:" + index);
		
		localFile = new File("./res/familyMember_" + localIndex + ".profile");
		localFile.open(); localFile.close();
		
		setVisible(true);
		
		setBorder(BorderFactory.createLineBorder(new Color(0x909090), 1));
		setLayout(null);
		
		firstName = new JTextField();
		firstName.setBounds(27, 54, 333, 32);
		add(firstName);
		firstName.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstName.setBounds(27, 29, 216, 14);
		add(lblFirstName);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender.setBounds(28, 112, 64, 14);
		add(lblGender);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(384, 54, 333, 32);
		add(lastName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(384, 29, 216, 14);
		add(lblLastName);
		
		middleInitial = new JTextField();
		middleInitial.setColumns(10);
		middleInitial.setBounds(740, 54, 77, 32);
		add(middleInitial);
		
		JLabel lblMiddleInitial = new JLabel("Middle Initial:");
		lblMiddleInitial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMiddleInitial.setBounds(740, 29, 83, 14);
		add(lblMiddleInitial);
		
		age = new JTextField();
		age.setText((String) null);
		age.setColumns(10);
		age.setBounds(431, 105, 77, 32);
		add(age);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAge.setBounds(388, 107, 41, 25);
		add(lblAge);
		
		@SuppressWarnings("rawtypes")
		JComboBox gender = new JComboBox();
		gender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gender.setBounds(95, 105, 265, 32);
		add(gender);
		
		JButton save = new JButton("SAVE");
		save.setFont(new Font("Tahoma", Font.PLAIN, 16));
		save.setBounds(27, 445, 172, 58);
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DataHandler.save("FirstName", "./res/familyMember_" + localIndex + ".profile", firstName.getText());
				DataHandler.save("LastName", "./res/familyMember_" + localIndex + ".profile", lastName.getText());
				DataHandler.save("MiddleInitial", "./res/familyMember_" + localIndex + ".profile", middleInitial.getText());
				DataHandler.save("Age", "./res/familyMember_" + localIndex + ".profile", age.getText());
			}
			
		});
		
		add(save);
		
		firstName.setText((String)DataHandler.read("FirstName", "./res/familyMember_" + localIndex + ".profile"));
		lastName.setText((String)DataHandler.read("LastName", "./res/familyMember_" + localIndex + ".profile"));
		middleInitial.setText((String)DataHandler.read("MiddleInitial", "./res/familyMember_" + localIndex + ".profile"));
		age.setText((String)DataHandler.read("Age", "./res/familyMember_" + localIndex + ".profile"));
		
		JPanel imagePanel = new JPanel();
		imagePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		imagePanel.setBounds(533, 106, 283, 331);
		add(imagePanel);
		
		try{
			BufferedImage image = ImageIO.read(new java.io.File((String)DataHandler.read("Image", "./res/familyMember_" + localIndex + ".profile")));
			image = ImageUtils.resizeImage(image, imagePanel.getWidth() - 4, imagePanel.getHeight() - 10);
			ImageIcon icon = new ImageIcon(image);
			imageLabel = new JLabel(icon);
		} catch (Exception e) {
			imageLabel = new JLabel("None");
		}
		
		imagePanel.add(imageLabel);
		
		JPanel box = this;
		
		JButton open = new JButton("Open Image");
		open.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				 JFileChooser chooser = new JFileChooser();
				 chooser.showOpenDialog(box);
				 java.io.File file = chooser.getSelectedFile();
				 imagePanel.removeAll();
				 imagePanel.revalidate();
				 try {
					BufferedImage image = ImageIO.read(file);
					image = ImageUtils.resizeImage(image, imagePanel.getWidth() - 4, imagePanel.getHeight() - 10);
					ImageIcon icon = new ImageIcon(image);
					imageLabel = new JLabel(icon);
					imagePanel.add(imageLabel);
					imagePanel.revalidate();
					imagePanel.repaint();
					DataHandler.save("Image", "./res/profile.profile", file.getAbsolutePath());
				} catch (IOException e1) {
					e1.printStackTrace(); }
				 imagePanel.revalidate();
				 imagePanel.repaint();
			}
			
		});
		
		open.setBounds(595, 457, 179, 38);
		add(open);
	}
	
}
