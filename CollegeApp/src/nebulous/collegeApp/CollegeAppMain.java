package nebulous.collegeApp;

import java.awt.EventQueue;

public class CollegeAppMain {
	
	public static FrameDefault frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame = new FrameDefault();
					frame.setVisible(true);
					
					ThreadHandler.run();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
