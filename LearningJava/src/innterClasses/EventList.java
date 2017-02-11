package innterClasses;

import java.util.Stack;

public class EventList {
	
	public Stack<Event> events;

	public EventList() {
		events = new Stack<Event>();
	}
	
	public void add(Event event){
		events.push(event);
	}
	
	public void nextEvent(){
		Event e = events.pop();
		e.run();
	}

}
