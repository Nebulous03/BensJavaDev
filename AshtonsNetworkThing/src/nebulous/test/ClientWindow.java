package nebulous.test;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ClientWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtTest;

	public ClientWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{415, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel textPanel = new JPanel();
		GridBagConstraints gbc_textPanel = new GridBagConstraints();
		gbc_textPanel.insets = new Insets(0, 0, 5, 0);
		gbc_textPanel.fill = GridBagConstraints.BOTH;
		gbc_textPanel.gridx = 0;
		gbc_textPanel.gridy = 0;
		contentPane.add(textPanel, gbc_textPanel);
		GridBagLayout gbl_textPanel = new GridBagLayout();
		gbl_textPanel.columnWidths = new int[]{0, 0};
		gbl_textPanel.rowHeights = new int[]{0, 0};
		gbl_textPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_textPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		textPanel.setLayout(gbl_textPanel);
		
		JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 0;
		textPanel.add(textArea, gbc_textArea);
		
		JPanel inputPanel = new JPanel();
		GridBagConstraints gbc_inputPanel = new GridBagConstraints();
		gbc_inputPanel.fill = GridBagConstraints.BOTH;
		gbc_inputPanel.gridx = 0;
		gbc_inputPanel.gridy = 1;
		contentPane.add(inputPanel, gbc_inputPanel);
		GridBagLayout gbl_inputPanel = new GridBagLayout();
		gbl_inputPanel.columnWidths = new int[]{0, 0};
		gbl_inputPanel.rowHeights = new int[]{0, 0, 0};
		gbl_inputPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_inputPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		inputPanel.setLayout(gbl_inputPanel);
		
		txtTest = new JTextField();
		txtTest.setText("test");
		GridBagConstraints gbc_txtTest = new GridBagConstraints();
		gbc_txtTest.insets = new Insets(0, 0, 5, 0);
		gbc_txtTest.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTest.gridx = 0;
		gbc_txtTest.gridy = 0;
		inputPanel.add(txtTest, gbc_txtTest);
		txtTest.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		inputPanel.add(btnNewButton, gbc_btnNewButton);
	}

}
