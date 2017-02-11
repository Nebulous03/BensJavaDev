package eventHandler;

public class Main {

	public static void main(String[] args) {
		EventList events = new EventList();
		
		Event e1 = new Event(){
			public void run() { System.out.println(events.getSize() + "| Event One!"); }
		}; events.add(e1);
		
		Event e2 = new Event(){
			public void run() { System.out.println(events.getSize() + "| Event Two!"); }
		}; events.add(e2);
		
		Event e3 = new Event(){
			public void run() { System.out.println(events.getSize() + "| Event Three!"); }
		}; events.add(e3);
		
		while(events.hasNextEvent()){
			events.nextEvent();
		}
		
		Event e4 = new Event(){
			public void run() { System.out.println(events.getSize() + "| Event Four!"); }
		}; events.add(e4);
		
		events.nextEvent();
		
		Event e5 = new Event(){

			@Override
			public void run() {
				System.out.println("sgang gbpig rgao[ gaoerj gipae hrllo");
				
			}
			
		}; events.add(e5);
		
		events.nextEvent();
		
	}

}
