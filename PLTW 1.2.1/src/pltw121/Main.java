package pltw121;

public class Main {

	public static void main(String[] args) {
		
		String text = "HELLO WORLD!";
		
		MediaFile.writeString(text);
		MediaFile.saveAndClose();
		
	}

}
