package nebulous.calc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField field;
	
	private Calculation calculation;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Calculator() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e){
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 610);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmTest = new JMenuItem("Test");
		mnFile.add(mntmTest);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton b1 = new JButton("1");
		b1.setFont(new Font("Tahoma", Font.BOLD, 16));
		b1.setBounds(10, 127, 75, 75);
		contentPane.add(b1);
		b1.addActionListener(numButListen);
		
		field = new JTextField();
		field.setFont(new Font("Tahoma", Font.BOLD, 16));
		field.setBounds(10, 11, 354, 49);
		contentPane.add(field);
		field.setColumns(10);
		
		JButton b2 = new JButton("2");
		b2.setFont(new Font("Tahoma", Font.BOLD, 16));
		b2.setBounds(95, 127, 75, 75);
		contentPane.add(b2);
		
		JButton b3 = new JButton("3");
		b3.setFont(new Font("Tahoma", Font.BOLD, 16));
		b3.setBounds(180, 127, 75, 75);
		contentPane.add(b3);
		
		JButton b4 = new JButton("4");
		b4.setFont(new Font("Tahoma", Font.BOLD, 16));
		b4.setBounds(10, 213, 75, 75);
		contentPane.add(b4);
		
		JButton b5 = new JButton("5");
		b5.setFont(new Font("Tahoma", Font.BOLD, 16));
		b5.setBounds(95, 213, 75, 75);
		contentPane.add(b5);
		
		JButton b6 = new JButton("6");
		b6.setFont(new Font("Tahoma", Font.BOLD, 16));
		b6.setBounds(180, 213, 75, 75);
		contentPane.add(b6);
		
		JButton b7 = new JButton("7");
		b7.setFont(new Font("Tahoma", Font.BOLD, 16));
		b7.setBounds(10, 299, 75, 75);
		contentPane.add(b7);
		
		JButton b8 = new JButton("8");
		b8.setFont(new Font("Tahoma", Font.BOLD, 16));
		b8.setBounds(95, 299, 75, 75);
		contentPane.add(b8);
		
		JButton b9 = new JButton("9");
		b9.setFont(new Font("Tahoma", Font.BOLD, 16));
		b9.setBounds(180, 299, 75, 75);
		contentPane.add(b9);
		
		JButton add = new JButton("+");
		add.setFont(new Font("Tahoma", Font.BOLD, 16));
		add.setBounds(289, 127, 75, 75);
		contentPane.add(add);
		
		JButton sub = new JButton("-");
		sub.setFont(new Font("Tahoma", Font.BOLD, 17));
		sub.setBounds(289, 213, 75, 75);
		contentPane.add(sub);
		
		JButton dev = new JButton("\u00F7");
		dev.setFont(new Font("Tahoma", Font.BOLD, 17));
		dev.setBounds(289, 299, 75, 75);
		contentPane.add(dev);
		
		JButton mul = new JButton("x");
		mul.setFont(new Font("Tahoma", Font.BOLD, 16));
		mul.setBounds(289, 385, 75, 75);
		contentPane.add(mul);
		
		JButton b0 = new JButton("0");
		b0.setFont(new Font("Tahoma", Font.BOLD, 16));
		b0.setBounds(95, 385, 75, 75);
		contentPane.add(b0);
		
		JButton dot = new JButton(".");
		dot.setFont(new Font("Tahoma", Font.BOLD, 16));
		dot.setBounds(180, 385, 75, 75);
		contentPane.add(dot);
		
		JButton clear = new JButton("CLEAR");
		clear.setFont(new Font("Tahoma", Font.BOLD, 10));
		clear.setBounds(10, 71, 75, 45);
		contentPane.add(clear);
		
		JButton enter = new JButton("ENTER");
		enter.setFont(new Font("Tahoma", Font.BOLD, 18));
		enter.setBounds(10, 471, 354, 75);
		contentPane.add(enter);
	}
	
	
	public ActionListener numButListen = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) getParent();
			field.setText((field.getText() != null ? field.getText() : "") + btn.getText());
		}
		
	};
}
