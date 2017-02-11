package nebulous.stuff;

public class ArgClass<X,Y> {
	
	private X x;
	private Y y;

	public void thing(){
		System.err.println(x + ", " + y);
	}
	
	public ArgClass(X x, Y y){
		this.x = x;
		this.y = y;
	}
	
}