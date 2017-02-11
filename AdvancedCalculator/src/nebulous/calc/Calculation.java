package nebulous.calc;

public class Calculation {
	
	private String input;
	private String[] calcArray;
	private float result;
	
	public Calculation(String input){
		this.input = input;
		parse();
	}
	
	public void parse(){
		calcArray = input.split("(?=[+-/*])|(?<=[+-/*])");
		for(int i = 0; i < calcArray.length; i++){
			System.out.println("boop");
		}
		System.out.println(result);
	}

}
