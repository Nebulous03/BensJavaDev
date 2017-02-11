package nebulous.inventory;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class InventoryFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel frame;

	public InventoryFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 527);
		frame = new JPanel();
		frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setLayout(new BorderLayout(0, 0));
		setContentPane(frame);
	}

}
