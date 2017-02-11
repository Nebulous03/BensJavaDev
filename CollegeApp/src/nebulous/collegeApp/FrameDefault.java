package nebulous.collegeApp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import nebulous.tools.DataHandler;
import nebulous.tools.File;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.border.LineBorder;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class FrameDefault extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int currentFamilyPaneDistance = 0;
	public JPanel leftPanel = new JPanel();
	
	private JPanel familyMemberPane;
	
	private int familyIndex = 0;
	
	private JTextField first;
	private JTextField last;
	private JTextField middle;
	private JTextField age;
	private JTextField email;
	private JTextField major;
	
	private File profile;
	
	private static JLabel imageLabel;
	
	public FrameDefault() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		profile = new File("./res/profile.profile");
		profile.open(); profile.close();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320, 180, 1250, 768);
		
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		
		JMenu mnFile = new JMenu("File");
		menu.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		contentPane = new JPanel();
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Profile", panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("First Name:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(25, 26, 216, 14);
		panel.add(label_1);
		
		first = new JTextField();
		first.setText((String) null);
		first.setColumns(10);
		first.setBounds(25, 51, 333, 32);
		panel.add(first);
		
		JLabel label_2 = new JLabel("Last Name:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(382, 26, 216, 14);
		panel.add(label_2);
		
		last = new JTextField();
		last.setText((String) null);
		last.setColumns(10);
		last.setBounds(382, 51, 333, 32);
		panel.add(last);
		
		JLabel label_3 = new JLabel("Middle Initial:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(538, 109, 83, 14);
		panel.add(label_3);
		
		middle = new JTextField();
		middle.setText((String) null);
		middle.setColumns(10);
		middle.setBounds(633, 102, 77, 32);
		panel.add(middle);
		
		JLabel label_4 = new JLabel("Gender:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(26, 109, 64, 14);
		panel.add(label_4);
		
		@SuppressWarnings("rawtypes")
		JComboBox gender = new JComboBox();
		gender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gender.setBounds(93, 102, 265, 32);
		panel.add(gender);
		
		JLabel label_5 = new JLabel("Age:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(386, 104, 41, 25);
		panel.add(label_5);
		
		age = new JTextField();
		age.setText((String) null);
		age.setColumns(10);
		age.setBounds(429, 102, 77, 32);
		panel.add(age);
		
		JButton open = new JButton("Open Image");
		open.setBounds(880, 532, 179, 38);
		panel.add(open);
		
		JPanel imagePanel = new JPanel();
		imagePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		imagePanel.setBounds(742, 49, 437, 461);
		panel.add(imagePanel);
		
		imageLabel = new JLabel();
		
		JButton button_3 = new JButton("SAVE");
		button_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				DataHandler.save("FirstName", "./res/profile.profile", first.getText());
				DataHandler.save("LastName", "./res/profile.profile", last.getText());
				DataHandler.save("MiddleInitial", "./res/profile.profile", middle.getText());
				DataHandler.save("Age", "./res/profile.profile", age.getText());
				DataHandler.save("Email", "./res/profile.profile", email.getText());
				DataHandler.save("Major", "./res/profile.profile", major.getText());
			}
			
		});
		
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_3.setBounds(25, 520, 172, 58);
		panel.add(button_3);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(25, 160, 216, 14);
		panel.add(lblEmail);
		
		email = new JTextField();
		email.setText((String) null);
		email.setColumns(10);
		email.setBounds(25, 185, 333, 32);
		panel.add(email);
		
		major = new JTextField();
		major.setText((String) null);
		major.setColumns(10);
		major.setBounds(382, 185, 333, 32);
		panel.add(major);
		
		JLabel lblMajor = new JLabel("Major:");
		lblMajor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMajor.setBounds(382, 160, 216, 14);
		panel.add(lblMajor);
		JLabel profileLabel = new JLabel("  Profile  ");
		profileLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		tabbedPane.addTab("Family", contentPane);
		JLabel familyLabel = new JLabel("  Family  ");
		familyLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		tabbedPane.setTabComponentAt(0, profileLabel);
		tabbedPane.setTabComponentAt(1, familyLabel);
		
		setContentPane(tabbedPane);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {0, 0, 1};
		gbl_contentPane.rowHeights = new int[] {0, 2};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		GridBagConstraints gbc_leftPanel = new GridBagConstraints();
		gbc_leftPanel.weightx = 1000.0;
		gbc_leftPanel.insets = new Insets(0, 0, 0, 5);
		gbc_leftPanel.fill = GridBagConstraints.BOTH;
		gbc_leftPanel.gridx = 0;
		gbc_leftPanel.gridy = 0;
		contentPane.add(leftPanel, gbc_leftPanel);
		leftPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel rightPanel = new JPanel();
		GridBagConstraints gbc_rightPanel = new GridBagConstraints();
		gbc_rightPanel.anchor = GridBagConstraints.EAST;
		gbc_rightPanel.fill = GridBagConstraints.VERTICAL;
		gbc_rightPanel.gridx = 1;
		gbc_rightPanel.gridy = 0;
		contentPane.add(rightPanel, gbc_rightPanel);
		GridBagLayout gbl_rightPanel = new GridBagLayout();
		gbl_rightPanel.columnWidths = new int[]{0, 0};
		gbl_rightPanel.rowHeights = new int[]{0, 0, 0};
		gbl_rightPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_rightPanel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		rightPanel.setLayout(gbl_rightPanel);
		
		JScrollPane familyMemberScrollPane = new JScrollPane();
		GridBagConstraints gbc_familyMemberScrollPane = new GridBagConstraints();
		familyMemberScrollPane.setPreferredSize(new Dimension(360, 200));
		gbc_familyMemberScrollPane.weighty = 24.0;
		gbc_familyMemberScrollPane.anchor = GridBagConstraints.EAST;
		gbc_familyMemberScrollPane.fill = GridBagConstraints.BOTH;
		gbc_familyMemberScrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_familyMemberScrollPane.gridx = 0;
		gbc_familyMemberScrollPane.gridy = 0;
		familyMemberScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		rightPanel.add(familyMemberScrollPane, gbc_familyMemberScrollPane);
		
		familyMemberPane = new JPanel();
		familyMemberScrollPane.setViewportView(familyMemberPane);
		familyMemberPane.setBackground(new Color(0xf8f8f8));
		familyMemberPane.setPreferredSize(new Dimension(300, 2000));
		
		JLabel label = new JLabel("");
		label.setBounds(0, 23, 0, 0);
		familyMemberPane.setLayout(null);
		familyMemberPane.add(label);
		
		JPanel famlilyMemberAddPane = new JPanel();
		GridBagConstraints gbc_famlilyMemberAddPane = new GridBagConstraints();
		gbc_famlilyMemberAddPane.fill = GridBagConstraints.BOTH;
		gbc_famlilyMemberAddPane.gridx = 0;
		gbc_famlilyMemberAddPane.gridy = 1;
		rightPanel.add(famlilyMemberAddPane, gbc_famlilyMemberAddPane);
		famlilyMemberAddPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		System.out.println(currentFamilyPaneDistance);
		
		JButton button = new JButton("+");
		famlilyMemberAddPane.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				familyIndex++;
				addFamilyPanel(familyIndex, "Test", "Test", "Test");
				DataHandler.save("total", "./res/frameData.data", familyIndex);
			}
			
		});
		
		JButton button_1 = new JButton("-");
		famlilyMemberAddPane.add(button_1);
		
		try {
			@SuppressWarnings("unused")
			String test = (String)DataHandler.read("total", "./res/frameData.data");
		} catch (Exception e) {
			File data = new File("./res/frameData.data");
			data.open(); data.close();
			DataHandler.save("total", "./res/frameData.data", 0);
		}
		
		int index = Integer.parseInt((String)DataHandler.read("total", "./res/frameData.data"));
		System.out.println("Total in loading:" + index);
		
		for(int i = 0; i < index + 1; i++){
			if(i == 0) continue;
			String firstName = ((String)DataHandler.read("FirstName", "./res/familyMember_" + (i) + ".profile"));
			String middleName = ((String)DataHandler.read("MiddleInitial", "./res/familyMember_" + (i) + ".profile"));
			String lastName = ((String)DataHandler.read("LastName", "./res/familyMember_" + (i) + ".profile"));
			
			addFamilyPanel(i, firstName, middleName, lastName);
			familyIndex++;
		}
		
		DataHandler.save("total", "./res/frameData.data", familyIndex);
		
		FrameDefault box = this;
		
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
					e1.printStackTrace();
				}
				 panel.revalidate();
				 panel.repaint();
			}
			
		});
		
		first.setText((String)DataHandler.read("FirstName", "./res/profile.profile"));
		last.setText((String)DataHandler.read("LastName", "./res/profile.profile"));
		middle.setText((String)DataHandler.read("MiddleInitial", "./res/profile.profile"));
		age.setText((String)DataHandler.read("Age", "./res/profile.profile"));
		email.setText((String)DataHandler.read("Email", "./res/profile.profile"));
		major.setText((String)DataHandler.read("Major", "./res/profile.profile"));
		
		try{
			BufferedImage image = ImageIO.read(new java.io.File((String)DataHandler.read("Image", "./res/profile.profile")));
			image = ImageUtils.resizeImage(image, imagePanel.getWidth() - 4, imagePanel.getHeight() - 10);
			ImageIcon icon = new ImageIcon(image);
			imageLabel = new JLabel(icon);
		} catch (Exception e) {
			imageLabel = new JLabel("None");
		}
		
		imagePanel.add(imageLabel);
		
	}
	
	public void addFamilyPanel(int index, String first, String middle, String last){
		FamilyMemberButtonPanel testPane = new FamilyMemberButtonPanel(index, new FamilyMember(first, middle, last, Gender.MALE, 18, 12), currentFamilyPaneDistance);
		currentFamilyPaneDistance += testPane.getHeight() + 12;
		System.out.println(currentFamilyPaneDistance);
		System.out.println(familyMemberPane.getHeight());
		familyMemberPane.add(testPane);
		contentPane.repaint();
	}
	
	public void setLeftPanel(JPanel panel){
		this.leftPanel = panel;
		repaint();
	}
}
