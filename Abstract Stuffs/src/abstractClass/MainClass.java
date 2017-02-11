package abstractClass;

import java.util.ArrayList;

public class MainClass {
	
	public static ArrayList<Animal> animals = new ArrayList<Animal>();

	public static void main(String[] args) {
		
		GUI gui = new GUI();
		
		animals.add(new Monkey("Monkey", 1, 1));
		animals.add(new Fish());
		animals.add(new Dog());
		animals.add(new Cat());
		animals.add(new Fox());
		
		int counter = 10;
		
		for(Animal a : animals){
			System.out.println("The " + a.getClass().getSimpleName() + " says " + a.say());
			
			AnimalPanel panel = new AnimalPanel(a.getImgLocation(), a.getScale());
			panel.setBounds(counter, 10, 200, 200);
			counter += 200;
			
			gui.add(panel);
		}
		
		gui.setVisible(true);
	}

}
