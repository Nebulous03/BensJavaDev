package innterClasses;

public class Main {

	public static void main(String[] args) {
		
		Button button = new Button(){

			@Override
			public void onUse() {
				System.out.println("Hello from inner class! - Button");
			}
			
		};
		
		Switch switch1 = new Switch(){

			@Override
			public void onUse() {
				System.out.println("Hello from inner class! - Switch");
			}
			
		};

		
		button.onUse();
		switch1.onUse();
	}

}
