package nebulous.collegeApp;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FamilyMemberButtonPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private FamilyMemberEditPanel familyPanel;
	
	private int  localIndex = 0;

	public FamilyMemberButtonPanel(int index, FamilyMember member, int xPos){
		
		familyPanel = new FamilyMemberEditPanel(index, member);
		localIndex = index;
		
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(10, 12 + xPos, 320, 100);
		setLayout(null);
		
		JLabel famlilyMemberNameLabel = new JLabel("Name: " + member.getFirstName() + " " + member.getMiddleName() + " "  + member.getLastName());
		famlilyMemberNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		famlilyMemberNameLabel.setBounds(10, 10, 300, 20);
		add(famlilyMemberNameLabel);
		
		JLabel label = new JLabel("Age: " + member.getAge());
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(10, 35, 300, 20);
		add(label);
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				setBackground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setBackground(new Color(0xf1f1f1));
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Now editing panel index: " + localIndex);
				CollegeAppMain.frame.leftPanel.removeAll();
				CollegeAppMain.frame.leftPanel.add(familyPanel);
				CollegeAppMain.frame.leftPanel.validate();
				CollegeAppMain.frame.leftPanel.repaint();
			}
			
		});
	}

}
