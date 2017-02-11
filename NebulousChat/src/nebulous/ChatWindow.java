package nebulous;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import java.awt.FlowLayout;

public class ChatWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel frame;

	public ChatWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		frame = new JPanel();
		frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frame);
		GridBagLayout gbl_frame = new GridBagLayout();
		gbl_frame.columnWidths = new int[]{0, 0};
		gbl_frame.rowHeights = new int[]{219, 0, 0};
		gbl_frame.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_frame.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		frame.setLayout(gbl_frame);
		
		JPanel chatPane = new JPanel();
		GridBagConstraints gbc_chatPane = new GridBagConstraints();
		gbc_chatPane.insets = new Insets(0, 0, 5, 0);
		gbc_chatPane.fill = GridBagConstraints.BOTH;
		gbc_chatPane.gridx = 0;
		gbc_chatPane.gridy = 0;
		frame.add(chatPane, gbc_chatPane);
		chatPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JTextArea textArea = new JTextArea();
		chatPane.add(textArea);
		
		JPanel inputPane = new JPanel();
		GridBagConstraints gbc_inputPane = new GridBagConstraints();
		gbc_inputPane.fill = GridBagConstraints.BOTH;
		gbc_inputPane.gridx = 0;
		gbc_inputPane.gridy = 1;
		frame.add(inputPane, gbc_inputPane);
	}

}
